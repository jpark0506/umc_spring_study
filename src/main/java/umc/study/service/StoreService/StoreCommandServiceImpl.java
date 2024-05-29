package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Stores;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final StoreConverter storeConverter;

    @Autowired(required = false)
    public Stores joinStore(StoreRequestDTO.CreateStoreByRegionRequestDTO request){
        Stores store = storeConverter.toStore(request);
        return storeRepository.save(store);
    }



}
