package umc.study.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.domain.Users;
import umc.study.repository.UserRepository;

@Service
public class UserQueryServiceImpl {
    @Autowired
    private UserRepository userRepository;
// JPA만으로도 findById 가능하다.
    public Users findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
