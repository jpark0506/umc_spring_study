package umc.study.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.study.domain.Regions;
import umc.study.domain.Stores;
import umc.study.service.RegionService.RegionQueryService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

@Component
public class StoreConverter {

    @Autowired
    private RegionQueryService regionQueryService;

    public static StoreResponseDTO.CreateStoreByRegionRequestDTO toJoinResultDTO(Stores store) {
        return StoreResponseDTO.CreateStoreByRegionRequestDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Stores toStore(StoreRequestDTO.CreateStoreByRegionRequestDTO request){

        Regions region = regionQueryService.findById(request.getRegionId());

        return Stores.builder()
                .region(region)
                .storeName(request.getStoreName())
                .storeAddress(request.getStoreAddress())
                .build();


    }


}
