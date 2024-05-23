package umc.study.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.domain.Regions;
import umc.study.domain.Stores;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;

@Service
@RequiredArgsConstructor

public class RegionQueryServiceImpl implements RegionQueryService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public Regions findById(Long regionId) {
        return regionRepository.findById(regionId).orElse(null);
    }
}
