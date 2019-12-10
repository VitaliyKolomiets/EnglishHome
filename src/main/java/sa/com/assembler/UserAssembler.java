package sa.com.assembler;

import org.springframework.stereotype.Component;
import sa.com.domain.UserDto;
import sa.com.model.entity.jpa.UserEntity;

@Component
public class UserAssembler extends AbstractAssembler<UserEntity, UserDto> {

    public UserAssembler() {
        super(UserEntity.class, UserDto.class);
    }
}
