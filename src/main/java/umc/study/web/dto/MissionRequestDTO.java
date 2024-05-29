package umc.study.web.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDateTime;
import java.util.List;

public class MissionRequestDTO {
    @Getter
    public static class CreateMissionRequestDTO{

        String title;
        String content;
        //차후 ms도 지원하기
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime expirationDate;
        Integer missionReward;
        Long store_id;

    }


}
