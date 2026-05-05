class Twitter {
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, Set> followerMap;
    int counter;
    public Twitter() {
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
        counter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<int[]>()).add(new int[]{counter++, tweetId});
    }   
    
    public List<Integer> getNewsFeed(int userId) {
        followerMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        Set<Integer> followerList = followerMap.get(userId);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for(Integer follower: followerList) {
          List<int[]> tweets = tweetMap.get(follower);
          if(tweets == null) continue;
          int index = tweets.size();
          int[] tweet = tweets.get(index - 1);
          maxHeap.offer(new int[]{tweet[0], tweet[1], follower, index - 1});
        }
        List<Integer> result = new ArrayList<Integer>();
        while(!maxHeap.isEmpty() && result.size() < 10) {
            int[] tweetItem = maxHeap.poll();
            result.add(tweetItem[1]);
            List<int[]> tweet = tweetMap.get(tweetItem[2]);
            int nextIndex = tweetItem[3] - 1;
            if(nextIndex >= 0) {
                int[] userTweet = tweet.get(nextIndex);
                System.out.println("index" + tweetItem[3]);
                maxHeap.offer(new int[]{userTweet[0], userTweet[1], tweetItem[2], nextIndex});
            }
        }
        return result;

    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k -> new LinkedHashSet<String>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followerList = followerMap.get(followerId);
        if(followerList == null) return;
        followerList.remove(followeeId);
    }
}
