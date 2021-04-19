public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String pid) {
        super("[PID: " + pid + "] Product not found!");
    }
}