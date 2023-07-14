import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyMap<K, V> {

    private final class MyEntry<K, V>{
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    private static final int DEFAULT_CAPACITY = 16;
    private MyEntry<K, V>[] entries = new MyEntry[DEFAULT_CAPACITY];
    private int size;

    public V get(K key){
        for(int i = 0; i < size; i++){
            if(entries[i].getKey().equals(key))
                return entries[i].getValue();
        }
        return null;
    }
    public void put(K key, V value){
        boolean success = true;

        for(int i = 0; i < size; i++){
            if(entries[i].getKey().equals(key)){
                entries[i].setValue(value);
                success = false;
            }
        }
        if(success){
            checkCapacity();
            entries[size++] = new MyEntry<>(key, value);
        }
    }
    private void checkCapacity(){
        if(size == entries.length){
            int newSize = entries.length * 2;
            entries = Arrays.copyOf(entries, newSize);
        }
    }
    public void remove(K key){
        for(int i = 0; i < size; i++){
            if(entries[i].getKey().equals(key)){
                entries[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }
    public Set<K> setKey(){
        return IntStream.range(0, size).mapToObj(i -> entries[i].getKey()).collect(Collectors.toSet());
    }
    public Collection<V> values(){
        return IntStream.range(0, size).mapToObj(i -> entries[i].getValue()).collect(Collectors.toList());
    }
    private void condenseArray(int start){
        int i;
        for(i = start; i < size; i++){
            entries[i] = entries[i + 1];
        }
        entries[i] = null;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();

        map.put("Alex", 1);
        map.put("Tomy", 2);
        map.put("Anna", 3);

        System.out.println(map);

        System.out.println("Alex value is: " + map.get("Alex"));

        map.remove("Alex");

        System.out.println(map);

        System.out.println(map);
    }
}
