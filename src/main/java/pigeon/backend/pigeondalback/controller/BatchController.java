package pigeon.backend.pigeondalback.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@RestController
@RequestMapping("api/v1/batch")
@EnableSwagger2
@Api(value = "BatchController", tags = "REST APIs related to Student Entity!!!!")
public class BatchController {
//    @ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success|OK"),
//            @ApiResponse(code = 401, message = "not authorized!"),
//            @ApiResponse(code = 403, message = "forbidden!!!"),
//            @ApiResponse(code = 404, message = "not found!!!") })
//
//    @RequestMapping(value = "/split")
//    public
}
