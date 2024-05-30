package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    @Operation(summary = "특정 유저의 특정 미션의 상태를 업데이트하는 API",description = "특정 유저의 특정 미션의 상태를 업데이트하는 API입니다. body로 mission_id, user_id, mission_status_id, status를 넘겨주세요.")
    @PatchMapping("/update")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<UserMissionStatusResponseDTO.UpdateResultDTO> update(@RequestBody @Valid UserMissionStatusRequestDTO.UpdateDTO request){
        UserMissionStatus userMissionStatus = userMissionStatusCommandService.updateUserMissionStatus(request);
        return ApiResponse.onSuccess(UserMissionStatusConverter.toupdateResultDTO(userMissionStatus));
    }
}

