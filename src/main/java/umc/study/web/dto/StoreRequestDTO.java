package umc.study.web.dto;

import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class CreateStoreByRegionRequestDTO {
        private Long regionId;
        private Long storeId;
        private String storeName;
        private String storeAddress;
    }
}
