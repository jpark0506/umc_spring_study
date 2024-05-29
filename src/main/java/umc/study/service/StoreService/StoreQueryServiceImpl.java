package umc.study.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.exception.handler.TempHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Stores;
import umc.study.repository.StoreRepository;

@Service
public class StoreQueryServiceImpl implements StoreQueryService{
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Stores findById(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(
                ()-> new TempHandler(ErrorStatus.STORE_NOT_FOUND)
        );
    }
}
