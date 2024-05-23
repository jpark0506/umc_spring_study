package umc.study.service.UserService;

import umc.study.domain.Users;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserRequestDTO.JoinDTO;

public interface UserCommandService {

    Users joinUser(JoinDTO request);
}
