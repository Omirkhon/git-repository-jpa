import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Category;

import java.util.List;
import java.util.Scanner;

public class ProductCreate {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        TypedQuery<Category> query = entityManager.createQuery("from Category", Category.class);

        List<Category> categories = query.getResultList();

        for (Category category : categories) {
            System.out.println(category.getId() + ". " + category.getName());
        }

        System.out.print("Выберите категорию: ");
        int categoryId = scanner.nextInt();

        System.out.print("Введите название товара: ");
        String name = scanner.nextLine();

        System.out.println("Введите стоимость товара: ");

        try {
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
            System.out.println("Категория создана.");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }
}
