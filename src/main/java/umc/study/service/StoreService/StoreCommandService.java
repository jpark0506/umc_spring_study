package umc.study.service.StoreService;

import umc.study.domain.Stores;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Stores joinStore(StoreRequestDTO.CreateStoreByRegionRequestDTO request);
}
