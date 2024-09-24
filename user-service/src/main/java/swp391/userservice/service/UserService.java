package swp391.userservice.service;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import swp391.entity.User;
import swp391.entity.fixed.Role;
import swp391.userservice.configuration.MessageConfiguration;
import swp391.userservice.dto.reponse.ApiResponse;
import swp391.userservice.dto.reponse.UserDTO;
import swp391.userservice.dto.request.AuthenticationRequest;
import swp391.userservice.dto.request.RegisterRequest;
import swp391.userservice.dto.request.UpdateInfoRequest;
import swp391.userservice.exception.def.NotFoundException;
import swp391.userservice.mapper.UserMapper;
import swp391.userservice.repository.UserRepository;
import java.util.UUID;

/**
 * Author: Nguyen Tien Thuan
 */
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final MessageConfiguration messageConfig;

    private final UserMapper userMapper;

    @Override
    public ApiResponse<UserDTO> getById(Long id) {
        var user = userRepository.findById(id);
        return new ApiResponse<>(HttpStatus.OK, "", userMapper.toUserDTO(user.get()));
    }


    @Override
    public ApiResponse<UserDTO> authenticate(AuthenticationRequest authRequest) {
        var user = userRepository.findByUsername(authRequest.getUsername());
        var encodePassword = BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt());
        if (user.isPresent() && user.get().getPassword().equals(encodePassword)) {
            return new ApiResponse<>(HttpStatus.OK, "", userMapper.toUserDTO(user.get()));
        }
        else {
            return new ApiResponse<>(HttpStatus.FORBIDDEN, messageConfig.ERROR_INVALID_USERNAME_PASSWORD, null);
        }
    }

    @Override
    public ApiResponse<?> register(RegisterRequest registerRequest) {
        var user = userRepository.findByUsername(registerRequest.getUsername());
        if (user.isPresent())
            return new ApiResponse<>(HttpStatus.CONFLICT, messageConfig.ERROR_USERNAME_EXIST, null);
        userRepository.save(
                User.builder()
                        .username(registerRequest.getUsername())
                        .password(BCrypt.hashpw(registerRequest.getPassword(), BCrypt.gensalt()))
                        .email(registerRequest.getEmail())
                        .customerCode(this.randomCustomerCode())
                        .balance(0L)
                        .firstname(registerRequest.getFirstname())
                        .lastname(registerRequest.getLastname())
                        .isEnable(Boolean.FALSE)  // Before verify by email code
                        .isSeller(Boolean.FALSE)
                        .revenue(0L)
                        .roleCode(Role.USER)
                        .build()
        );
        return new ApiResponse<>(HttpStatus.CREATED, messageConfig.ERROR_REGISTER_SUCCESS, null);
    }

    @Override
    public ApiResponse<UserDTO> update(Long id, UpdateInfoRequest updateInfoRequest) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(messageConfig.ERROR_NOT_FOUND_USERID)
        );
        user.setFirstname(updateInfoRequest.getFirstname());
        user.setLastname(updateInfoRequest.getLastname());
        user.setPhone(updateInfoRequest.getPhone());
        user.setEmail(updateInfoRequest.getEmail());
        return new ApiResponse<>(
                HttpStatus.NO_CONTENT,
                messageConfig.MESSAGE_UPDATE_USER_SUCCESS,
                userMapper.toUserDTO(userRepository.save(user))
        );
    }

    private String randomCustomerCode() {
        String customerCode;
        do {
            customerCode = UUID.randomUUID().toString().substring(1,8) + UUID.randomUUID().toString().substring(1,3);
        } while (isExistCustomerCode((customerCode)));
        return customerCode;
    }

    private boolean isExistCustomerCode(String customerCode) {
        return userRepository.findByCustomerCode(customerCode).isPresent();
    }
}
