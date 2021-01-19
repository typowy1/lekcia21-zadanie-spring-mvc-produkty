package pl.javastart.bootcamp.lekcia21zadaniespringmvcprodukty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String list(Model model) {
        prepareDataForList(model);
        return "list";
    }

    private void prepareDataForList(Model model) {
        List<Product> products;
        products = productRepository.findAll();
        model.addAttribute("products", products);

        double sum = products.stream()
                .mapToDouble(Product::getPrice).sum();

        model.addAttribute("priceSum", sum);
    }
}
