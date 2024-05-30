package umc.study.web.dto;

import lombok.Getter;

public class UserMissionStatusRequestDTO {

    @Getter
    public static class JoinDTO{
        Long userId;
        Long missionId;
    }
    // userId + missionid => missionStatusId를 가져오는 메서드를 사용하냐
    // 아니면 missionStatusId를 직접 받아오는 메서드를 사용하냐가 문제다.
    @Getter
    public static class UpdateDTO{
        Long userId;
        Long missionId;
        Long missionStatusId;
        Integer missionStatus;
    }
}
