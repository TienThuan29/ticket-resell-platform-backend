package swp391.userservice.service;

import swp391.userservice.dto.request.RegisterRequest;
import swp391.userservice.dto.request.UpdateInfoRequest;

/**
 * Author: Nguyen Tien Thuan
 */
public interface IUserService {

    String register(RegisterRequest registerRequest);

    String update(Long id, UpdateInfoRequest updateInfoRequest);

}
