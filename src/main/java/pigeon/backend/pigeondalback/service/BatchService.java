package pigeon.backend.pigeondalback.service;

import org.springframework.transaction.annotation.Transactional;
import pigeon.backend.pigeondalback.entity.Batch;
import pigeon.backend.pigeondalback.mapper.BatchMapper;

import javax.annotation.Resource;

@Transactional
public interface BatchService {
    void fillInDonate(Batch batch) throws Exception;

    void fillInRequest(Batch batch) throws Exception;
}
