package umc.study.converter;


import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
public class UserMissionStatusConverter{

    public static UserQueryServiceImpl userQueryServiceImpl;
    public static MissionQueryServiceImpl missionQueryServiceImpl;

    public static UserMissionStatusResponseDTO.JoinResultDTO tojoinResultDTO(UserMissionStatus userMissionStatus){
        return UserMissionStatusResponseDTO.JoinResultDTO.builder()
                .missionStatusId(userMissionStatus.getId())
                .createdAt(userMissionStatus.getCreatedAt())
                .build();
    }
    public static UserMissionStatus toUserMissionStatusConverter(UserMissionStatusRequestDTO.JoinDTO request){
        Users user = userQueryServiceImpl.findById(request.getUserId());
        Missions mission = missionQueryServiceImpl.findById(request.getMissionId());

        //에러 코드 수정하기(Exception에 맞춰서)
        if (user == null) {
            throw new IllegalArgumentException("No User");
        }
        if(mission == null){
            throw new IllegalArgumentException("No Mission");
        }

        return UserMissionStatus.builder()
                .mission(mission)
                .user(user)
                .missionStartTime(LocalDateTime.now())
                .status(MissionStatus.STARTED)
                .build();
    }
}
