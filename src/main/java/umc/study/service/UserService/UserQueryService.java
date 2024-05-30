package umc.study.service.UserService;

import org.springframework.data.domain.Page;
import umc.study.domain.Reviews;
import umc.study.domain.Users;

import java.util.Optional;

public interface UserQueryService {
    Users findById(Long id);

    Optional<Users> findUser(Long id);

    Page<Reviews> getReviewList(Long userId, Integer page);
}
