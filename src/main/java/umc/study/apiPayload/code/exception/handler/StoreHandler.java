package umc.study.apiPayload.code.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
