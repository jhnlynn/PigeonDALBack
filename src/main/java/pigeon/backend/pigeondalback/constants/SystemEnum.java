package pigeon.backend.pigeondalback.constants;

/**
 * PigeonDALBack
 *
 * @author Jason
 * @date 03.03.2022
 */
public class SystemEnum {

    public enum Sex {
        MALE(0),
        FEMALE(1);

        private final Integer sex;

        Sex(Integer sex) { this.sex = sex; }

        public Integer getSex() { return sex;}
    }

    public enum UserType {
        // Common User
        COMMON(0),

        // Administrator User
        ADMIN(1);

        private final Integer type;

        UserType(Integer type) { this.type = type; }

        public Integer getType() { return type;}
    }

    public enum ShipmentStatus {
        PROCESSING(0),
        SHIPPED(1),
        DELIVERED(2);

        private final Integer status;

        ShipmentStatus(Integer status) { this.status = status; }

        public Integer getStatus() { return status;}
    }

    public enum ReviewStatus {
        WAITING(0),
        SUCCESS(1),
        REFUSE(2);

        private final Integer status;

        ReviewStatus(Integer status) { this.status = status; }

        public Integer getStatus() { return status;}
    }

    public enum ResponseEnum {
        SUCCESS(200, "SUCCESS"),
        NOT_AUTHORIZED(401, "NOT AUTHORIZED"),
        FORBIDDEN(403, "FORBIDDEN"),
        NOT_FOUND(404, "NOT FOUND"),
        SERVICE_UNAVAILABLE(503, "SERVICE_UNAVAILABLE");

        private final Integer code;
        private final String message;

         ResponseEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() { return code; }

        public String getMessage() {return message; }
    }
}
