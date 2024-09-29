package bookstore;

import java.util.List;

public class Bookstore {
    public static void main(String[] args) {
        // יצירת ספרים מסוגים שונים
        Book fictionBook = new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", 100, "Drama");
        Book nonFictionBook = new NonFictionBook("Sapiens", "Yuval Noah Harari", 120, "History");

        // יצירת לקוחות רגילים ופרימיום
        Customer regularCustomer = new RegularCustomer("John Doe");
        Customer premiumCustomer = new PremiumCustomer("Jane Smith", "MEM12345");

        // הוספת ספרים לרכישה על ידי הלקוחות
        regularCustomer.buyBook(fictionBook);
        premiumCustomer.buyBook(nonFictionBook);

        // הצגת הספרים שנרכשו
        System.out.println(regularCustomer.getName() + " purchased: " + regularCustomer.getPurchasedBooks().get(0).getTitle());
        System.out.println(premiumCustomer.getName() + " purchased: " + premiumCustomer.getPurchasedBooks().get(0).getTitle());

        // הצגת הספרים שנרכשו והנחות ללקוחות רגילים ופרימיום
        displayPurchasedBooks(regularCustomer);
        displayPurchasedBooks(premiumCustomer);
    }

    // מתודה להצגת הספרים שנרכשו והנחות
    public static void displayPurchasedBooks(Customer customer) {
        System.out.println("Customer: " + customer.getName());
        List<Book> purchasedBooks = customer.getPurchasedBooks();
        for (Book book : purchasedBooks) {
            double discount = book.calculateDiscount();
//            double discountedPrice = book.getPrice() - (book.getPrice() * discount);

            // במידה והלקוח הוא פרימיום, מוסיפים הנחה של 5% נוספים
            if (customer instanceof PremiumCustomer) {
                discount -= book.getPrice() * 0.05; // הנחה נוספת של 5%
            }

            // הצגת פרטי הספר והמחיר לאחר הנחה
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
            System.out.println("Original Price: " + book.getPrice());
            System.out.println("Discounted Price: " + discount);
            System.out.println("----------");
        }
    }
}
