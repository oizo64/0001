package Start.Services;

import Start.DTOs.UserDto;
import Start.DTOs.UserDtoTest;
import Start.Mapper.*;
import Start.Model.*;
import Start.Repository.*;

import org.springframework.stereotype.Service;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.*;

@Service
public record UserService(UserRepo userRepo, AddressRepo addressRepo,
                          PhoneRepo phoneRepo, ObjectMapper objectMapper,
                          HouseNumberRepo houseNumberRepo,
                          ClassRoomRepo classRoomRepo, ActivityRepo activityRepo,
                          EntityManager entityManager, UserRepoTest userRepoTest,
                          UserMapper userMapper, PhoneMapper phoneMapper,
                          HouseNumberMapper houseNumberMapper, AddressMapper addressMapper,
                          ClassRoomMapper classRoomMapper, ActivityMapper activityMapper) {


    public List<UserDto> returnAllUsersDto() {
        return userMapper.mapToUserDtoList(userRepo.findAll());
    }

    public void addUserDto(UserDto userDto) {
        User user = prepareUserDtoToSave(userDto);
        userRepo.save(user);
    }

    public User prepareUserDtoToSave(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        Phone phone = phoneMapper.mapToPhone(userDto.getPhoneDto());
        phoneRepo.save(phone);
        user.setPhone(phone);
        HouseNumber houseNumber = houseNumberMapper.mapToHouseNumber(userDto.getAddressDto().getHouseNumberDto());
        houseNumberRepo.save(houseNumber);
        Address address = addressMapper.mapToAddress(userDto.getAddressDto());
        address.setHouseNumber(houseNumber);
        addressRepo.save(address);
        user.setAddress(address);
        userRepo.save(user);
        user.setClassRoomWithId(classRoomMapper.mapToClassRoomList(userDto.getClassRoomDtoList()), user);
        List<Activity> activities = activityMapper.mapToActivityList(userDto.getActivityDtoList());
        user.setActivity(activities);
        for (Activity activity : activities) {
            activity.setUsers(List.of(user));
        }
        return user;
    }

    public UserDto returnSingleUsersDto(Long id) {
        return objectMapper.mapUserToUserDto(userRepo.findById(id).orElseThrow());
    }

    public UserDtoTest returnUserById(Long id) {
        Optional<UserDtoTest> byId = userRepoTest.findById(id);
        return byId.orElse(null);
    }

    public User singleUserByEntityGraph(Long id) {
        EntityGraph<?> graph = entityManager.getEntityGraph("graph.user.classroom");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetch-graph", graph);
        return entityManager.find(User.class, id, hints);
    }
}
