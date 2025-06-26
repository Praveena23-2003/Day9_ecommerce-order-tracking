# 🛒 E-commerce Order Tracking System

### 📅 Task Day 9 - Java + MongoDB Project

This is a simple backend simulation of an E-commerce Order Tracking System using Java, Maven, and MongoDB (via MongoDB Compass and the `mongodb-driver-sync` library).

---

## ✅ Features Implemented

| Feature                              | Status  |
|--------------------------------------|---------|
| 🆕 Place New Orders                  | ✅ Done |
| ✏️ Update Order Status               | ✅ Done |
| 📜 View Order History by User        | ✅ Done |
| 📊 Aggregate Sales by Product/Date   | ✅ Done |
| 💾 Persistent Storage in MongoDB     | ✅ Done |

---

## 🧾 Sample Order Schema

Each order is saved to the `orders` collection in the `ecommerce_db` MongoDB database:

```json
{
  "_id": "ObjectId",
  "orderId": "UUID",
  "userId": "user1",
  "product": "Laptop",
  "quantity": 1,
  "price": 50000,
  "status": "Shipped",
  "date": "2025-06-26"
}
🗃️ MongoDB Setup
🧩 Database: ecommerce_db

🗂️ Collection: orders

📦 MongoDB must be running locally on localhost:27017

MongoDB URI used:

plaintext
Copy
Edit
mongodb://localhost:27017
📂 Project Structure
css
Copy
Edit
src/
├── main/
│   ├── java/
│   │   └── in/edu/kristujayanti/
│   │       ├── Main.java
│   │       ├── Order.java
│   │       ├── handlers/
│   │       │   └── OrderHandler.java
│   │       └── services/
│   │           ├── OrderService.java
│   │           └── MongoDBUtil.java
🛠️ How to Run
✅ Ensure MongoDB is running locally.

💡 Compile the project:

bash
Copy
Edit
mvn clean install
▶️ Run Main.java or call OrderHandler.simulate() to test functionality.

📦 Dependencies (from pom.xml)
mongodb-driver-sync – MongoDB Java driver

log4j-slf4j-impl – Logging

commons-cli, commons-lang3 – Utility support

vertx-core, vertx-web – (Optional for web support)

📸 Sample Output
yaml
Copy
Edit
Order placed in MongoDB: ae4cd24e-a186-4492-a499-7be7f9166024
✅ Order Placed Successfully!
🆔 Order ID : ae4cd24e-a186-4492-a499-7be7f9166024
👤 User ID  : user1
📦 Product  : Laptop
📅 Date     : 2025-06-26
💰 Amount   : ₹50000.0
📌 Status   : Pending
...
📊 Total Sales for Laptop: ₹50000.0
📅 Total Sales on 2025-06-26: ₹90000.0
🎓 Author
👩‍💻 Praveena R
📘 College: Kristu Jayanti College
📚 Stack: Java + MongoDB