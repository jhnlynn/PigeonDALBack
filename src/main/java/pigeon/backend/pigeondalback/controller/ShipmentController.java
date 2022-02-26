package pigeon.backend.pigeondalback.controller;

import com.shippo.*;
import com.shippo.exception.*;
import com.shippo.model.*;
import pigeon.backend.pigeondalback.constants.SystemConstant;
import org.springframework.boot.configurationprocessor.json.*;
import org.springframework.web.bind.annotation.*;
import pigeon.backend.pigeondalback.service.*;

import java.util.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController extends BaseController{
//    @Autowired
//    private IShipmentService shipmentService;

    @RequestMapping("details")
    public static JSONObject shipmentDetails(String sid) {
        return null;
    }

    public static void createShipment() {
        //        String sid = Shipment.getSid
        String apiKey = SystemConstant.API_KEY;
        String url = "";

        Map<String, Object> addressMap = new HashMap<String, Object>();
        addressMap.put("name", "Shippo Itle");
        addressMap.put("company", "Shippo");
        addressMap.put("street1", "215 Clayton St.");
        addressMap.put("city", "San Francisco");
        addressMap.put("state", "CA");
        addressMap.put("zip", "94117");
        addressMap.put("country", "US");
        addressMap.put("phone", "+1 555 341 9393");
        addressMap.put("email", "test@goshipppo.com");

        try {
            Address address = Address.create(addressMap);
            System.out.println(address.toString());
            System.out.println("Zip code: " + address.getZip());
        } catch (ShippoException e) {
            e.printStackTrace();
        }
    }
}
