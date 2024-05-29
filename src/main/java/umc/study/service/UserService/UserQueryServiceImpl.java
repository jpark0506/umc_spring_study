package umc.study.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.exception.handler.TempHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Users;
import umc.study.repository.UserRepository;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND)
        );
    }

}
