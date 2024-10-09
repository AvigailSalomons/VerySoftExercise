package bookstore;

import java.util.List;

public class Bookstore {
    public static void main(String[] args) {
        //Creating different types of books
        Book fictionBook = new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", 100, "Drama");
        Book nonFictionBook = new NonFictionBook("Sapiens", "Yuval Noah Harari", 120, "History");

        // Creating regular and premium customers
        Customer regularCustomer = new RegularCustomer("John Doe");
        Customer premiumCustomer = new PremiumCustomer("Jane Smith", "MEM12345");

        // Adding books for purchase by customers
        regularCustomer.buyBook(fictionBook);
        premiumCustomer.buyBook(nonFictionBook);

        // Displaying the purchased books
        System.out.println(regularCustomer.getName() + " purchased: " + regularCustomer.getPurchasedBooks().get(0).getTitle());
        System.out.println(premiumCustomer.getName() + " purchased: " + premiumCustomer.getPurchasedBooks().get(0).getTitle());

        // Presentation of purchased books and discounts for regular and premium customers
        displayPurchasedBooks(regularCustomer);
        displayPurchasedBooks(premiumCustomer);
    }

    // Thank you for showing the purchased books and discounts
    public static void displayPurchasedBooks(Customer customer) {
        System.out.println("Customer: " + customer.getName());
        List<Book> purchasedBooks = customer.getPurchasedBooks();
        for (Book book : purchasedBooks) {
            double discount = book.calculateDiscount();
//            double discountedPrice = book.getPrice() - (book.getPrice() * discount);

            // If the customer is premium, add an additional 5% discount
            if (customer instanceof PremiumCustomer) {
                discount -= book.getPrice() * 0.05; //additional discount of 5%
            }

            //Displaying the book details and price after discount
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
            System.out.println("Original Price: " + book.getPrice());
            System.out.println("Discounted Price: " + discount);
            System.out.println("----------");
        }
    }
}
