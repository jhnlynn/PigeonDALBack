package pigeon.backend.pigeondalback.service.serviceImpl;

import org.springframework.stereotype.Service;
import pigeon.backend.pigeondalback.entity.Batch;
import pigeon.backend.pigeondalback.mapper.BatchMapper;
import pigeon.backend.pigeondalback.service.DonateService;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@Service("donateService")
public class DonateServiceImpl implements DonateService {

    @Resource
    BatchMapper batchMapper;

    @Override
    public void fillInDonate(Batch batch) throws Exception {
        try {
            System.out.println("batch: " + batch.toString());
            batchMapper.insert(batch);
        } catch (Exception ex) {
            throw new Exception("Thrown By DonateServiceImpl fillInDonate" + ex);
        }
    }
}
