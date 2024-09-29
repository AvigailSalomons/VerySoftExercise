package bookstore;

public class FictionBook extends Book {
    private String genre;

    public FictionBook(String title, String author, double price, String genre) {
        super(title, author, price);
        this.genre = genre;
    }

    @Override
    public double calculateDiscount() {
        return price-price * 0.1; // 10% discount
    }
}
