
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {
    Product oneP = new Product(1, "black pen", 200);
    Book oneB = new Book(123, "1984", 666, "Оруэл");
    Smartphone oneS = new Smartphone(11, "iФон", 66_666, "Джобс");
    Book twoB = new Book(124, "Скотный двор", 444, "Оруэл");
    Book threeB = new Book(10, "black pen", 80, "unknown");

    @Test
    public void howManagerAdd() {
        // подготовка
        Repository repo = new Repository();
        Manager man = new Manager(repo);

        man.add(oneP);
        man.add(oneB);
        man.add(oneS);

        // тестируемое действие
        Product[] actual = repo.findAll();
        Product[] expected = {oneP, oneB, oneS};

        // проверка
        assertArrayEquals(expected, actual);
    }

    @Test
    public void howManagerSearchBy() { // МЕТОД ПОИСКА: находится несколько
        // подготовка
        Repository repo = new Repository();
        Manager man = new Manager(repo);

        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        repo.save(twoB);
        repo.save(threeB);

        // тестируемое действие
        Product[] actual = man.searchBy("black pen");
        Product[] expected = new Product[]{oneP, threeB};

        // проверка
        assertArrayEquals(expected, actual);
    }

    @Test
    public void howManagerSearchOne() { // МЕТОД ПОИСКА: находится один
        // подготовка
        Repository repo = new Repository();
        Manager man = new Manager(repo);

        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        repo.save(twoB);
        repo.save(threeB);

        // тестируемое действие
        Product[] actual = man.searchBy("1984");
        Product[] expected = new Product[]{oneB};

        // проверка
        assertArrayEquals(expected, actual);
    }

    @Test
    public void howManagerSearchZero() { // МЕТОД ПОИСКА: не находится ничего
        // подготовка
        Repository repo = new Repository();
        Manager man = new Manager(repo);

        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        repo.save(twoB);
        repo.save(threeB);

        // тестируемое действие
        Product[] actual = man.searchBy("1985");
        Product[] expected = new Product[0];

        // проверка
        assertArrayEquals(expected, actual);
    }

    @Test
    public void howManagerMatch() {
        // подготовка
        Repository repo = new Repository();
        Manager man = new Manager(repo);

        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        man.searchBy("i");

        // тестируемое действие
        Product[] actual = man.searchBy("i");
        Product[] expected = new Product[]{oneS};

        // проверка
        assertArrayEquals(expected, actual);
    }


}
