package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
