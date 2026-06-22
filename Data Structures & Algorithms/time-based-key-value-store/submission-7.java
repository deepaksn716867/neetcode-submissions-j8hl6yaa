class TimeMap {
    Map<String, List<String[]>> timestampMap;
    public TimeMap() {
        timestampMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timestampMap.computeIfAbsent(key , a -> new ArrayList<>()).add(new String[]{value, Integer.toString(timestamp)});
        
    }
    
    public String get(String key, int timestamp) {
        if(timestampMap.get(key) == null) {
            return "";
        }
        List<String[]> searchArray = timestampMap.get(key);
        int left = 0;
        int right = searchArray.size() - 1;
        String[] max_value = new String[2];
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(Integer.parseInt(searchArray.get(mid)[1]) <= timestamp) {
                max_value = searchArray.get(mid);
            }
            if(Integer.parseInt(searchArray.get(mid)[1]) == timestamp) {
                return searchArray.get(mid)[0];
            } else if(Integer.parseInt(searchArray.get(mid)[1]) < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max_value[1] != null ? (Integer.parseInt(max_value[1]) <= timestamp ? max_value[0] : "") : "";
    }
}
