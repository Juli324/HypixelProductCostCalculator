import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BazaarItem> bi = JSONLoader.getBazaarList(JSONLoader.getBazaarJSON());
        BazaarItem item;
        try {
            item = BazaarItem.getByPID("BROWN_MUSHROOM", bi);
            System.out.println(item.buyPrice);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }
}
