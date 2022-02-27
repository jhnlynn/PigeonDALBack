package pigeon.backend.pigeondalback.mapper;

import org.apache.ibatis.annotations.Mapper;
import pigeon.backend.pigeondalback.entity.Warehouse;

@Mapper
public interface WarehouseMapper {
    int deleteByPrimaryKey(Byte wid);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Byte wid);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);
}