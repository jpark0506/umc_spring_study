package umc.study.apiPayload.code.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.exception.GeneralException;

public class FoodCategoriesHandler extends GeneralException {
    public FoodCategoriesHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
