package pigeon.backend.pigeondalback.service;

import java.util.List;
import pigeon.backend.pigeondalback.vo.DonateRequestVO;

public interface IShipmentService {
    List<DonateRequestVO> getHistory(Integer uid, Integer size, Integer page) throws Exception;

    DonateRequestVO getDonationRecord(Integer uid, Integer sid) throws Exception;

    DonateRequestVO getRequestRecord(Integer uid, Integer sid) throws Exception;
}
