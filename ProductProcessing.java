import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductProcessing {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 999.99),
                new Product("Smartphone", "Electronics", 699.99),
                new Product("Desk", "Furniture", 450.0),
                new Product("Chair", "Furniture", 120.0),
                new Product("Headphones", "Electronics", 150.0)
        );

        // Group products by category and find the most expensive in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))
                ));

        // Display the most expensive products by category
        System.out.println("Most expensive products by category:");
        mostExpensiveByCategory.forEach((category, productOpt) -> {
            System.out.printf("%s: %s - $%.2f%n",
                    category,
                    productOpt.map(Product::getName).orElse("None"),
                    productOpt.map(Product::getPrice).orElse(0.0));
        });

        // Calculate and display the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.printf("%nAverage price of all products: $%.2f%n", averagePrice);
    }
}

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
