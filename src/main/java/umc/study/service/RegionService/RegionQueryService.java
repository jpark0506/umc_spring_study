package umc.study.service.RegionService;

import umc.study.domain.Regions;

public interface RegionQueryService {
    Regions findById(Long regionId);
}
