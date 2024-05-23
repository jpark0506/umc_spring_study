package umc.study.service.RegionService;

import umc.study.domain.Regions;

public interface RegionQueryService {
    public Regions findById(Long regionId);
}
