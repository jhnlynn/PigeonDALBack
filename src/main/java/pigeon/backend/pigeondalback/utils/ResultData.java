package pigeon.backend.pigeondalback.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PigeonDALBack
 *
 * @author Jason
 * @date 03.03.2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {

    @ApiModelProperty(value = "Result List")
    private List<T> result;

    @ApiModelProperty(value = "Page Information")
    private Page page;
}
