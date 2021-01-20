package pl.javastart.bootcamp.lekcia21zadaniespringmvcprodukty;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Snikers", 2.50, Category.GROCERIES));
        products.add(new Product("Cola", 10.99, Category.GROCERIES));
        products.add(new Product("Masło", 4.60, Category.GROCERIES));
        products.add(new Product("Kubek", 20.60, Category.HOUSEHOLD_ITEMS));
        products.add(new Product("Garnek 1L", 40.99, Category.HOUSEHOLD_ITEMS));
        products.add(new Product("Widelec", 1.50, Category.HOUSEHOLD_ITEMS));
        products.add(new Product("Rower", 1000, Category.OTHER));
        products.add(new Product("Komin", 500, Category.OTHER));
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == (category))
                .collect(Collectors.toList());
    }

    public void add(Product product) {
        products.add(product);
    }
}
