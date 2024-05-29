package umc.study.service.MissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.domain.Missions;
import umc.study.domain.Users;
import umc.study.repository.MissionRepository;

@Service
public class MissionQueryServiceImpl implements MissionQueryService {
    @Autowired
    private MissionRepository missionRepository;

    public Missions findById(Long id){
        return missionRepository.findById(id).orElse(null);
    }

}
