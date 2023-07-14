import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

public class LRUCache <K, V> implements Cache<K, V>{
    private final int capacity;
    private Map<K, Element<K, V>> elementMap;
    private LinkedList<Element<K, V>> elementLinkedList;

    public LRUCache(int capacity){
        this.capacity = capacity;
        elementMap = new HashMap<>();
        elementLinkedList = new LinkedList<>();
    }

    @Override
    public Optional<V> get(K key) {
        Optional<V> value = Optional.empty();
        if(containsKey(key)){
            final Element<K, V> element = elementMap.get(key);
            value = Optional.of(element.value);
            elementLinkedList.remove(element);
            elementLinkedList.addFirst(element);
        }

        return value;
    }

    @Override
    public boolean containsKey(K key) {
        return elementMap.containsKey(key);
    }

    @Override
    public void put(K key, V value) {
        if(containsKey(key)){
            elementLinkedList.remove(elementMap.get(key));
        }else{
            ensureCapacity();
        }
        final Element<K, V> element = new Element<>(key, value);
        elementMap.put(key, element);
        elementLinkedList.addFirst(element);
    }

    @Override
    public int size() {
        return elementLinkedList.size();
    }
    Optional<K> getLastRecentKey(){
        return elementLinkedList.size() > 0 ? Optional.of(elementLinkedList.getFirst().key) : Optional.empty();
    }
    private boolean isSizeExceeded(){
        return size() == capacity;
    }
    private void ensureCapacity(){
        if(isSizeExceeded()){
            final Element<K, V> removedElement = elementLinkedList.removeLast();
            elementMap.remove(removedElement.key);
        }
    }


    public int getCapacity() {
        return capacity;
    }
    protected static class Element<K, V>{
        protected final K key;
        protected final V value;

        public Element(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

}
