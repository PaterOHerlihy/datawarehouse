package de.pater.datawarehouse.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import de.pater.datawarehouse.app.SessionFactoryHelper;

public class TweetDao {

private Session currentSession;
    
    private Transaction currentTransaction;
 
    public TweetDao() {
    }
 
    public Session openCurrentSession() {
        currentSession = SessionFactoryHelper.getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = SessionFactoryHelper.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
    public void persist(Tweet entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Tweet entity) {
        getCurrentSession().update(entity);
    }
 
    public Tweet findById(long l) {
        Tweet tweet = (Tweet) getCurrentSession().get(Tweet.class, l);
        return tweet; 
    }
 
    public void delete(Tweet entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Tweet> findAll() {
        List<Tweet> tweets = (List<Tweet>) getCurrentSession().createQuery("from Tweet").list();
        return tweets;
    }
 
    public void deleteAll() {
        List<Tweet> entityList = findAll();
        for (Tweet entity : entityList) {
            delete(entity);
        }}
	
}