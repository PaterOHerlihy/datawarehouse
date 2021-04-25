package de.pater.datawarehouse.data;

import java.util.List;


public class TweetService {

	private static TweetDao tweetDao;
	 
    public TweetService() {
        tweetDao = new TweetDao();
    }
 
    public void persist(Tweet entity) {
        tweetDao.openCurrentSessionwithTransaction();
        tweetDao.persist(entity);
        tweetDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Tweet entity) {
        tweetDao.openCurrentSessionwithTransaction();
        tweetDao.update(entity);
        tweetDao.closeCurrentSessionwithTransaction();
    }
 
    public Tweet findById(long l) {
        tweetDao.openCurrentSession();
        Tweet tweet = tweetDao.findById(l);
        tweetDao.closeCurrentSession();
        return tweet;
    }
 
    public void delete(long id) {
        tweetDao.openCurrentSessionwithTransaction();
        Tweet tweet = tweetDao.findById(id);
        tweetDao.delete(tweet);
        tweetDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Tweet> findAll() {
        tweetDao.openCurrentSession();
        List<Tweet> tweets = tweetDao.findAll();
        tweetDao.closeCurrentSession();
        return tweets;
    }
 
    public void deleteAll() {
        tweetDao.openCurrentSessionwithTransaction();
        tweetDao.deleteAll();
        tweetDao.closeCurrentSessionwithTransaction();
    }
 
    public TweetDao tweetDao() {
        return tweetDao;
    }
}