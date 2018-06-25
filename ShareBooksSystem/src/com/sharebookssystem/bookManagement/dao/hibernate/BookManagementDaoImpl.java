package com.sharebookssystem.bookManagement.dao.hibernate;

import com.sharebookssystem.bookManagement.dao.BookManagementDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

/**
 * Dao的实现类
 * 2018/6/5
 */

public class BookManagementDaoImpl implements BookManagementDao {

    private SessionFactory sessionFactory;

    public BookManagementDaoImpl(){

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //通过Id查询实例
    public Object queryById(Object object,int id){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Object newObject = (Object)session.get(object.getClass(),id);
            transaction.commit();
            return newObject;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //删除
    public boolean deleteByObject(Object object){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            session.delete(object);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    //通过hql删除
    public boolean deleteByHql(String className,String param1,int value1){
        Session session=null;
        try{
            session = sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            String hql = "Delete from "+className+" where "+param1+" = "+value1;
            Query query = session.createQuery(hql);
            query.executeUpdate();
            trans.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //通过Object添加或更新
    public boolean updateByObject(Object object){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(object);
            trans.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    //同时更新两个object
    public boolean updateByTwoObject(Object object1,Object object2){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(object1);
            session.saveOrUpdate(object2);
            trans.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    //查询全部
    public List queryByParam(String className){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className;
            Query query = session.createQuery(hql);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //一个参数查询
    public List<Object> queryByParam(String className,String param1,Object value1){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,value1);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //两个参数查询
    public List<Object> queryByParam(String className,String param1,Object value1,String param2,Object value2){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = ? and "+param2+" = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,value1);
            query.setParameter(1,value2);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //三个参数查询
    public List<Object> queryByParam(String className,String param1,Object value1,String param2,Object value2,String param3,Object value3){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            //String hql = "from "+className+" where "+param1+" = '"+value1+"' and "+param2+" = '"+value2+"' and "+param3+" = '"+value3+"'";
            String hql = "from "+className+" where "+param1+" = ? and "+param2+" = ? and "+param3+" = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,value1);
            query.setParameter(1,value2);
            query.setParameter(2,value3);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //四个参数查询
    public List<Object> queryByParam(String className,String param1,Object value1,String param2,Object value2,String param3,Object value3,String param4,Object value4){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = ? and "+param2+" = ? and "+param3+" = ? and "+param4+" = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,value1);
            query.setParameter(1,value2);
            query.setParameter(2,value3);
            query.setParameter(3,value4);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //五个参数查询
    public List<Object> queryByParam(String className,String param1,Object value1,String param2,Object value2,String param3,Object value3,String param4,Object value4,String param5,Object value5){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = ? and "+param2+" = ? and "+param3+" = ? and "+param4+" = ? and "+param5+" = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,value1);
            query.setParameter(1,value2);
            query.setParameter(2,value3);
            query.setParameter(3,value4);
            query.setParameter(4,value5);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

}
