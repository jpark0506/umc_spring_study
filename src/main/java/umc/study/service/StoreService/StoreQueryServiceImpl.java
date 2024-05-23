package umc.study.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.domain.Stores;
import umc.study.repository.StoreRepository;

@Service
public class StoreQueryServiceImpl implements StoreQueryService{
    @Autowired
    StoreRepository storeRepository;

    public Stores findById(Long storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }
}
