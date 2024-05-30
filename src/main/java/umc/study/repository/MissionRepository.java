package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Missions;
import umc.study.domain.Reviews;
import umc.study.domain.Stores;

public interface MissionRepository extends JpaRepository<Missions,Long> {

    Page<Missions> findAllByStore(Stores store, PageRequest pageRequest);
}
