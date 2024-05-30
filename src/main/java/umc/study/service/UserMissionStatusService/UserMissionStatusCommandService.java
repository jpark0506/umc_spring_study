package umc.study.service.UserMissionStatusService;

import umc.study.domain.mapping.UserMissionStatus;
import umc.study.web.dto.UserMissionStatusRequestDTO;

public interface UserMissionStatusCommandService {
    UserMissionStatus joinUserMissionStatus(UserMissionStatusRequestDTO.JoinDTO request);

    UserMissionStatus updateUserMissionStatus(UserMissionStatusRequestDTO.UpdateDTO request);
}
