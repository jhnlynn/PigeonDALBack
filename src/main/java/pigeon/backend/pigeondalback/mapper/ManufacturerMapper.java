package pigeon.backend.pigeondalback.mapper;

import pigeon.backend.pigeondalback.entity.Manufacturer;

public interface ManufacturerMapper {
    int deleteByPrimaryKey(Byte mid);

    int insert(Manufacturer record);

    int insertSelective(Manufacturer record);

    Manufacturer selectByPrimaryKey(Byte mid);

    int updateByPrimaryKeySelective(Manufacturer record);

    int updateByPrimaryKey(Manufacturer record);
}