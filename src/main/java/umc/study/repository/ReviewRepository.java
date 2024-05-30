package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Reviews;
import umc.study.domain.Stores;
import umc.study.domain.Users;

public interface ReviewRepository extends JpaRepository<Reviews,Long> {

    Page<Reviews> findAllByStore(Stores store, PageRequest pageRequest);
    Page<Reviews> findAllByUser(Users user, PageRequest pageRequest);
}
