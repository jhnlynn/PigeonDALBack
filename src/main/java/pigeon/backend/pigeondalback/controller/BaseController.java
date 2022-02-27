package pigeon.backend.pigeondalback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pigeon.backend.pigeondalback.config.SnowFlakeConfig;
import pigeon.backend.pigeondalback.service.DonateService;
import pigeon.backend.pigeondalback.service.BatchService;

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

//    @Autowired
//    DonateService donateService;

//    @Autowired
//    SnowFlakeConfig snowFlakeConfig;
}
