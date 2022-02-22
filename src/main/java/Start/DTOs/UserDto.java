package Start.DTOs;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String name;
    private String password;
    private AddressDto addressDto;
    private PhoneDto phoneDto;
    private List<ClassRoomDto> classRoomDtos;
    private List<ActivityDto> activityDtos;
}
