package sa.com.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sa.com.assembler.UserAssembler;
import sa.com.domain.UserDto;
import sa.com.model.entity.jpa.UserEntity;
import sa.com.repository.jpa.UsersRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserAssembler userAssembler;
    private final UsersRepository usersRepository;

    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userAssembler.toEntity(userDto);
        return userAssembler.toDTO(usersRepository.save(userEntity));
    }

    public List<UserDto> getUsers() {

        List<UserEntity> userEntities = usersRepository.findAll();
        List<UserDto> userDtos = userAssembler.toDTOs(userEntities);

        return userDtos;
    }

    public UserDto getUser(String companyName) {
        UserEntity userEntity = usersRepository.getUserByCompanyName(companyName);
        UserDto userDto = userAssembler.toDTO(userEntity);

        return userDto;
    }

    public UserDto updateUser(UserDto userDto){
        UserEntity userEntity = userAssembler.toEntity(userDto);
        return userAssembler.toDTO(usersRepository.save(userEntity));
    }

    public void deleteUsers(Long id) {
            usersRepository.deleteById(id);

    }
}
