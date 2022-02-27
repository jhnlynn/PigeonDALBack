package pigeon.backend.pigeondalback.service.serviceImpl;

import org.springframework.stereotype.Service;
import pigeon.backend.pigeondalback.config.SnowFlakeConfig;
import pigeon.backend.pigeondalback.entity.Batch;
import pigeon.backend.pigeondalback.mapper.*;
import pigeon.backend.pigeondalback.service.BatchService;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@Service("batchService")
public class BatchServiceImpl implements BatchService {

    @Resource
    BatchMapper batchMapper;

    @Override
    public void fillInDonate(Batch batch) throws Exception {

        SnowFlakeConfig snow = new SnowFlakeConfig();
        batch.setBid(snow.generateSnowFlakeId());
        batch.setDonationsDid(String.valueOf(snow.generateSnowFlakeId()));
        batch.setRequestRid("0"); // get by tracking
        batch.setBstatus((byte) 1); // get by tracking
        batch.setShipmentSid(String.valueOf(snow.generateSnowFlakeId()));
        batch.setProductPid((byte)1); // ?
        try {
            batchMapper.insert(batch);
        } catch (Exception ex) {
            throw new Exception("Thrown By DonateServiceImpl fillInDonate" + ex);
        }
    }

    @Override
    public void fillInRequest(Batch batch) throws Exception {
        SnowFlakeConfig snow = new SnowFlakeConfig();
        batch.setWarehouseWid((byte)1); // get by tracking
        batch.setRequestRid("0"); // get by tracking
        batch.setBstatus((byte) 1); // get by tracking
        batch.setProductPid((byte)1); // ?
        batch.setRequestRid(String.valueOf(snow.generateSnowFlakeId()));
        try {
            batchMapper.insert(batch);
        } catch (Exception ex) {
            throw new Exception("Thrown By DonateServiceImpl fillInDonate" + ex);
        }
    }
}
//
