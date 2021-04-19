import org.json.JSONObject;

import java.util.ArrayList;

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

    public static BazaarItem getByPID(String product_id, ArrayList<BazaarItem> list) throws ProductNotFoundException {
        for (BazaarItem bazaarItem : list) {
            if (bazaarItem.productId.equals(product_id)) {
                return bazaarItem;
            }
        }
        throw new ProductNotFoundException(product_id);
    }
}