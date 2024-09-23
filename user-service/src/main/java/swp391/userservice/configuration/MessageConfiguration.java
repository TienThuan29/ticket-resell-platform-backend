package swp391.userservice.configuration;

import org.springframework.stereotype.Component;

/**
 * Author: Nguyen Tien Thuan
 */
@Component("userServiceMessageConfiguration")
public class MessageConfiguration {

    // Error message

    public final String ERROR_USERNAME_EXIST = "Tên đăng nhập đã tồn tại!";
    public final String ERROR_REGISTER_FAIL = "Đăng ký không thành công!";
    public final String ERROR_REGISTER_SUCCESS = "Đăng ký thành công!";
    public final String ERROR_NOT_FOUND_USERID = "Không thể tìm thấy người dùng";
    public final String ERROR_INVALID_USERNAME_PASSWORD = "Tên đăng nhập hoặc mật khẩu không đúng";

    // Success message
    public final String MESSAGE_UPDATE_USER_SUCCESS = "Cập nhật thông tin thành công";



}
