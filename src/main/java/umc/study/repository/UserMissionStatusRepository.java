package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMissionStatus;

import java.util.List;

public interface UserMissionStatusRepository extends JpaRepository<UserMissionStatus,Long> {
    List<UserMissionStatus> findAllByUserIdAndStatus(Long userId, MissionStatus missionStatus);
}
