class MedianFinder {

    PriorityQueue<Integer> smallQueue;
    PriorityQueue<Integer> largeQueue;

    public MedianFinder() {
        largeQueue = new PriorityQueue<>();
        smallQueue = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        smallQueue.offer(num);

        if (!largeQueue.isEmpty() && smallQueue.peek() > largeQueue.peek()) {
            Integer tmp = smallQueue.poll();
            largeQueue.offer(tmp);
        }

        if (smallQueue.size() > largeQueue.size()) {
            Integer tmp = smallQueue.poll();
            largeQueue.offer(tmp);
        }

        if (largeQueue.size() - smallQueue.size() > 1) {
            Integer tmp = largeQueue.poll();
            smallQueue.offer(tmp);
        }
    }
    
    public double findMedian() {
        if (largeQueue.size() > smallQueue.size()) {
            return (double) largeQueue.peek();
        } else {
            return (double) (largeQueue.peek() + smallQueue.peek()) / 2;
        }
    }
}
