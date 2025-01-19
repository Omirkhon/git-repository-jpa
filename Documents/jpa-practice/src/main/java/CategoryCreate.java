import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class CategoryCreate {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название категории: ");
        String name = scanner.next();

        Category category = new Category();
        category.setName(name);

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(category);
            entityManager.getTransaction().commit();
            System.out.println("Категория создана.");
            System.out.println(category);
        } catch (Exception e) {
            System.out.println("Категория с таким названием уже существует");
        }
    }
}
