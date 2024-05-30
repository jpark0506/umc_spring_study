package umc.study.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.exception.handler.TempHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.converter.UserMissionStatusConverter;
import umc.study.domain.Missions;
import umc.study.domain.Reviews;
import umc.study.domain.Users;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMissionStatus;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.UserMissionStatusRepository;
import umc.study.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserMissionStatusRepository userMissionStatusRepository;
    @Autowired
    private MissionRepository missionRepository;
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

    @Override
    public Page<Missions> getMissionList(Long userId, Integer page, Integer status) {

        Users user = userRepository.findById(userId).get();

        //Refactor 필요
        MissionStatus missionStatus = convertStatusToMissionStatus(status);

        List<Long> userMissionStatusIdList = userMissionStatusRepository.findAllByUserIdAndStatus(user.getId(),missionStatus).stream()
                .map(usermissionStatus -> usermissionStatus.getMission().getId())
                .distinct() // 중복 제거
                .toList();

        Page<Missions> MissionPage = missionRepository.findAllByIdIn(userMissionStatusIdList, PageRequest.of(page, 10));

        return MissionPage;
    }
    public MissionStatus convertStatusToMissionStatus(int status) {
        return switch (status) {
            case 1 -> MissionStatus.STARTED;
            case 2 -> MissionStatus.FINISHED;
            case 3 -> MissionStatus.APPROVED;
            default -> throw new IllegalArgumentException("Invalid status: " + status);
        };
    }

}
