package sa.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.com.domain.UserDto;
import sa.com.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/consumer")
@RequiredArgsConstructor
public class ConsumerController {

    private final UserService userService;

    @GetMapping()
    public List<UserDto> getUsers(){
        return userService.getAllUser();
    }
}
