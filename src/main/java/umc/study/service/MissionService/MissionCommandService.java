package umc.study.service.MissionService;

import umc.study.domain.Missions;
import umc.study.domain.Users;
import umc.study.domain.mapping.UserMissionStatus;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.UserRequestDTO;

public interface MissionCommandService {
    Missions createMission(MissionRequestDTO.CreateMissionRequestDTO request);

}
