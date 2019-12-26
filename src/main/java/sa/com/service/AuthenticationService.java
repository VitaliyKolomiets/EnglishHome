package sa.com.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sa.com.assembler.UserAssembler;
import sa.com.domain.UserDto;
import sa.com.exeption.FoodServiceException;
import sa.com.exeption.ServiceErrorCode;
import sa.com.repository.jpa.UsersRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsersRepository usersRepository;

    public UserDto getAuthorisedUser() {
        log.debug("Try to get authorised user from security context");

        UserDto authorizedUser = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(UserDetails.class::cast)
                .map(UserDetails::getUsername)
                .map(usersRepository::findByEmail)
                .map(UserAssembler::createDto)
                .orElseThrow(() -> new FoodServiceException(
                        "Trying to send queries to API without login.", ServiceErrorCode.PERMISSION_DENIED));

        log.debug("Authorised user [{}] is loaded from security context", authorizedUser);
        return authorizedUser;
    }
}
