package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.FoodCategories;

public interface FoodCategoryRepository extends JpaRepository<FoodCategories,Long> {
}
