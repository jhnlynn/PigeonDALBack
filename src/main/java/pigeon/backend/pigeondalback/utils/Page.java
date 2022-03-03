package pigeon.backend.pigeondalback.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.validation.constraints.NotNull;


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
public class Page {

    @ApiModelProperty(value = "Current Page", required = true)
    private Integer currentPage;

    @ApiModelProperty(value = "Items Per Page", required = true)
    private Integer pageSize;
}
