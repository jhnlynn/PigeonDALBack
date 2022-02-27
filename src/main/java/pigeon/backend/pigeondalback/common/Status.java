package pigeon.backend.pigeondalback.common;

import lombok.Getter;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@Getter
public enum Status implements IStatus {
    SUCCESS(200, "OPERATION SUCCESS！"),

    ERROR(500, "OPERATION FAILED！"),

    LOGOUT(200, "EXIT SUCCESS！"),

    UNAUTHORIZED(401, "PLEASE LOGIN FIRST！"),

    ACCESS_DENIED(403, "ACCESS DENIED, DUE TO LOW PERMISSION！"),

    REQUEST_NOT_FOUND(404, "REQUEST NOT FOUND！"),

    HTTP_BAD_METHOD(405, "HTTP BAD METHOD！"),

    BAD_REQUEST(400, "BAD REQUEST！"),

    PARAM_NOT_MATCH(400, "PARAM NOT MATCH！"),

    PARAM_NOT_NULL(400, "PARAM NOT NULL！"),

    USER_DISABLED(403, "USER_DISABLED！"),

    USERNAME_PASSWORD_ERROR(5001, "WRONG USERNAME OR PASSWORD！"),

    TOKEN_EXPIRED(5002, "TOKEN EXPIRED！"),

    TOKEN_PARSE_ERROR(5002, "TOKEN PARSE ERROR！"),

    TOKEN_OUT_OF_CTRL(5003, "TOKEN OUT OF CONTROL！"),

    KICKOUT_SELF(5004, "CANNOT KICK OUT YOURSELF！");

    /**
     * STATUS CODE
     */
    private Integer code;

    /**
     * RETURNING MSG
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Status fromCode(Integer code) {
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return SUCCESS;
    }

    @Override
    public String toString() {
        return String.format(" Status:{code=%s, message=%s} ", getCode(), getMessage());
    }

}
