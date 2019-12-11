package sa.com.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

   private String name;
   private String password;
   private Long id;
   private String phone;
   private String email;
   private RoleDto role;

   public boolean isAdmin() {
      return Objects.equals(role, RoleDto.ADMIN);
   }

   public boolean isUserRole() {
      return Objects.equals(role, RoleDto.USER);
   }
}
