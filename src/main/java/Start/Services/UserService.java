package Start.Services;

import Start.DTOs.UserDto;
import Start.Mapper.ObjectMapper;
import Start.Model.*;
import Start.Repository.*;

import org.springframework.stereotype.Service;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.*;
import java.util.stream.Collectors;

@Service
public record UserService(UserRepo userRepo, AddressRepo addressRepo,
                          PhoneRepo phoneRepo, ObjectMapper objectMapper, HouseNumberRepo houseNumberRepo,
                          ClassRoomRepo classRoomRepo, ActivityRepo activityRepo,
                          EntityManager entityManager) {

    public List<UserDto> returnAllUsersDto() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(objectMapper::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    public void addUserDto(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        Phone phone = objectMapper.convertPhoneDtoToPhone(userDto.getPhoneDto());
        phoneRepo.save(phone);
        user.setPhone(phone);
        HouseNumber houseNumber = objectMapper.convertHouseNumberDtoToHouseNumber(userDto.getAddressDto().getHouseNumberDto());
        houseNumberRepo.save(houseNumber);
        Address address = objectMapper.convertAddressDtoToAddress(userDto.getAddressDto());
        address.setHouseNumber(houseNumber);
        addressRepo.save(address);
        user.setAddress(address);
        user.setClassRoom(getClassRooms(userDto, user));
        List<Activity> activities = getActivity(userDto, user);
        user.setActivity(activities);
        for (Activity activity : activities) {
            activity.setUsers(List.of(user));
        }
        userRepo.save(user);

    }

    private List<Activity> getActivity(UserDto userDto, User user) {
        return activityRepo.saveAll(objectMapper.convertListActivityDtoToActivity(userDto.getActivityDtos(), user));
    }

    private List<ClassRoom> getClassRooms(UserDto userDto, User user) {
        return classRoomRepo.saveAll(objectMapper.convertListClassRoomDtoToListClassRoom(userDto.getClassRoomDtos(), user));
    }

    public UserDto returnSingleUsersDto(Long id) {
        return objectMapper.mapUserToUserDto(userRepo.findById(id).orElseThrow());
    }

    public User SingleUserByEntityGraph(Long id) {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("user-name");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetch-graph", entityGraph);
        User user = entityManager.find(User.class, id, properties);

        List<User> allUsersDisplayName = userRepo.findAll();

        return user;

    }
}
