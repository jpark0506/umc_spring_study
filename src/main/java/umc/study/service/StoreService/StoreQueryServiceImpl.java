package umc.study.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.exception.handler.TempHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Missions;
import umc.study.domain.Reviews;
import umc.study.domain.Stores;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;

import java.util.Optional;

@Service
public class StoreQueryServiceImpl implements StoreQueryService{
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MissionRepository missionRepository;

    @Override
    public Stores findById(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(
                ()-> new TempHandler(ErrorStatus.STORE_NOT_FOUND)
        );
    }

    @Override
    public Optional<Stores> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Reviews> getReviewList(Long StoreId, Integer page) {
        Stores store = storeRepository.findById(StoreId).get();

        Page<Reviews> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Missions> getMissionList(Long StoreId, Integer page) {
        Stores store = storeRepository.findById(StoreId).get();

        Page<Missions> StorePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
}
