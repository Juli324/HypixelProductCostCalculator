import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BazaarItem> bi = JSONLoader.getBazaarList(JSONLoader.getBazaarJSON());
        //System.out.println(bi.get(100).buyPrice);
        System.out.println(ItemIndexer.create(bi));
    }
}
