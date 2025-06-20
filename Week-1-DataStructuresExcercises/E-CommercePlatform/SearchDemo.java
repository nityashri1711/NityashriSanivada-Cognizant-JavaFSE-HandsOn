import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == id) return products[mid];
            else if (products[mid].productId < id) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(202, "Shoes", "Fashion"),
            new Product(303, "Book", "Education"),
            new Product(404, "Smartphone", "Electronics"),
        };

        // Linear Search
        System.out.println("Linear Search:");
        Product found1 = linearSearch(products, 303);
        System.out.println(found1 != null ? found1 : "Product not found");

        // Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        System.out.println("Binary Search:");
        Product found2 = binarySearch(products, 303);
        System.out.println(found2 != null ? found2 : "Product not found");

        // Analysis
        System.out.println("\nAnalysis:");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n), requires sorted data.");
    }
}
