package entity;

public class Product {
    private int productId;
    private String productName;
    private int quantity;

    public Product() {

    }

    public Product(String productName, int quantity){
        this.setProductName(productName);
        this.setQuantity(quantity);
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + getProductId() +
                ", productName='" + getProductName() + '\'' +
                ", quantity=" + getQuantity() +
                '}';
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}