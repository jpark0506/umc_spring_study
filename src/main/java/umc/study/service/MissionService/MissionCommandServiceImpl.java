package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.Missions;
import umc.study.domain.mapping.UserMissionStatus;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    public final MissionRepository missionRepository;
    public final MissionConverter missionConverter;
    @Override
    public Missions createMission(MissionRequestDTO.CreateMissionRequestDTO request) {
        Missions mission = missionConverter.toMission(request);
        return missionRepository.save(mission);
    }
}
