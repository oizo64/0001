package Start.Mapper;

import Start.DTOs.ActivityDto;
import Start.Model.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    @Mapping(source = "name", target = "name")
    Activity mapToActivity(ActivityDto activityDto);
    List<Activity> mapToActivityList(List<ActivityDto> activityDtoList);
}
