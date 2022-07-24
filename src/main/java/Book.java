public class Book extends Product {  // класс унаследованный от Product
    protected String author; // автор, а поле "название" есть в Product

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }
}
