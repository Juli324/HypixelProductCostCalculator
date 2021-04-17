import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BazaarItem> bi = JSONLoader.getBazaarList(JSONLoader.getBazaarJSON());
        System.out.println(bi.get(5).productId);
    }
}
