package com.vikas.core.leetcode.heap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Twitter {

    public static void main(String[] args){
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 3); // User 1 posts a new tweet (id = 5).

        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }

    Map<Integer, List<TweetDetails>> tweetMap ;
    Map<Integer, List<Integer>> followerMap;


    public Twitter() {
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        //tweetMap.getOrDefault(userId, new ArrayList<>()).add(new TweetDetails(tweetId, System.currentTimeMillis()));
        if(tweetMap.containsKey(userId)){
            List<TweetDetails> list = tweetMap.get(userId);
            list.add(new TweetDetails(tweetId, System.nanoTime()));
            tweetMap.put(userId, list);
        }else{
            List<TweetDetails> list = new ArrayList<>();
            list.add(new TweetDetails(tweetId, System.nanoTime()));
            tweetMap.put(userId, list);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<TweetDetails> userTweets = Optional.ofNullable(tweetMap.get(userId)).orElse(Collections.emptyList());
        List<TweetDetails> followerTweets = followerMap.getOrDefault(userId, Collections.emptyList()).stream().map(id ->tweetMap.get(id)).filter(Objects::nonNull).filter(list->!list.isEmpty()).flatMap(list ->list.stream())
                .collect(Collectors.toList());

        List<TweetDetails> combinedList = Stream.of(userTweets, followerTweets).flatMap(Collection::stream).distinct().limit(10).collect(Collectors.toList());
        combinedList.sort(Comparator.comparingLong(TweetDetails::getTimestamp).reversed());
        return combinedList.stream().map(tweetDetails -> tweetDetails.getTweetId()).collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId)){
            List<Integer> list = followerMap.get(followerId);
            list.add(followeeId);
            followerMap.put(followerId, list);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(followeeId);
            followerMap.put(followerId, list);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> list = (followerMap.get(followerId));
        if(!Objects.isNull(list)){
            list.remove(Integer.valueOf(followeeId));
        }
        //followerMap.put(followerId, list);
    }
}

class TweetDetails{
    Integer tweetId;
    long timestamp;

    public TweetDetails(Integer tweetId, long timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public void setTweetId(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TweetDetails that = (TweetDetails) o;
        return timestamp == that.timestamp && Objects.equals(tweetId, that.tweetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tweetId, timestamp);
    }
}
