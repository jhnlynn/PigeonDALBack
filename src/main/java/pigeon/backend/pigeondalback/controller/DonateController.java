package pigeon.backend.pigeondalback.controller;

import com.google.gson.Gson;
import com.sun.org.slf4j.internal.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pigeon.backend.pigeondalback.common.ResponseResult;
import pigeon.backend.pigeondalback.config.SnowFlakeConfig;
import pigeon.backend.pigeondalback.entity.Batch;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@Controller
@RequestMapping("/api/v1/donate")
//@Api(value="donate")
public class DonateController extends BaseController implements WebMvcConfigurer {

    Logger logger = new Logger(this.getClass().toString());

    private static final long MAX_AGE_SECS = 3600;

    /*
    * donate and fill in the table
    *
    * track id,
    * num of batches
    *
    * */
//    @ApiOperation(value = "donator fill in the table, if it's a donation, no requestID or status needed")
    @PostMapping(value = "/fill")
    // @ApiParam(value="RequestBody", example = "{uid, warehouseWid, bnum, shipmentSid}", required = true)
    public void fillTables(@RequestBody String tableJson) throws Exception {
        Gson gson = new Gson();
        Batch batch;
        try {
            batch = gson.fromJson(tableJson, Batch.class);
        } catch (Exception e) {
            throw new Exception("thrown from DonateController fillTables" + e);
        }

        try {
            batchService.fillInDonate(batch);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("here");
//        return new ResponseResult(200,"Success");
    }
}
