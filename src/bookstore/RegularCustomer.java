package bookstore;

import java.util.ArrayList;
import java.util.List;

public class RegularCustomer implements Customer {
    private String name;

    protected List<Book> books;

    public RegularCustomer(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void buyBook(Book book) {
        this.books.add(book);
    }

    @Override
    public List<Book> getPurchasedBooks() {
        return books;
    }
}
