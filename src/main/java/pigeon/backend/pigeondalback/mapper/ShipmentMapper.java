package pigeon.backend.pigeondalback.mapper;

import pigeon.backend.pigeondalback.entity.Shipment;

public interface ShipmentMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Shipment record);

    int insertSelective(Shipment record);

    Shipment selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Shipment record);

    int updateByPrimaryKeyWithBLOBs(Shipment record);

    int updateByPrimaryKey(Shipment record);
}