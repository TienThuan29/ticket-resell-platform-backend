package swp391.userservice.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import swp391.userservice.dto.reponse.ApiResponse;
import swp391.userservice.dto.reponse.UserDTO;
import swp391.userservice.dto.request.AuthenticationRequest;
import swp391.userservice.dto.request.RegisterRequest;
import swp391.userservice.dto.request.UpdateInfoRequest;

/**
 * Author: Nguyen Tien Thuan
 */
public interface IUserService {

    ApiResponse<UserDTO> getById(Long id);

    ApiResponse<?> updateAvatar(Long id, MultipartFile file);

    ApiResponse<?> updateIsSeller(Long id);

    ApiResponse<UserDTO> authenticate(AuthenticationRequest authenticationRequest);

    ApiResponse<?> register(RegisterRequest registerRequest);

    ApiResponse<UserDTO> update(Long id, UpdateInfoRequest updateInfoRequest);

}
