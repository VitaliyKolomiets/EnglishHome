package sa.com.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import sa.com.model.entity.jpa.UserEntity;

@Transactional
public interface UsersRepository extends SoftDeleteRepository<UserEntity, Long> {

    public UserEntity getUserByCompanyName(String companyName);

    public UserEntity findByEmail(String email);
}
