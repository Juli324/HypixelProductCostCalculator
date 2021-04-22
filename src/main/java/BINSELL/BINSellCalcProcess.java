package BINSELL;

public class BINSellCalcProcess {

    private final String JsonPath, ItemID;

    public BINSellCalcProcess(String JsonPath, String ItemID) {
        this.ItemID = ItemID;
        this.JsonPath = JsonPath;
    }

    /**
     * TODO: get ItemID values from bazzar.json and calculate Average
     * all Values from wished Item / Number of all prices
     */

    public float sumOfPrices() {
        // TODO:get Item PRices and list them
        float[] allPrices = new float[0];
        float price = 0;
        for (int i = 0; i < allPrices.length; i++) {
            price = price + allPrices[i];
        }
        return price;
    }

    public float countItems() {
        // TODO:get Items by ID and append to IntArray
        int[] Items = new int[0];
        return Items.length;
    }

    public float getAverageValue() {
        return countItems()/sumOfPrices();
    }

}