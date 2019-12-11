package sa.com.domain;

import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto implements Serializable {

   @DecimalMin(value = "1")
   private Long id;

   @NotBlank
   @Size(min = 2, max = 60)
   private String companyName;

   private String password;

   @NotBlank
   @Size(min = 4, max = 60)
   private String phone;

   @Email
   @NotBlank
   private String email;

   @NotNull
   private RoleDto role;

   public boolean isAdmin() {
      return Objects.equals(role, RoleDto.ADMIN);
   }

   public boolean isUserConsumerRole() {
      return Objects.equals(role, RoleDto.USER_CONSUMER);
   }

   public boolean isUserProducerRole() {
      return Objects.equals(role, RoleDto.USER_PRODUCER);
   }

}
