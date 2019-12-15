package sa.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sa.com.domain.UserDto;
import sa.com.model.entity.jpa.UserEntity;
import sa.com.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDto createUser(@RequestBody UserDto userDto) {
       return userService.createUser(userDto);
    }
    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUsers(id);
    }

    @GetMapping("/user/{companyName}")
    public UserDto getUser(@PathVariable("companyName") String companyName){
        return userService.getUser(companyName);
    }
    @PutMapping("/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }
}
