package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Regions;

public interface RegionRepository extends JpaRepository<Regions, Long> {
}
