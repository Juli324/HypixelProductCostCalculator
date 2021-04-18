import java.util.ArrayList;
import java.util.HashMap;

public class ItemIndexer {
    public static HashMap<String, Integer> create(ArrayList<BazaarItem> arrayList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            BazaarItem bzi = arrayList.get(i);
            hashMap.put(bzi.productId,i);
        }
        return hashMap;
    }
}