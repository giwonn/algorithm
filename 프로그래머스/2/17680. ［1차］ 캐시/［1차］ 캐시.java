import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int processTime = 0;
        
        LRUCache<String> cache = new LRUCache<>(cacheSize);
        
        for (String city: cities) {
            processTime += cache.add(city.toLowerCase());
        }
        
        return processTime;
    }
}

class LRUCache<E> {
    private final int HIT_TIME = 1;
    private final int MISS_TIME = 5;
    
    private final int maxSize;
    private final Set<E> cache;
    
    LRUCache(int cacheSize) {
        maxSize = cacheSize;
        cache = new LinkedHashSet<>(); // 순서가 있는 Set
    }
    
    public int add(E element) {
        if (maxSize == 0) return MISS_TIME;
        return cache.contains(element) ? hit(element) : miss(element);
    }
    
    private int hit(E element) {
        cache.remove(element);
        cache.add(element);
        return HIT_TIME;
    }
    
    private int miss(E element) {
        if (cache.size() >= maxSize) {
            removeOldest();
        }
        cache.add(element);
        return MISS_TIME;
    }

    private void removeOldest() {
       if (cache.size() == 0) return;
       
       Iterator<E> iterator = cache.iterator();
       iterator.next(); // 첫번째 요소에 접근하여
       iterator.remove(); // 제거
   }
}