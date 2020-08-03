package other;

import java.util.LinkedHashMap;


/**
 * @author Administrator
 * @date 2020/8/1 16:39
 */

public class LruCache<K,V> extends LinkedHashMap<K,V> {
    /** 最大容量 */
    private int maxCapacity;

    public LruCache(int maxCapacity) {
        super(16, 0.75f, true);
        this.maxCapacity = maxCapacity;
    }

    /**
     * 当列表中的元素个数大于指定的最大容量时，返回true,并将最老的元素删除。
     */
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        if (super.size() > maxCapacity) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LruCache<String, Object> cache = new LruCache<String, Object>(10);

        for (int i = 1; i <= 15; i++) {
            cache.put(i + "", i);
        }

        // 此时访问指定KEY的元素
        cache.get("10");
        cache.get("12");

        System.out.println(cache);
    }
}
