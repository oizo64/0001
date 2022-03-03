package Start.Mapper;

import Start.DTOs.ActivityDto;
import Start.Model.Activity;
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
public class ActivityMapperImpl implements ActivityMapper {

    @Override
    public Activity mapToActivity(ActivityDto activityDto) {
        if ( activityDto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setName( activityDto.getName() );

        return activity;
    }

    @Override
    public List<Activity> mapToActivityList(List<ActivityDto> activityDtoList) {
        if ( activityDtoList == null ) {
            return null;
        }

        List<Activity> list = new ArrayList<Activity>( activityDtoList.size() );
        for ( ActivityDto activityDto : activityDtoList ) {
            list.add( mapToActivity( activityDto ) );
        }

        return list;
    }
}
