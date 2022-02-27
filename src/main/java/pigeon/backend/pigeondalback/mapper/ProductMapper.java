package pigeon.backend.pigeondalback.mapper;

import org.apache.ibatis.annotations.Mapper;
import pigeon.backend.pigeondalback.entity.Product;

@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(Byte pid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Byte pid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}