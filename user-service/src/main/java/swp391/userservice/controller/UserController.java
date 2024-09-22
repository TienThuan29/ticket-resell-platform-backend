package swp391.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swp391.userservice.dto.reponse.Response;
import swp391.userservice.dto.request.RegisterRequest;
import swp391.userservice.dto.request.UpdateInfoRequest;
import swp391.userservice.service.UserService;

/**
 * Author: Nguyen Tien Thuan
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final UserService userService;

    @Override
    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterRequest registerRequest) {
        String message = userService.register(registerRequest);
        return ResponseEntity.ok(Response.builder()
                .httpStatus(HttpStatus.OK)
                .message("")
                .object(message)
                .build()
        );
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateInfo(
            @PathVariable("id") Long id,
            @RequestBody UpdateInfoRequest updateInfoRequest
    ) {
        String message = userService.update(id, updateInfoRequest);
        return ResponseEntity.ok(Response.builder()
                .httpStatus(HttpStatus.OK)
                .message("")
                .object(message)
                .build()
        );
    }
}
