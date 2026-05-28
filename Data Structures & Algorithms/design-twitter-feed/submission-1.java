class Twitter {

    private int time;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;


    public Twitter() {
        time = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, t -> new ArrayList<>()).add(new int[]{time++, tweetId});
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> candidates = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        followMap.computeIfAbsent(userId, f -> new HashSet<>()).add(userId);
        for (int candidate : followMap.get(userId)) {
            int[] latestTweet = getLatestTweet(candidate);
            if (latestTweet[0] == -1) {
                continue;
            }

            candidates.offer(new int[]{latestTweet[0], latestTweet[1], candidate, latestTweet[2]});
            if (candidates.size() > 10) {
                candidates.poll();
            }
        }

        List<Integer> news = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        while (!candidates.isEmpty()) {
            queue.offer(candidates.poll());
        }

        while (!queue.isEmpty() && news.size() < 10) {
            int[] tweet = queue.poll();
            news.add(tweet[1]);

            int nextIndex = tweet[3] - 1;
            if (nextIndex >= 0) {
                int candidateId = tweet[2];
                int[] nextTweet = tweetMap.get(candidateId).get(nextIndex);
                queue.offer(new int[]{nextTweet[0], nextTweet[1], candidateId, nextIndex});
            }
        }

        return news;
    }

    private int[] getLatestTweet(int userId) {
        System.out.println("UserId: " + userId);
        if (tweetMap.containsKey(userId)) {
            List<int[]> tweets = tweetMap.get(userId);
            int size = tweets.size();
            int[] tweet = tweets.get(size - 1);
            return new int[]{tweet[0], tweet[1], size - 1};
        }

        return new int[]{-1, -1, -1};
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, f -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
