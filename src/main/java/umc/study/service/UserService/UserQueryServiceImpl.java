package umc.study.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.exception.handler.TempHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Reviews;
import umc.study.domain.Users;
import umc.study.repository.ReviewRepository;
import umc.study.repository.UserRepository;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND)
        );
    }

    @Override
    public Optional<Users> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<Reviews> getReviewList(Long userId, Integer page) {
         Users user = userRepository.findById(userId).get();

        Page<Reviews> UserPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));

        return UserPage;
    }

}
