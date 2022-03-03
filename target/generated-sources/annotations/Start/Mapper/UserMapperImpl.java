package Start.Mapper;

import Start.DTOs.ActivityDto;
import Start.DTOs.AddressDto;
import Start.DTOs.ClassRoomDto;
import Start.DTOs.PhoneDto;
import Start.DTOs.UserDto;
import Start.Model.Activity;
import Start.Model.Address;
import Start.Model.ClassRoom;
import Start.Model.Phone;
import Start.Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T22:14:48+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userDto.getName() );
        user.setPassword( userDto.getPassword() );
        user.setAddress( addressDtoToAddress( userDto.getAddressDto() ) );
        user.setPhone( phoneDtoToPhone( userDto.getPhoneDto() ) );
        user.setClassRoom( classRoomDtoListToClassRoomList( userDto.getClassRoomDtoList() ) );
        user.setActivity( activityDtoListToActivityList( userDto.getActivityDtoList() ) );

        fillOtherData( user, userDto );

        return user;
    }

    @Override
    public UserDto mapToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( user.getName() );
        userDto.setPassword( user.getPassword() );
        userDto.setAddressDto( addressToAddressDto( user.getAddress() ) );
        userDto.setPhoneDto( phoneToPhoneDto( user.getPhone() ) );
        userDto.setClassRoomDtoList( classRoomListToClassRoomDtoList( user.getClassRoom() ) );
        userDto.setActivityDtoList( activityListToActivityDtoList( user.getActivity() ) );

        return userDto;
    }

    @Override
    public List<User> mapToUserList(List<UserDto> userDtoList) {
        if ( userDtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtoList.size() );
        for ( UserDto userDto : userDtoList ) {
            list.add( mapToUser( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> mapToUserDtoList(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( user.size() );
        for ( User user1 : user ) {
            list.add( mapToUserDto( user1 ) );
        }

        return list;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressDto.getStreet() );

        return address;
    }

    protected Phone phoneDtoToPhone(PhoneDto phoneDto) {
        if ( phoneDto == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setNumber( phoneDto.getNumber() );

        return phone;
    }

    protected ClassRoom classRoomDtoToClassRoom(ClassRoomDto classRoomDto) {
        if ( classRoomDto == null ) {
            return null;
        }

        ClassRoom classRoom = new ClassRoom();

        classRoom.setName( classRoomDto.getName() );

        return classRoom;
    }

    protected List<ClassRoom> classRoomDtoListToClassRoomList(List<ClassRoomDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ClassRoom> list1 = new ArrayList<ClassRoom>( list.size() );
        for ( ClassRoomDto classRoomDto : list ) {
            list1.add( classRoomDtoToClassRoom( classRoomDto ) );
        }

        return list1;
    }

    protected Activity activityDtoToActivity(ActivityDto activityDto) {
        if ( activityDto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setName( activityDto.getName() );

        return activity;
    }

    protected List<Activity> activityDtoListToActivityList(List<ActivityDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Activity> list1 = new ArrayList<Activity>( list.size() );
        for ( ActivityDto activityDto : list ) {
            list1.add( activityDtoToActivity( activityDto ) );
        }

        return list1;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setStreet( address.getStreet() );

        return addressDto;
    }

    protected PhoneDto phoneToPhoneDto(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setNumber( phone.getNumber() );

        return phoneDto;
    }

    protected ClassRoomDto classRoomToClassRoomDto(ClassRoom classRoom) {
        if ( classRoom == null ) {
            return null;
        }

        ClassRoomDto classRoomDto = new ClassRoomDto();

        classRoomDto.setName( classRoom.getName() );

        return classRoomDto;
    }

    protected List<ClassRoomDto> classRoomListToClassRoomDtoList(List<ClassRoom> list) {
        if ( list == null ) {
            return null;
        }

        List<ClassRoomDto> list1 = new ArrayList<ClassRoomDto>( list.size() );
        for ( ClassRoom classRoom : list ) {
            list1.add( classRoomToClassRoomDto( classRoom ) );
        }

        return list1;
    }

    protected ActivityDto activityToActivityDto(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        ActivityDto activityDto = new ActivityDto();

        activityDto.setName( activity.getName() );

        return activityDto;
    }

    protected List<ActivityDto> activityListToActivityDtoList(List<Activity> list) {
        if ( list == null ) {
            return null;
        }

        List<ActivityDto> list1 = new ArrayList<ActivityDto>( list.size() );
        for ( Activity activity : list ) {
            list1.add( activityToActivityDto( activity ) );
        }

        return list1;
    }
}
