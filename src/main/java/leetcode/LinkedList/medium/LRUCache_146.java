package leetcode.LinkedList.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146 {
    static class LRUCache {

        LinkedHashMap<Integer, Integer> cache;
        int capacity;

        public LRUCache(int capacity) {
            this.cache = new LinkedHashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            if(this.cache.containsKey(key)){
                int value = this.cache.get(key);
                this.cache.remove(key);
                this.cache.put(key, value);
                return value;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(this.cache.size() >= this.capacity){

                if(this.cache.containsKey(key)){
                    this.cache.remove(key);
                }else{
                    for(Map.Entry<Integer, Integer> entry : this.cache.entrySet()){
                        this.cache.remove(entry.getKey());
                        break;
                    }
                }

                this.cache.put(key, value);
            } else{
                if(this.cache.containsKey(key)){
                    this.cache.remove(key);
                }
                this.cache.put(key, value);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
