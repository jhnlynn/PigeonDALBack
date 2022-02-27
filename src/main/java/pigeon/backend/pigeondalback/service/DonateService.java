package pigeon.backend.pigeondalback.service;

import org.springframework.transaction.annotation.Transactional;
import pigeon.backend.pigeondalback.entity.Batch;

/**
 * <p>
 *
 * </p>
 *
 * @author Johannes
 * @date 2/26/22
 */
@Transactional
public interface DonateService {
    void fillInDonate(Batch batch) throws Exception;
}
