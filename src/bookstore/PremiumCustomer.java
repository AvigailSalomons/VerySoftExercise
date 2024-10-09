package bookstore;

import java.util.ArrayList;
import java.util.List;

public class PremiumCustomer implements Customer {
    private String name;

    protected List<Book> books;

    private String memberShipId;


    public PremiumCustomer(String name, String membershipId) {
        this.name = name;
        this.memberShipId = membershipId;
        this.books = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void buyBook(Book book) {
        double discount = book.calculateDiscount() - book.calculateDiscount() * 0.05;
        System.out.println("Premium discount applied: " + discount);
        books.add(book);
    }

    @Override
    public List<Book> getPurchasedBooks() {
        return books;
    }
}
