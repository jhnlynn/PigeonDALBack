package pigeon.backend.pigeondalback.mapper;

import java.util.List;
import java.util.Map;
import pigeon.backend.pigeondalback.entity.Batch;
import pigeon.backend.pigeondalback.vo.DonateRequestVO;


public interface BatchMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Batch batch);

    int insertSelective(Batch batch);

    Batch selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);

    List<DonateRequestVO> getDonateHistory(Map<String, Integer> map);

    DonateRequestVO getDonationRecord(Map<String, Integer> map);

    DonateRequestVO getRequestRecord(Map<String, Integer> map);
}