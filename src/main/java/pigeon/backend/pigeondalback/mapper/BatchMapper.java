package pigeon.backend.pigeondalback.mapper;

import org.apache.ibatis.annotations.Mapper;
import pigeon.backend.pigeondalback.entity.Batch;
import pigeon.backend.pigeondalback.vo.DonateRequestVO;

import java.util.List;
import java.util.Map;

@Mapper
public interface BatchMapper {
    int deleteByPrimaryKey(Long bid);

    int insert(Batch record);

    int insertSelective(Batch record);

    Batch selectByPrimaryKey(Long bid);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);

    List<DonateRequestVO> getDonateHistory(Map<String, Object> map);

    DonateRequestVO getDonationRecord(Map<String, String> map);

    DonateRequestVO getRequestRecord(Map<String, String> map);

}