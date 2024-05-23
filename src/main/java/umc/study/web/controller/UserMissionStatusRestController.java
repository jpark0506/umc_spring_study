package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserMissionStatusConverter;
import umc.study.domain.mapping.UserMissionStatus;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.UserMissionStatusService.UserMissionStatusCommandService;
import umc.study.web.dto.UserMissionStatusRequestDTO;
import umc.study.web.dto.UserMissionStatusResponseDTO;


@RestController
@RequiredArgsConstructor
@Valid
@RequestMapping("/missionstatus")
public class UserMissionStatusRestController {

    private final UserMissionStatusCommandService userMissionStatusCommandService;

    @PostMapping("/start")
    public ApiResponse<UserMissionStatusResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserMissionStatusRequestDTO.JoinDTO request){
        UserMissionStatus userMissionStatus = userMissionStatusCommandService.joinUserMissionStatus(request);
        return ApiResponse.onSuccess(UserMissionStatusConverter.tojoinResultDTO(userMissionStatus));
    }
}

