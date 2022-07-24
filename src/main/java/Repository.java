public class Repository {
    protected Product[] items = new Product[0];

    public void save(Product item) { // МЕТОД, позволяющий сохранять Product'ы
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] findAll() { // МЕТОД, позволяющий получать все сохранённые Product'ы
        return items;
    }

    public Product[] findById(int id) { // МЕТОД, предназначенный для поиска товара в репозитории по его id
        Product[] result = new Product[0];
        for (Product item : findAll()) {
            if (item.getId() == id) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(findAll(), 0, tmp, 0, result.length);
                int index = 0;
                tmp[index] = item;
                result = tmp;
                return result;
            }
        }
        return null;
    }
    public void deleteById(int id) { // МЕТОД, похволяющий удалять по id

        Repository repository = new Repository();
        repository.findById(id);

        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            Product[] tmp = new Product[items.length - 1];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }



}
