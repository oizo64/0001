package Start.Controller;

import Start.DTOs.UserDto;
import Start.Model.*;
import Start.Repository.*;
import Start.Services.ActivityService;
import Start.Services.ClassRoomService;
import Start.Services.UserService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    private final ClassRoomService classRoomService;
    private final ActivityService activityService;
    private final UserRepo userRepo;
    private final UserService userService;

    public WebController(ClassRoomService classRoomService, ActivityService activityService, UserRepo userRepo, UserService userService) {
        this.classRoomService = classRoomService;
        this.activityService = activityService;
        this.userRepo = userRepo;
        this.userService = userService;
    }


    @GetMapping("/registry")
    public String main(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("classRoomListInput", classRoomService.getAllClassRoom());
        model.addAttribute("activityListInput", activityService.getActivityList());
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("userDto") UserDto userDto, Model model) {
        UserDto userDto1 = (UserDto) model.getAttribute("userDto");
        User user = userService.prepareUserDtoToSave(userDto1);
//        Phone phone = new Phone();
//        phone.setNumber(user1.getPhone().getNumber());
//        phoneRepo.save(phone);
//        HouseNumber houseNumber = new HouseNumber();
//        houseNumber.setNumber(user1.getAddress().getHouseNumber().getNumber());
//        houseNumberRepo.save(houseNumber);
//        Address address = new Address();
//        address.setHouseNumber(houseNumber);
//        address.setStreet(user1.getAddress().getStreet());
//        addressRepo.save(address);
//        address.setStreet(user1.getAddress().getStreet());
//        List<ClassRoom> classRoomList = user1.getClassRoom();
//        classRoomRepo.saveAll(classRoomList);
//        List<Activity> activityList = user1.getActivity();
//        activityRepo.saveAll(activityList);
//        user1.setPhone(phone);
//        user1.setAddress(address);
//        user1.setClassRoom(classRoomList);
//        user1.setActivity(activityList);
        userRepo.save(user);
        return "display_user";
    }
}
