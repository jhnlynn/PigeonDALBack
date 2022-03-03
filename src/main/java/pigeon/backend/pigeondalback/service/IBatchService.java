package pigeon.backend.pigeondalback.service;

import pigeon.backend.pigeondalback.entity.Batch;

public interface IBatchService {
    void fillInDonate(Batch batch) throws Exception;

    void fillInRequest(Batch batch) throws Exception;
}