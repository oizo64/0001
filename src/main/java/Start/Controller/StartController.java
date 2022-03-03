package Start.Controller;

import Start.DTOs.UserDto;
import Start.DTOs.UserDtoTest;
import Start.Model.ClassRoom;
import Start.Model.User;
import Start.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StartController {
    private final UserService userService;
    @Autowired
    public StartController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUserDto(){
        return userService.returnAllUsersDto();
    }
    @GetMapping("/user/{id}")
    public UserDto getSingleUserDto(@PathVariable Long id) {
        return userService.returnSingleUsersDto(id);
    }

    @GetMapping("/userbyentitygraph/{id}")
    public User getSingleUserByEntityGraph(@PathVariable Long id) {
        return userService.singleUserByEntityGraph(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDto userDto){
        userService.addUserDto(userDto);
    }


}
