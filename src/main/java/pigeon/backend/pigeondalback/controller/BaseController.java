package pigeon.backend.pigeondalback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pigeon.backend.pigeondalback.service.BatchService;
import pigeon.backend.pigeondalback.service.ShipmentService;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
public class BaseController {

    @Autowired
    BatchService batchService;

    @Autowired
    ShipmentService shipmentService;

//    @Autowired
//    DonateService donateService;

//    @Autowired
//    SnowFlakeConfig snowFlakeConfig;
}
