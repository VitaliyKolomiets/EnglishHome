package sa.com.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ServiceErrorCode {

    ITEM_NOT_FOUND("itemNotFound"),
    NOT_AUTHORIZED("notAuthorized"),
    PERMISSION_DENIED("permissionDenied"),
    GENERAL_ERROR("generalError"),
    ALREADY_EXIST("alreadyExists"),
    INCORRECT_PARAMETER("incorrectParameter"),
    WRONG_DATA_IN_DATABASE("wrongDataInDataBase");

    @Getter
    private String resKey;
}
