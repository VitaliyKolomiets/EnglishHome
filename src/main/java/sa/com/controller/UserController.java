package sa.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.com.domain.UserDto;
import sa.com.service.UserService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = new UserDto();
//


        return userService.createUser(userDto);
    }
}
