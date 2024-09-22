package swp391.userservice.controller;

import org.springframework.http.ResponseEntity;
import swp391.userservice.dto.reponse.Response;
import swp391.userservice.dto.request.RegisterRequest;
import swp391.userservice.dto.request.UpdateInfoRequest;

/**
 * Author: Nguyen Tien Thuan
 */
public interface IUserController {

    ResponseEntity<Response> register(RegisterRequest registerRequest);

    ResponseEntity<Response> updateInfo(Long id, UpdateInfoRequest updateInfoRequest);

}
