


class Solution {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>((k, v) -> v.getKey() - k.getKey());
        if (a > 0) pq.offer(new Pair<>(a, 'a'));
        if (b > 0) pq.offer(new Pair<>(b, 'b'));
        if (c > 0) pq.offer(new Pair<>(c, 'c'));

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            Pair<Integer, Character> max = pq.poll();
            Character maxC = max.getValue();
            int len = sb.length();

            if (len >= 2 && sb.charAt(len - 1) == maxC && sb.charAt(len - 2) == maxC) {
                if (pq.isEmpty()) {
                    break;
                }
                Pair<Integer, Character> secondMax = pq.poll();
                sb.append(secondMax.getValue());
                if (secondMax.getKey() > 1) {
                    pq.offer(new Pair<>(secondMax.getKey() - 1, secondMax.getValue()));
                }
                pq.offer(max);
            } else {
                sb.append(max.getValue());
                if (max.getKey() > 1) {
                    pq.offer(new Pair<>(max.getKey() - 1, max.getValue()));
                }
            }
        }

        return sb.toString();
        
    }


}