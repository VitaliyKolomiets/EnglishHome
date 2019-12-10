package sa.com.model.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sa.com.domain.RoleDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "User")
@Table(name = "users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -622037279985304536L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column(name = "mail")
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleDto role;

    @Column
    @Builder.Default
    private boolean deleted = false;

    public boolean isAdmin() {
        return RoleDto.ADMIN.equals(role);
    }

}
