package pigeon.backend.pigeondalback.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shippo.*;
import com.shippo.exception.*;
import com.shippo.model.*;
import pigeon.backend.pigeondalback.constants.SystemConstant;
import org.springframework.boot.configurationprocessor.json.*;
import org.springframework.web.bind.annotation.*;
import pigeon.backend.pigeondalback.service.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping("api/v1/shipment")
public class ShipmentController extends BaseController{
//    @Autowired
//    private IShipmentService shipmentService;
    private final static String SHIPPO = "https://api.goshippo.com/";

    @RequestMapping("details")
    public static JSONObject shipmentDetails(String sid) {
        return null;
    }

    public static void createShipment() {
        // TODO: Create Shipment
        Map<String, Object> addressMap = new HashMap<String, Object>();
        addressMap.put("name", "Shippo shippo");
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

    @GetMapping("{sid}/history")
    // Change to JsonResult<List<VO>>
    public static String trackHistory(String carrier, String trackingNumber) {
        Gson gson = new GsonBuilder().create();
        try {
            String urlLink = SHIPPO + "tracks/" + carrier + "/" + trackingNumber;
            URL url = new URL(urlLink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Authorization", "ShippoToken " + SystemConstant.API_TOKEN);
            InputStream content = connection.getInputStream();
            BufferedReader reader = new BufferedReader (new InputStreamReader(content));
            String result = gson.toJson(reader.readLine());
            return result;
            // return new JsonResult<>(OK, data)
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
