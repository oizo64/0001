package Start.Services;

import Start.Model.Activity;
import Start.Repository.ActivityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ActivityService(ActivityRepo activityRepo) {

    public List<Activity> getActivityList() {
        return activityRepo.findAll();
    }
}
