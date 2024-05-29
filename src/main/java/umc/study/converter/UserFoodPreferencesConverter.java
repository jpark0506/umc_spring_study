package umc.study.converter;

import umc.study.domain.FoodCategories;
import umc.study.domain.mapping.UserFoodPreferences;

import java.util.List;
import java.util.stream.Collectors;

public class UserFoodPreferencesConverter {
    public static List<UserFoodPreferences> toMemberPreferList(List<FoodCategories> foodCategoriesList){
        return foodCategoriesList.stream().map(foodCategory ->
                    UserFoodPreferences.builder().foodCategory(foodCategory).build()
                ).collect(Collectors.toList());

    }
}
