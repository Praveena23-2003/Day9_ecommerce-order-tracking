package in.edu.kristujayanti.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import in.edu.kristujayanti.Order;
import org.bson.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OrderService {
    private final MongoCollection<Document> orderCollection;

    public OrderService() {
        MongoDatabase db = MongoDBUtil.getDatabase();
        this.orderCollection = db.getCollection("orders");
    }

    public void placeOrder(Order order) {
        Document doc = new Document("orderId", order.getOrderId())
                .append("userId", order.getUserId())
                .append("product", order.getProduct())
                .append("quantity", order.getQuantity())
                .append("price", order.getPrice())
                .append("status", order.getStatus())
                .append("date", order.getDate().toString());
        orderCollection.insertOne(doc);
        System.out.println("Order placed in MongoDB: " + order.getOrderId());
    }

    public void updateOrderStatus(String orderId, String status) {
        orderCollection.updateOne(
                Filters.eq("orderId", orderId),
                new Document("$set", new Document("status", status))
        );
        System.out.println("Order status updated in MongoDB.");
    }

    public List<Order> getOrderHistoryByUser(String userId) {
        List<Order> orders = new ArrayList<>();
        for (Document doc : orderCollection.find(Filters.eq("userId", userId))) {
            orders.add(documentToOrder(doc));
        }
        return orders;
    }

    public double aggregateSalesByProduct(String product) {
        double total = 0;
        for (Document doc : orderCollection.find(Filters.eq("product", product))) {
            int quantity = doc.getInteger("quantity");
            double price = doc.getDouble("price");
            total += quantity * price;
        }
        return total;
    }

    public double aggregateSalesByDate(LocalDate date) {
        double total = 0;
        for (Document doc : orderCollection.find(Filters.eq("date", date.toString()))) {
            int quantity = doc.getInteger("quantity");
            double price = doc.getDouble("price");
            total += quantity * price;
        }
        return total;
    }

    private Order documentToOrder(Document doc) {
        return new Order(
                doc.getString("orderId"),
                doc.getString("userId"),
                doc.getString("product"),
                doc.getInteger("quantity"),
                doc.getDouble("price"),
                doc.getString("status"),
                LocalDate.parse(doc.getString("date"))
        );
    }
}
