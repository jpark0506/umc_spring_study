package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.FoodCategories;
import umc.study.domain.mapping.UserFoodPreferences;

import java.util.List;
import java.util.stream.Collectors;

public interface UserFoodPreferencesConverter extends JpaRepository<UserFoodPreferences,Long>
{
    public static List<UserFoodPreferences> toMemberPreferList(List<FoodCategories> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserFoodPreferences.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
