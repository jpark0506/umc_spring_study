package umc.study.web.dto;

import lombok.Getter;

public class UserMissionStatusRequestDTO {

    @Getter
    public static class JoinDTO{
        Long userId;
        Long missionId;
    }
}
