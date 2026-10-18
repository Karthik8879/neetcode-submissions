class Twitter {
    int timeStamp = 0;
    HashMap<Integer, Set<Integer>> following = new HashMap<>();
    HashMap<Integer, List<Tweet>> tweets = new HashMap<>(); // List<int[]> where we are storing [timeStamp, tweetId] -> Now we have changed it to Tweet class which is having these 2 things stored

    class Tweet {
        int timeStamp;
        int tweetId;
        Tweet(int timeStamp, int tweetId) {
            this.timeStamp = timeStamp;
            this.tweetId = tweetId;
        }
    }

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new Tweet(timeStamp++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>(); // what we are going to return
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a,b) -> b.timeStamp - a.timeStamp
        );
        addTweetsHelper(userId, maxHeap); // userId sees their own tweets list
        // Add all followers tweets to the feed
        Set<Integer> users = following.getOrDefault(userId, new HashSet<>()); // incase no tweets by any followee

        // do addTweetsHelper for all of his followers
        for(int followeeId : users) {
            addTweetsHelper(followeeId, maxHeap);
        }

        // get at most 10 most recent tweets
        while(!maxHeap.isEmpty() && res.size() < 10) {
            Tweet tweet = maxHeap.poll();
            int tweetId = tweet.tweetId;
            res.add(tweetId);
        }

        return res;
    }

    public void addTweetsHelper(int userId, PriorityQueue<Tweet> maxHeap) {
        List<Tweet> userTweets = tweets.get(userId);
        if(userTweets == null) return;
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
        }
    }
}
