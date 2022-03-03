package pigeon.backend.pigeondalback.utils;

import pigeon.backend.pigeondalback.constants.SystemEnum.ResponseEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * PigeonDALBack
 *
 * @author Jason
 * @date 03.03.2022
 */
public class Result<T> implements Serializable {
    // Status Code
    @ApiModelProperty(value = "返回代码")
    private Integer code = ResponseEnum.SUCCESS.getCode();

    // Status Message
    @ApiModelProperty(value = "返回消息")
    private String message = ResponseEnum.SUCCESS.getMessage();

    // Result Data
    @ApiModelProperty(value = "Result")
    private T result;


    // Time Stamp
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public Result<T> success(String message) {
        this.message = message;
        return this;
    }

    public Result<T> fail(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        return this;
    }

    public Result<T> fail(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }
}
