package de.pater.datawarehouse.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import de.pater.datawarehouse.app.SessionFactoryHelper;


public class UserDao {

private Session currentSession;
    
    private Transaction currentTransaction;
 
    public UserDao() {
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
 
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(User entity) {
        getCurrentSession().update(entity);
    }
 
    public User findById(long l) {
        User user = (User) getCurrentSession().get(User.class, l);
        return user; 
    }
 
    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        List<User> users = (List<User>) getCurrentSession().createQuery("from User").list();
        return users;
    }
 
    public void deleteAll() {
        List<User> entityList = findAll();
        for (User entity : entityList) {
            delete(entity);
        }}
	
}