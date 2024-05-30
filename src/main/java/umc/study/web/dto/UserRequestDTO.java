package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDTO{
        String name;
        String nickname;
        Integer gender;
        String address;
        @ExistCategories
        List<Long> preferCategory;
    }

}
