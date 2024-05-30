package umc.study.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.study.domain.Missions;
import umc.study.domain.Regions;
import umc.study.domain.Reviews;
import umc.study.domain.Stores;
import umc.study.service.RegionService.RegionQueryService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreConverter {

    @Autowired
    private RegionQueryService regionQueryService;

    public static StoreResponseDTO.CreateStoreByRegionRequestDTO toJoinResultDTO(Stores store) {
        return StoreResponseDTO.CreateStoreByRegionRequestDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public Stores toStore(StoreRequestDTO.CreateStoreByRegionRequestDTO request){

        Regions region = regionQueryService.findById(request.getRegionId());

        return Stores.builder()
                .region(region)
                .storeName(request.getStoreName())
                .storeAddress(request.getStoreAddress())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Reviews review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getReviewScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getReviewContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Reviews> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Missions mission){
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .missionTitle(mission.getMissionTitle())
                .missionContent(mission.getMissionContent())
                .missionReward(mission.getMissionReward())
                .build();
    }

    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Missions> missionList){
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

}
