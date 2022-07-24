public class Manager {
    private Repository repo;

    public Manager(Repository repository) { // конструктор принимает параметром репозиторий
        this.repo = repository;
    }

    public void add(Product item) {
        repo.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product item : repo.findAll()) {
            if (matches(item, text)) {
                // "добавляем в конец" массива result продукт item
                Product[] tmp = new Product[result.length + 1];
//                for (int i = 0; i < result.length; i++) {
//                    tmp[i] = result[i];
//                }
//                tmp[tmp.length-1]= item;
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара item запросу search
    public boolean matches(Product item, String search) {
        if (item.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
