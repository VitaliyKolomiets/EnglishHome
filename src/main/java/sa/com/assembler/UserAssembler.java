package sa.com.assembler;


import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;
import sa.com.domain.UserDto;
import sa.com.model.entity.jpa.UserEntity;

@Component
public class UserAssembler extends AbstractAssembler<UserEntity, UserDto> {

    private static Mapper DOZER_MAPPER = DozerBeanMapperSingletonWrapper.getInstance();

    public UserAssembler() {
        super(UserEntity.class, UserDto.class);
    }

    public static UserDto createDto(UserEntity user) {
        return DOZER_MAPPER.map(user, UserDto.class);
    }
}
