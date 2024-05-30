package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Missions;
import umc.study.domain.Reviews;
import umc.study.domain.Stores;

import java.util.Optional;

public interface StoreQueryService {

    Stores findById(Long storeId);

    Optional<Stores> findStore(Long id);

    Page<Reviews> getReviewList(Long StoreId, Integer page);

    Page<Missions> getMissionList(Long StoreId, Integer page);
}
