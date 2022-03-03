package pigeon.backend.pigeondalback.service.serviceImpl;

import pigeon.backend.pigeondalback.config.SnowFlakeConfig;
import pigeon.backend.pigeondalback.entity.Batch;
import pigeon.backend.pigeondalback.mapper.*;
import pigeon.backend.pigeondalback.service.IBatchService;

import javax.annotation.Resource;
/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
public class BatchServiceImpl implements IBatchService {
    @Resource
    BatchMapper batchMapper;

    @Override
    public void fillInDonate(Batch batch) throws Exception {
        SnowFlakeConfig snow = new SnowFlakeConfig();
        batch.setBid((int) snow.generateSnowFlakeId());
        batch.setDid((int) (snow.generateSnowFlakeId()));
        batch.setRequestRid("0"); // get by tracking
        batch.setBstatus(1); // get by tracking
        batch.setShipmentSid((int) snow.generateSnowFlakeId());
        batch.setProductPid(1); // ?
        try {
            batchMapper.insert(batch);
        } catch (Exception ex) {
            throw new Exception("Thrown By DonateServiceImpl fillInDonate" + ex);
        }
    }

    @Override
    public void fillInRequest(Batch batch) throws Exception {
        SnowFlakeConfig snow = new SnowFlakeConfig();
        batch.setWarehouseWid((Integer)1); // get by tracking
        batch.setRequestRid("0"); // get by tracking
        batch.setBstatus((Integer) 1); // get by tracking
        batch.setProductPid(1); // ?
        batch.setRequestRid(String.valueOf(snow.generateSnowFlakeId()));
        try {
            batchMapper.insert(batch);
        } catch (Exception ex) {
            throw new Exception("Thrown By DonateServiceImpl fillInDonate" + ex);
        }
    }
}
