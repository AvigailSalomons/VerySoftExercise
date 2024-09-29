package bookstore;

public class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook(String title, String author, double price, String subject) {
        super(title, author, price);
        this.subject = subject;
    }

    @Override
    public double calculateDiscount() {
        return price-price * 0.05; // 5% discount
    }
}
