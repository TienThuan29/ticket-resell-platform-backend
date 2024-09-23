package swp391.userservice.service;

import swp391.userservice.dto.reponse.UserDTO;
import swp391.userservice.dto.request.RegisterRequest;
import swp391.userservice.dto.request.UpdateInfoRequest;

/**
 * Author: Nguyen Tien Thuan
 */
public interface IUserService {

    String register(RegisterRequest registerRequest);

    UserDTO update(Long id, UpdateInfoRequest updateInfoRequest);

}
