package Start.Mapper;

import Start.DTOs.*;
import Start.Model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ObjectMapper {

    public List<ClassRoomDto> convertListClassRoomToDto(List<ClassRoom> classRooms){
        return classRooms.stream()
                .map(this::convertSingleClassRoomToDto)
                .collect(Collectors.toList());
    }

    private ClassRoomDto convertSingleClassRoomToDto(ClassRoom classRoom1) {
        ClassRoomDto classRoomDto = new ClassRoomDto();
        classRoomDto.setName(classRoom1.getName());
        return classRoomDto;
    }

    public List<ActivityDto> convertListActivityToDto(List<Activity> activities) {
        return activities.stream()
                .map(this::convertSingleActivityToDto)
                .collect(Collectors.toList());
    }

    public List<Activity> convertListActivityDtoToActivity(List<ActivityDto> activityDtos, UserDto userDto) {
        return activityDtos.stream()
                .map(activity -> convertSingleActivityDtoToActivity(activity, userDto))
                .collect(Collectors.toList());
    }
    private Activity convertSingleActivityDtoToActivity(ActivityDto activityDto, UserDto userDto) {
        Activity activity = new Activity();
        activity.setName(activityDto.getName());
//        activity.setUsers(List.of(simpleUserConvertToUserDto(userDto)));
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
        userDto.setClassRoomDtoList(convertListClassRoomToDto(user.getClassRoom()));
        userDto.setActivityDtoList(convertListActivityToDto(user.getActivity()));
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
    public List<ClassRoom> convertListClassRoomDtoToListClassRoom(List<ClassRoomDto> classRoomDtos, UserDto userDto) {
        return classRoomDtos.stream()
                .map(classRoomDto -> convertClassRoomDtoToClassRoom(classRoomDto, userDto))
                .collect(Collectors.toList());
    }

    private ClassRoom convertClassRoomDtoToClassRoom(ClassRoomDto classRoomDto, UserDto userDto) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName(classRoomDto.getName());
//        classRoom.setUser(simpleUserConvertToUserDto(userDto));
        return classRoom;
    }

    public HouseNumber convertHouseNumberDtoToHouseNumber(HouseNumberDto houseNumberDto) {
        HouseNumber houseNumber= new HouseNumber();
        houseNumber.setNumber(houseNumberDto.getNumber());
        return houseNumber;
    }

}
