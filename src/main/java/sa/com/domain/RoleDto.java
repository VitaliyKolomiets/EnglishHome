package sa.com.domain;


import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public enum RoleDto {

    ADMIN("ADMIN"),
    USER("USER");

    RoleDto(String user) {

    }

    public static RoleDto parse(String value) {
        RoleDto role = null;
        if (value != null && value.length() != 0) {
            for (RoleDto current : RoleDto.values()) {
                if (current.name().equalsIgnoreCase(value)) {
                    role = current;
                    break;
                }
            }
        }
        return role;
    }

    public static List<RoleDto> parseList(String... values) {
        List<RoleDto> roles = null;
        if (values != null && values.length != 0) {
            roles = new ArrayList<>(values.length);
            for (String value : values) {
                RoleDto role = parse(value);
                if (role != null) {
                    roles.add(role);
                }
            }
        }
        return roles;
    }
}