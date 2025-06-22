import java.util.Arrays;
import java.util.Comparator;

class Product {
    private final int productId;
    private final String productName;
    private final String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return String.format("Product [ID=%d, Name=%s, Category=%s]", productId, productName, category);
    }
}

class ProductSearch {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentId = products[mid].getProductId();

            if (currentId == targetId)
                return products[mid];
            else if (currentId < targetId)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Product[] products = {
                new Product(3, "Product C", "Category 2"),
                new Product(1, "Product A", "Category 1"),
                new Product(5, "Product E", "Category 3"),
                new Product(2, "Product B", "Category 1"),
                new Product(4, "Product D", "Category 2")
        };
        Product linearResult = ProductSearch.linearSearch(products, 3);
        System.out.println(
                linearResult != null ? "Linear Search Found: " + linearResult : "Linear Search: Product not found");
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        Product binaryResult = ProductSearch.binarySearch(products, 3);
        System.out.println(
                binaryResult != null ? "Binary Search Found: " + binaryResult : "Binary Search: Product not found");
    }
}
