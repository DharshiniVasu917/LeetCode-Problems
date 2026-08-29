import java.util.*;

class Twitter {

    static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    static class Node {
        int userId;
        int index;
        Tweet tweet;

        Node(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;
    private int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
            new Tweet(tweetId, time++)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> b.tweet.time - a.tweet.time
        );

        // Include the user's own tweets
        addLatestTweet(userId, pq);

        // Include tweets of followed users
        if (following.containsKey(userId)) {

            for (int followee : following.get(userId)) {
                addLatestTweet(followee, pq);
            }
        }

        // Get maximum 10 recent tweets
        while (!pq.isEmpty() && result.size() < 10) {

            Node current = pq.poll();

            result.add(current.tweet.tweetId);

            int nextIndex = current.index - 1;

            if (nextIndex >= 0) {

                Tweet nextTweet =
                    tweets.get(current.userId).get(nextIndex);

                pq.offer(
                    new Node(
                        current.userId,
                        nextIndex,
                        nextTweet
                    )
                );
            }
        }

        return result;
    }

    private void addLatestTweet(
        int userId,
        PriorityQueue<Node> pq
    ) {

        if (!tweets.containsKey(userId)) {
            return;
        }

        List<Tweet> list = tweets.get(userId);

        if (!list.isEmpty()) {

            int lastIndex = list.size() - 1;

            pq.offer(
                new Node(
                    userId,
                    lastIndex,
                    list.get(lastIndex)
                )
            );
        }
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following
            .computeIfAbsent(
                followerId,
                k -> new HashSet<>()
            )
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
