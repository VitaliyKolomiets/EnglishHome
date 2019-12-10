package sa.com.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sa.com.domain.UserDto;
import sa.com.model.entity.jpa.UserEntity;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = assembler.toEntity(userDto);
        //encrypt password
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return assembler.toDTO(repository.save(userEntity));
    }
}
