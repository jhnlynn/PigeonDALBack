package pigeon.backend.pigeondalback.service.serviceImpl;

import org.springframework.stereotype.Service;
import pigeon.backend.pigeondalback.mapper.BatchMapper;
import pigeon.backend.pigeondalback.service.ShipmentService;
import pigeon.backend.pigeondalback.vo.DonateRequestVO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("shipmentService")
public class ShipmentServiceImpl implements ShipmentService {

    @Resource
    BatchMapper batchMapper;

    public List<DonateRequestVO> getHistory(String uid, Long size, Long page) throws Exception {
        List<DonateRequestVO> donates;
        HashMap<String, Object> paramMap = new HashMap<>();

        paramMap.put("uid", uid);
        paramMap.put("size", size);
        paramMap.put("page", page);

        try {
            donates = batchMapper.getDonateHistory(paramMap);
        } catch (Exception ex) {
            throw new Exception("Thrown By PostS, " + ex);
        }

        return donates;
    }

    public DonateRequestVO getDonationRecord(String uid, String shipId) throws Exception {
        // getDonationRecord
        DonateRequestVO donate;
        HashMap<String, String> paramMap = new HashMap<>();

        paramMap.put("uid", uid);
        paramMap.put("shipId", shipId);

        try {
            donate = batchMapper.getDonationRecord(paramMap);
        } catch (Exception ex) {
            throw new Exception("Thrown By PostS, " + ex);
        }

        return donate;
    }

    public DonateRequestVO getRequestRecord(String uid, String shipId) throws Exception {
        DonateRequestVO donate;
        HashMap<String, String> paramMap = new HashMap<>();

        paramMap.put("uid", uid);
        paramMap.put("shipId", shipId);

        try {
            donate = batchMapper.getRequestRecord(paramMap);
        } catch (Exception ex) {
            throw new Exception("Thrown By PostS, " + ex);
        }

        return donate;
    }

}
