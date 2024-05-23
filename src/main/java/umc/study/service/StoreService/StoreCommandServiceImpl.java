package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Stores;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    public Stores joinStore(StoreRequestDTO.JoinDTO request){
        Stores store = StoreConverter.toStore(request);
        return storeRepository.save(store);
    }



}
