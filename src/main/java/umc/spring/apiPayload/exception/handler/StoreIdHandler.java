package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class StoreIdHandler extends GeneralException {
    public StoreIdHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
