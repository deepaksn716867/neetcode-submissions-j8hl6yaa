class LRUCache {

    int capacity;
    Map<Integer, Integer> keyToValue = new HashMap<>();
    Set<Integer> recency = new LinkedHashSet<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
   
    public int get(int key) {
        int value = keyToValue.getOrDefault(key, -1);
        if(value != -1) {
            recency.remove(key);
            recency.add(key);
        }
        return value;
    }
    
    public void put(int key, int value) {
        keyToValue.put(key, value);
        recency.remove(key);
        recency.add(key);
        if(recency.size() > capacity) {
            Iterator<Integer> itr = recency.iterator();
            int valueToRemove = itr.next();
            itr.remove();
            keyToValue.remove(valueToRemove);
        }
    }
}
