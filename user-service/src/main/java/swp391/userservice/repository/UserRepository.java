package swp391.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swp391.entity.User;
import java.util.Optional;

/**
 * Author: Nguyen Tien Thuan
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByCustomerCode(String customerCode);

}
