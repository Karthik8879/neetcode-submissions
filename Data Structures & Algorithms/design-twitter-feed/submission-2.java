class Twitter {

    class Tweet{
        int timeStamp;
        int tweetId;
        Tweet(int timeStamp, int tweetId) {
            this.timeStamp = timeStamp;
            this.tweetId = tweetId;
        }
    }

    HashMap<Integer, List<Tweet>> tweets = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> following = new HashMap<>();
    int timeStamp = 0;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        int timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new Tweet(timeStamp++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> res = new ArrayList<>(); // what we are going to return
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a,b) -> b.timeStamp - a.timeStamp
        );
        addTweetsHelper(userId, maxHeap); // get all tweets wrt userId - current
        // now we are going to show the tweets wrt the users followers
        HashSet<Integer> followersList = following.getOrDefault(userId, new HashSet<>());
        // now traverse through the followersList and add tweets wrt them
        for(int ids : followersList) {
            addTweetsHelper(ids, maxHeap);
        }

        // we have to show the top 10 tweets only in the users feed
        while(!maxHeap.isEmpty() && res.size() < 10) {
            Tweet tweet = maxHeap.poll();
            int tweetId = tweet.tweetId;
            res.add(tweetId);
        }

        return res;
    }

    void addTweetsHelper(int userId, PriorityQueue<Tweet> maxHeap) {
        List<Tweet> userTweets = tweets.get(userId);
        if (userTweets == null) {
            return;
        }
        for(Tweet tweet : userTweets) {
            maxHeap.offer(tweet);
        }
    }
    
    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId); 
        } else {
            return;
        }
    }
}
