package umc.study.service.UserMissionStatusService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.UserMissionStatusConverter;
import umc.study.domain.mapping.UserMissionStatus;
import umc.study.repository.MissionRepository;
import umc.study.repository.UserMissionStatusRepository;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.UserMissionStatusRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionStatusCommandServiceImpl implements UserMissionStatusCommandService {
    private final UserMissionStatusRepository userMissionStatusRepository;

    @Override
    public UserMissionStatus joinUserMissionStatus(UserMissionStatusRequestDTO.JoinDTO request) {
        UserMissionStatus userMissionStatus = UserMissionStatusConverter.toUserMissionStatusConverter(request);
        return userMissionStatusRepository.save(userMissionStatus);
    }
}
