package Start.Mapper;

import Start.DTOs.*;
import Start.Model.*;
import Start.Repository.ClassRoomRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ObjectMapper {

    public List<ClassRoomDto> convertListClassRoomToDto(List<ClassRoom> classRooms){
        return classRooms.stream()
                .map(classRoom-> convertSingleClassRoomToDto(classRoom))
                .collect(Collectors.toList());
    }

    private ClassRoomDto convertSingleClassRoomToDto(ClassRoom classRoom1) {
        ClassRoomDto classRoomDto = new ClassRoomDto();
        classRoomDto.setName(classRoom1.getName());
        return classRoomDto;
    }

    public List<ActivityDto> convertListActivityToDto(List<Activity> activities) {
        return activities.stream()
                .map(activity -> convertSingleActivityToDto(activity))
                .collect(Collectors.toList());
    }

    public List<Activity> convertListActivityDtoToActivity(List<ActivityDto> activityDtos, User user) {
        return activityDtos.stream()
                .map(activity -> convertSingleActivityDtoToActivity(activity, user))
                .collect(Collectors.toList());
    }
    private Activity convertSingleActivityDtoToActivity(ActivityDto activityDto, User user) {
        Activity activity = new Activity();
        activity.setName(activityDto.getName());
        activity.setUsers(List.of(user));
        return activity;
    }

    private ActivityDto convertSingleActivityToDto(Activity activity) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setName(activity.getName());
        return activityDto;
    }

    public UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());

        AddressDto addressDto = new AddressDto();
        addressDto.setStreet(user.getAddress().getStreet());
        userDto.setAddressDto(addressDto);

        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setNumber(user.getPhone().getNumber());
        userDto.setPhoneDto(phoneDto);
        userDto.setClassRoomDtos(convertListClassRoomToDto(user.getClassRoom()));
        userDto.setActivityDtos(convertListActivityToDto(user.getActivity()));
        return userDto;
    }

    public Address convertAddressDtoToAddress(AddressDto addressDto){
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        return address;
    }

    public Phone convertPhoneDtoToPhone(PhoneDto phoneDto) {
        Phone phone = new Phone();
        phone.setNumber(phoneDto.getNumber());
        return phone;
    }
    public List<ClassRoom> convertListClassRoomDtoToListClassRoom(List<ClassRoomDto> classRoomDtos, User user) {
        return classRoomDtos.stream()
                .map(classRoomDto -> convertClassRoomDtoToClassRoom(classRoomDto, user))
                .collect(Collectors.toList());
    }

    private ClassRoom convertClassRoomDtoToClassRoom(ClassRoomDto classRoomDto, User user) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName(classRoomDto.getName());
        classRoom.setUser(user);
        return classRoom;
    }

    public HouseNumber convertHouseNumberDtoToHouseNumber(HouseNumberDto houseNumberDto) {
        HouseNumber houseNumber= new HouseNumber();
        houseNumber.setNumber(houseNumberDto.getName());
        return houseNumber;
    }
}
