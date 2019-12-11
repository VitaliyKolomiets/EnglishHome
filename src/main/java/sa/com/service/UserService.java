package sa.com.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sa.com.assembler.UserAssembler;
import sa.com.domain.UserDto;
import sa.com.model.entity.jpa.UserEntity;
import sa.com.repository.jpa.UsersRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserAssembler userAssembler;
    private final UsersRepository usersRepository;

    public UserDto createUser(UserDto userDto) {

        UserEntity userEntity = userAssembler.toEntity(userDto);
        UserEntity  userEntity1 = usersRepository.save(userEntity);
        return userAssembler.toDTO(userEntity1);
    }
}
