package in.edu.kristujayanti.handlers;

import in.edu.kristujayanti.Order;
import in.edu.kristujayanti.services.OrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class OrderHandler {
    private OrderService service = new OrderService();

    public void simulate() {
        // Place orders
        Order order1 = new Order(UUID.randomUUID().toString(), "user1", "Laptop", 1, 50000, "Pending", LocalDate.now());
        Order order2 = new Order(UUID.randomUUID().toString(), "user2", "Phone", 2, 20000, "Pending", LocalDate.now());

        service.placeOrder(order1);
        printOrderConfirmation(order1);

        service.placeOrder(order2);
        printOrderConfirmation(order2);

        // Update status
        List<Order> orders = service.getOrderHistoryByUser("user1");
        if (!orders.isEmpty()) {
            service.updateOrderStatus(orders.get(0).getOrderId(), "Shipped");
        }

        // View user history
        System.out.println("\n📜 Order History for user1");
        System.out.println("-----------------------------------");
        for (Order o : service.getOrderHistoryByUser("user1")) {
            System.out.printf("🆔 %s | 📦 %s | 💰 ₹%.2f x %d | 📌 %s | 📅 %s\n",
                    o.getOrderId(), o.getProduct(), o.getPrice(), o.getQuantity(), o.getStatus(), o.getDate());
        }
        System.out.println("-----------------------------------\n");

        // Aggregate sales
        System.out.println("📊 Total Sales for Laptop: ₹" + service.aggregateSalesByProduct("Laptop"));
        System.out.println("📅 Total Sales on " + LocalDate.now() + ": ₹" + service.aggregateSalesByDate(LocalDate.now()));
    }

    private void printOrderConfirmation(Order order) {
        System.out.println("✅ Order Placed Successfully!");
        System.out.println("🆔 Order ID : " + order.getOrderId());
        System.out.println("👤 User ID  : " + order.getUserId());
        System.out.println("📦 Product  : " + order.getProduct());
        System.out.println("📅 Date     : " + order.getDate());
        System.out.println("💰 Amount   : ₹" + (order.getPrice() * order.getQuantity()));
        System.out.println("📌 Status   : " + order.getStatus());
        System.out.println("-----------------------------------");
    }
}
