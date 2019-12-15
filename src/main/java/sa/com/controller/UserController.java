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

    @GetMapping("/user")
    public List<UserDto> getUsers() {
        List<UserDto> users = userService.getUsers();
        return users;
    }

    @DeleteMapping("/user")
    public void deleteUser(@PathVariable("id") Long Id) {
        List<UserDto> users = userService.getUsers();

    }
}
