package umc.study.converter;

import umc.study.domain.Regions;
import umc.study.domain.Stores;
import umc.study.service.RegionService.RegionQueryService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    private static RegionQueryService regionQueryService;

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Stores store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Stores toStore(StoreRequestDTO.JoinDTO request){

        Regions region = regionQueryService.findById(request.getRegionId());
        if(region == null){
            throw new IllegalArgumentException("No Region found with id: " + request.getRegionId());
        }

        return Stores.builder()
                .region(region)
                .storeName(request.getStoreName())
                .storeAddress(request.getStoreAddress())
                .build();


    }


}
