package pigeon.backend.pigeondalback.mapper;

import pigeon.backend.pigeondalback.entity.Batch;

public interface BatchMapper {
    int deleteByPrimaryKey(Long bid);

    int insert(Batch record);

    int insertSelective(Batch record);

    Batch selectByPrimaryKey(Long bid);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);
}