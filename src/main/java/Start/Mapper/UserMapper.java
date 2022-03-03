package Start.Mapper;

import Start.DTOs.UserDto;
import Start.Model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "addressDto", target = "address")
    @Mapping(source = "phoneDto", target = "phone")
    @Mapping(source = "classRoomDtoList", target = "classRoom")
    @Mapping(source = "activityDtoList", target = "activity")
    User mapToUser(UserDto userDto);

    @AfterMapping
    default void fillOtherData(@MappingTarget User user, UserDto userDto) {

    }


    @InheritInverseConfiguration(name = "mapToUser")
    UserDto mapToUserDto(User user);

    List<User> mapToUserList(List<UserDto> userDtoList);

    List<UserDto> mapToUserDtoList(List<User> user);
}
