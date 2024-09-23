package swp391.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import swp391.userservice.configuration.MessageConfiguration;
import swp391.userservice.dto.reponse.ApiResponse;
import swp391.userservice.dto.reponse.UserDTO;
import swp391.userservice.dto.request.RegisterRequest;
import swp391.userservice.dto.request.UpdateInfoRequest;
import swp391.userservice.service.IUserService;
import swp391.userservice.service.UserService;

/**
 * Author: Nguyen Tien Thuan
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final IUserService userService;

    private final MessageConfiguration messageConfig;

    @Override
    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody @Valid RegisterRequest registerRequest) {
        return new ApiResponse<>(HttpStatus.OK, userService.register(registerRequest), null);
    }

    @Override
    @PutMapping("/update/{id}")
    public ApiResponse<UserDTO> updateInfo(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateInfoRequest updateInfoRequest
    ) {
        return new ApiResponse<>(
                HttpStatus.OK,
                messageConfig.MESSAGE_UPDATE_USER_SUCCESS,
                userService.update(id, updateInfoRequest)
        );
    }

}
