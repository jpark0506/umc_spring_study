package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.UserMissionStatus;

public interface UserMissionStatusRepository extends JpaRepository<UserMissionStatus,Long> {
}
