import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepositoryTest {
    Product oneP = new Product(1, "black pen", 200);
    Book oneB = new Book(123, "1984", 666, "Оруэл");
    Smartphone oneS = new Smartphone(11, "iФон", 66_666, "Джобс");
    Book twoB = new Book(124, "Скотный двор", 444, "Оруэл");
    Repository repo = new Repository();

    @Test
    public void howRepoDeleteById() {
        // подготовка
        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        repo.save(twoB);

        repo.deleteById(11);

        // тестируемое действие
        Product[] actual = repo.findAll();
        Product[] expected = {oneP, oneB, twoB};

        // проверка
        assertArrayEquals(expected, actual);
    }

    @Test
    public void howRepoDeleteByNotExistId() {
        // подготовка
        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        repo.save(twoB);

        assertThrows(NotFoundException.class, () -> {repo.deleteById(-11);});
    }

    @Test
    public void howRepoFindById() {
        // подготовка

        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        repo.save(twoB);

        Product[] actual = repo.findById(11);
        Product[] expected = {oneS};

        //проверка
        assertArrayEquals(actual, expected);

    }

    @Test
    public void howRepoSave1() {
        repo.save(oneP);

        Product[] actual = repo.findAll();
        Product[] expected = {oneP};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void howRepoSave2() {
        repo.save(oneP);
        repo.save(oneB);

        Product[] actual = repo.findAll();
        Product[] expected = {oneP, oneB};

        assertArrayEquals(actual, expected);
    }

}