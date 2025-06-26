package in.edu.kristujayanti;

import java.time.LocalDate;

public class Order {
    private String orderId;
    private String userId;
    private String product;
    private int quantity;
    private double price;
    private String status;
    private LocalDate date;

    public Order(String orderId, String userId, String product, int quantity, double price, String status, LocalDate date) {
        this.orderId = orderId;
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
