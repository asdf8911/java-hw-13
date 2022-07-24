public class Product {
    protected int id; // айди
    protected String name; // название
    protected int cost; // стоимость

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Product(int id, String name, int cost) { // конструктор
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

}
