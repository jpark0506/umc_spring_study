package umc.study.service.UserService;

import umc.study.domain.Users;

public interface UserQueryService {
    Users findById(Long id);
}
