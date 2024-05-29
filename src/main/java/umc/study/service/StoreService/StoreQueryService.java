package umc.study.service.StoreService;

import umc.study.domain.Stores;

public interface StoreQueryService {
    Stores findById(Long storeId);
}
