package Start.DTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
    private String name;
    private String password;
    private AddressDto addressDto;
    private PhoneDto phoneDto;
    private List<ClassRoomDto> classRoomDtoList = new ArrayList<>();
    private List<ActivityDto> activityDtoList = new ArrayList<>();
}
