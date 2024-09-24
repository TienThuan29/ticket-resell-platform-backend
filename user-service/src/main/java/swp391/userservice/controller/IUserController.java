package swp391.userservice.controller;

import org.springframework.http.ResponseEntity;
import swp391.userservice.dto.reponse.ApiResponse;
import swp391.userservice.dto.request.RegisterRequest;
import swp391.userservice.dto.request.UpdateInfoRequest;

/**
 * Author: Nguyen Tien Thuan
 */
public interface IUserController {

    ApiResponse<?> register(RegisterRequest registerRequest);

    ApiResponse<?> updateInfo(Long id, UpdateInfoRequest updateInfoRequest);

}
