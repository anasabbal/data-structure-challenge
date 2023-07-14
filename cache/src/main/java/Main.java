import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        // Create a new LRUCache with a capacity of 3
        LRUCache<String, Integer> cache = new LRUCache<>(3);

        // Put some key-value pairs into the cache
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        // Retrieve the value associated with key "A"
        Optional<Integer> valueA = cache.get("A");
        System.out.println("Value of A: " + valueA.orElse(null)); // Output: Value of A: 1

        // Retrieve the value associated with a non-existent key "D"
        Optional<Integer> valueD = cache.get("D");
        System.out.println("Value of D: " + valueD.orElse(null)); // Output: Value of D: null

        // Add another key-value pair, exceeding the cache capacity
        cache.put("D", 4);

        // Retrieve the value associated with key "B" (which should have been evicted)
        Optional<Integer> valueB = cache.get("B");
        System.out.println("Value of B: " + valueB.orElse(null)); // Output: Value of B: null

        // Retrieve the value associated with key "D"
        Optional<Integer> valueDNew = cache.get("D");
        System.out.println("Value of D: " + valueDNew.orElse(null)); // Output: Value of D: 4
    }
}
