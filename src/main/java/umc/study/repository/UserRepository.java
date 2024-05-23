package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Users;

public interface UserRepository extends JpaRepository<Users,Long> {

}
