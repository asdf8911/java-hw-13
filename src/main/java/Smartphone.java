public class Smartphone extends Product {

    protected String maker; // производитель, а поле "название" есть в Product

    public Smartphone(int id, String name, int cost, String maker) {
        super(id, name, cost);
        this.maker = maker;
    }
}
