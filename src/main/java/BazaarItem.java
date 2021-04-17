import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BazaarItem {
    String productId;
    float sellPrice;
    long sellVolume;
    long sellMovingWeek;
    int sellOrders;
    float buyPrice;
    long buyVolume;
    long buyMovingWeek;
    int buyOrders;

    public BazaarItem(JSONObject qs) {
        productId = qs.getString("productId");
        sellPrice = qs.getFloat("sellPrice");
        sellVolume = qs.getLong("sellVolume");
        sellMovingWeek = qs.getLong("sellMovingWeek");
        sellOrders = qs.getInt("sellOrders");
        buyPrice = qs.getFloat("buyPrice");
        buyVolume = qs.getLong("buyVolume");
        buyMovingWeek = qs.getLong("buyMovingWeek");
        buyOrders = qs.getInt("buyOrders");
    }
}
