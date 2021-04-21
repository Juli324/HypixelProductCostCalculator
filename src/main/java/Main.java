import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BazaarItem> bi = JSONLoader.getBazaarList(JSONLoader.getBazaarJSON());
        try {
            System.out.println(BazaarItem.getByPID("BROWN_MUSHROOM", bi).buyPrice);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }
}
