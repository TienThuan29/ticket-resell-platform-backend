package swp391.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp391.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

}
