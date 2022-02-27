package pigeon.backend.pigeondalback.service;

import pigeon.backend.pigeondalback.vo.DonateRequestVO;

import java.util.List;

public interface ShipmentService {

    List<DonateRequestVO> getHistory(String uid, Long size, Long page) throws Exception;

    DonateRequestVO getDonationRecord(String uid, String shipId) throws Exception;

    DonateRequestVO getRequestRecord(String uid, String shipId) throws Exception;
}
