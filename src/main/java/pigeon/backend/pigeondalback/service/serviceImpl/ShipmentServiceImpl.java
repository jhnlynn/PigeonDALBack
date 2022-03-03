package pigeon.backend.pigeondalback.service.serviceImpl;

import org.springframework.stereotype.Service;
import pigeon.backend.pigeondalback.mapper.BatchMapper;
import pigeon.backend.pigeondalback.service.IShipmentService;
import pigeon.backend.pigeondalback.vo.DonateRequestVO;

import java.util.List;
import java.util.HashMap;
import javax.annotation.Resource;
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;

@Service("shipmentService")
public class ShipmentServiceImpl implements IShipmentService {
    private final static String SHIPPO = "https://api.goshippo.com/";

    @Resource
    BatchMapper batchMapper;

    public List<DonateRequestVO> getHistory(Integer uid, Integer size, Integer page) throws Exception {
        List<DonateRequestVO> donationList;
        HashMap<String, Integer> paramMap = new HashMap<>();

        paramMap.put("uid", uid);
        paramMap.put("size", size);
        paramMap.put("page", page);

        try {
            donationList = batchMapper.getDonateHistory(paramMap);
        } catch (Exception ex) {
            throw new Exception("Thrown By PostS, " + ex);
        }

        return donationList;
    }

    public DonateRequestVO getDonationRecord(Integer uid, Integer sid) throws Exception {
        // getDonationRecord
        DonateRequestVO donation;
        HashMap<String, Integer> paramMap = new HashMap<>();

        paramMap.put("uid", uid);
        paramMap.put("shipId", sid);

        try {
            donation = batchMapper.getDonationRecord(paramMap);
        } catch (Exception ex) {
            throw new Exception("Thrown By PostS, " + ex);
        }

        return donation;
    }

    public DonateRequestVO getRequestRecord(Integer uid, Integer sid) throws Exception {
        DonateRequestVO donate;
        HashMap<String, Integer> paramMap = new HashMap<>();

        paramMap.put("uid", uid);
        paramMap.put("shipId", sid);

        try {
            donate = batchMapper.getRequestRecord(paramMap);
        } catch (Exception ex) {
            throw new Exception("Thrown By PostS, " + ex);
        }

        return donate;
    }
}