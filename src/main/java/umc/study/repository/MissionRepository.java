package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Missions;

public interface MissionRepository extends JpaRepository<Missions,Long> {
}
