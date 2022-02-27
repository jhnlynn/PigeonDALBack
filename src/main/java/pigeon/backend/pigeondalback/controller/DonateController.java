package pigeon.backend.pigeondalback.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.slf4j.internal.Logger;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pigeon.backend.pigeondalback.common.ResponseResult;
import pigeon.backend.pigeondalback.config.SnowFlakeConfig;
import pigeon.backend.pigeondalback.entity.Batch;
import pigeon.backend.pigeondalback.vo.DonateRequestVO;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@RestController
@RequestMapping("/api/v1/donate")
@Api(value="donate")
public class DonateController extends BaseController implements WebMvcConfigurer {

    Logger logger = new Logger(this.getClass().toString());

    private static final long MAX_AGE_SECS = 3600;

    /*
    * donate and fill in the table
    *
    *
    {
        "uid":10000,
        "warehouseID":122112,
        "bnum":123123313,
        "btrack":1231231,
        "warehouseWid": 1
    }
    *
    * */
    @ApiOperation(value = "Donator fill in the table, Since it's a donation, no requestID or status needed"
            , notes = "RequestBody Format: {\n" +
            "\t\"uid\":W9UVGoQdBafuRTJxVYC1Cft5ER22, \n" +
            "\t\"warehouseID\":122112, \n" +
            "\t\"bnum\":123123313, \n" +
            "\t\"btrack\":1231231,\n" +
            "\t\"warehouseWid\": 1\n" +
            "}")
    @PostMapping(value = "/fill") // "{uid, warehouseWid, bnum, shipmentSid, manufactorID}"
    public String fillTables(@ApiParam(name = "Donate Obj", value="RequestBody", example = "{uid, warehouseWid, bnum, shipmentSid, manufactorID}") @RequestBody String tableJson) throws Exception {
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
        return "Success";
    }

    @ApiOperation(value = "donator check donating history as a table with pagination"
    , notes = "GET http://localhost:8080/api/v1/donate/history/W9UVGoQdBafuRTJxVYC1Cft5ER22?page=1&size=10\n")
    @GetMapping(value = "/history/{userId}")
    public String getHistory(@ApiParam(value = "user_id") @PathVariable String userId
            , @ApiParam(value = "page") @RequestParam("page") Long page
            , @ApiParam(value = "size") @RequestParam("size") Long size) throws Exception {
        Gson gson = new GsonBuilder().serializeNulls().create();

        if (page < 1 || size < 0) {
            return gson.toJson(new ResponseResult(404,"invalid parameter"));
        }
        page = (page - 1) * size;
        List<DonateRequestVO> shipment = shipmentService.getHistory(userId, size, page);

        return gson.toJson(shipment);

    }

    @ApiOperation(value = "donator check a single donating history, for package (shipment)"
    , notes = "GET http://localhost:8080/api/v1/donate/record/W9UVGoQdBafuRTJxVYC1Cft5ER22?shipId=695242501623119874\n")
    @GetMapping(value = "/record/{userId}")
    public String getSingleRecord(@ApiParam(value = "user_id") @PathVariable String userId
            , @ApiParam(value = "shipId") @RequestParam("shipId") String shipId) throws Exception {

        // getDonationRecord
        Gson gson = new GsonBuilder().serializeNulls().create();

        DonateRequestVO record = shipmentService.getDonationRecord(userId, shipId);

        return gson.toJson(record);
    }


@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE").allowedOrigins("*")
            .allowedHeaders("*").maxAge(MAX_AGE_SECS);
}

}
