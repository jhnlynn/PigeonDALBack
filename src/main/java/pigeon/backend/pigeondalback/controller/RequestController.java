package pigeon.backend.pigeondalback.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.slf4j.internal.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pigeon.backend.pigeondalback.common.ResponseResult;
import pigeon.backend.pigeondalback.entity.Batch;
import pigeon.backend.pigeondalback.entity.Shipment;
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
@RequestMapping("/api/v1/request")
@Api(value="request")
public class RequestController  extends BaseController implements WebMvcConfigurer {

    Logger logger = new Logger(this.getClass().toString());

    private static final long MAX_AGE_SECS = 3600;

    @ApiOperation(value = "People requests, and fill in the table, since it's a donation, requestID needed"
    )
    @PostMapping(value = "/fill")
    public String fillTables(@ApiParam(value="RequestBody", example = "{bid, bnum, bstatus, btrack, donationsDid, shipmentSid, requestRid, uid, manufacturerMid}", required = true) @RequestBody String tableJson) throws Exception {
        Gson gson = new Gson();
        Batch batch;
        try {
            batch = gson.fromJson(tableJson, Batch.class);
        } catch (Exception e) {
            throw new Exception("thrown from DonateController fillTables" + e);
        }

        try {
            batchService.fillInRequest(batch);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "Success";
    }

    @ApiOperation(value = "receiver check requesting history as a table with pagination"
            , notes = "GET http://localhost:8080/api/v1/request/history/W9UVGoQdBafuRTJxVYC1Cft5ER22?page=1&size=10")
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

    @ApiOperation(value = "receiver check a single requesting history, for package (shipment)"
    , notes = "http://localhost:8080/api/v1/request/record/W9UVGoQdBafuRTJxVYC1Cft5ER22?shipId=695242501623119874")
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
