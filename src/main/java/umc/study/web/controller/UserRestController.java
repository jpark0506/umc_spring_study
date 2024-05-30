package umc.study.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserConverter;
import umc.study.domain.Missions;
import umc.study.domain.Reviews;
import umc.study.domain.Users;
import umc.study.service.UserService.UserCommandService;
import umc.study.service.UserService.UserQueryService;
import umc.study.service.UserService.UserQueryServiceImpl;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDTO request){
        Users user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @Operation(summary = "특정 유저의 리뷰 목록 조회 API",description = "특정 유저의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{userId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<UserResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name = "userId") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Reviews> result = userQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(UserConverter.reviewPreViewListDTO(result));
    }

    @Operation(summary = "특정 유저의 미션 목록 조회 API",description = "특정 유저의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{userId}/missions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "status", description = "미션의 상태입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })

    public ApiResponse<UserResponseDTO.MissionPreViewListDTO> getMissionList(@PathVariable(name = "userId") Long storeId, @RequestParam(name = "page") Integer page, @RequestParam(name="status") Integer status){
        Page<Missions> result = userQueryService.getMissionList(storeId,page,status);
        return ApiResponse.onSuccess(UserConverter.missionPreViewListDTO(result));
    }
}
