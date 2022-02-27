package pigeon.backend.pigeondalback.mapper;

import org.apache.ibatis.annotations.Mapper;
import pigeon.backend.pigeondalback.entity.Batch;

@Mapper
public interface BatchMapper {
    int deleteByPrimaryKey(Long bid);

    int insert(Batch record);

    int insertSelective(Batch record);

    Batch selectByPrimaryKey(Long bid);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);
}