package umc.study.converter;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.study.domain.Missions;
import umc.study.domain.Users;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMissionStatus;
import umc.study.service.MissionService.MissionQueryServiceImpl;
import umc.study.service.UserService.UserQueryService;
import umc.study.service.UserService.UserQueryServiceImpl;
import umc.study.web.dto.UserMissionStatusRequestDTO;
import umc.study.web.dto.UserMissionStatusResponseDTO;

import java.time.LocalDateTime;

@Component
public class UserMissionStatusConverter{

    @Autowired
    private UserQueryServiceImpl userQueryServiceImpl;
    @Autowired
    private MissionQueryServiceImpl missionQueryServiceImpl;

    public static UserMissionStatusResponseDTO.JoinResultDTO tojoinResultDTO(UserMissionStatus userMissionStatus){
        return UserMissionStatusResponseDTO.JoinResultDTO.builder()
                .missionStatusId(userMissionStatus.getId())
                .createdAt(userMissionStatus.getCreatedAt())
                .build();
    }

    public UserMissionStatus toUserMissionStatusConverter(UserMissionStatusRequestDTO.JoinDTO request){
        Users user = userQueryServiceImpl.findById(request.getUserId());
        Missions mission = missionQueryServiceImpl.findById(request.getMissionId());

        return UserMissionStatus.builder()
                .mission(mission)
                .user(user)
                .missionStartTime(LocalDateTime.now())
                .status(MissionStatus.STARTED)
                .build();
    }
}
