class CountSquares {

    Map<List<Integer>, Integer> map;

    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> lp = List.of(point[0], point[1]);
        map.putIfAbsent(lp, 0);
        map.put(lp, map.get(lp) + 1);
    }
    
    public int count(int[] point) {
        int count = 0;
        List<Integer> lp = List.of(point[0], point[1]);

        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            List<Integer> dp = entry.getKey();
            if (Math.abs(lp.get(0) - dp.get(0)) == Math.abs(lp.get(1) - dp.get(1)) && Math.abs(lp.get(0) - dp.get(0)) != 0) {
                List<Integer> xp = List.of(lp.get(0), dp.get(1));
                List<Integer> yp = List.of(dp.get(0), lp.get(1));
                int x = map.getOrDefault(xp, 0);
                int y = map.getOrDefault(yp, 0);
                count += entry.getValue() * x * y;
            }
        }

        return count;
    }
}
