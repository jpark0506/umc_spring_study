package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class JoinDTO{
        private Long regionId;
        private Long storeId;
        private String storeName;
        private String storeAddress;
    }
}
