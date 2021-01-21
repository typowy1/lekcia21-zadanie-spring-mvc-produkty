package pl.javastart.bootcamp.lekcia21zadaniespringmvcprodukty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/lista")
    public String list(Model model, @RequestParam(required = false, name = "kategoria") Category category) {
        List<Product> products;

        if (category != null) {
            products = productRepository.findByCategory(category);
        } else {
            products = productRepository.findAll();
        }

        double sum = sumPrices(products);

        model.addAttribute("products", products);
        model.addAttribute("category", category);
        model.addAttribute("priceSum", sum);

        return "list";
    }

    @GetMapping("/dodaj")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/dodaj")
    public String addProduct(Product product) {
        productRepository.add(product);
        return "redirect:/lista?kategoria=" + product.getCategory();
    }

    private double sumPrices(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
