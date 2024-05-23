package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.exception.handler.FoodCategoriesHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.converter.UserConverter;
import umc.study.converter.UserFoodPreferencesConverter;
import umc.study.domain.FoodCategories;
import umc.study.domain.Users;
import umc.study.domain.mapping.UserFoodPreferences;
import umc.study.repository.FoodCategoryRepository;
import umc.study.converter.UserFoodPreferencesConverter;
import umc.study.repository.UserRepository;
import umc.study.web.dto.UserRequestDTO.JoinDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService{
    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Users joinUser(JoinDTO request) {
        Users user = UserConverter.toUser(request);
        List<FoodCategories> foodCategoriesList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(()-> new FoodCategoriesHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserFoodPreferences> userFoodPreferencesList = UserFoodPreferencesConverter.toMemberPreferList(foodCategoriesList);

        userFoodPreferencesList.forEach(userFoodPreferences -> {userFoodPreferences.setUser(user);});

        return userRepository.save(user);
    }
}
