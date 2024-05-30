package umc.study.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.study.domain.Missions;
import umc.study.domain.Stores;
import umc.study.service.StoreService.StoreQueryServiceImpl;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

@Component
public class MissionConverter {

    @Autowired
    private StoreQueryServiceImpl storeQueryService;

    public static MissionResponseDTO.CreateMissionResponseDTO toJoinResultDTO(Missions missions) {
        return MissionResponseDTO.CreateMissionResponseDTO.builder()
                .missionId(missions.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Missions toMission(MissionRequestDTO.CreateMissionRequestDTO request){
        Stores store = storeQueryService.findById(request.getStore_id());

        return Missions.builder()
                .missionTitle(request.getTitle())
                .missionContent(request.getContent())
                .missionExpireDate(request.getExpirationDate())
                .missionReward(request.getMissionReward())
                .store(store).build();
    }
}
