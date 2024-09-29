package bookstore;

import java.util.List;

public interface Customer {
    String getName();
    void buyBook(Book book);
    List<Book> getPurchasedBooks();
}
