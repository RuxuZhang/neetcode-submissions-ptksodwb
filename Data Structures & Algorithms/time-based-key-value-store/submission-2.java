class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key) || timestamp < map.get(key).get(0).getKey()) {
            return "";
        }

        List<Pair<Integer, String>> values = map.get(key);
        int size = values.size();
        int l = 0, r = size - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (values.get(mid).getKey() <= timestamp) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return values.get(r).getValue();
    }
}
