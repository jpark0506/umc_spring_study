package umc.study.service.UserMissionStatusService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional
public class UserMissionStatusCommandServiceImpl implements UserMissionStatusCommandService {

    @Autowired
    private final UserMissionStatusRepository userMissionStatusRepository;
    @Autowired
    private final UserMissionStatusConverter userMissionStatusConverter;

    @Override
    public UserMissionStatus joinUserMissionStatus(UserMissionStatusRequestDTO.JoinDTO request) {
        UserMissionStatus userMissionStatus = userMissionStatusConverter.toUserMissionStatusConverter(request);
        return userMissionStatusRepository.save(userMissionStatus);
    }
}
