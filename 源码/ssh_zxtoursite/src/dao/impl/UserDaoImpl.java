package dao.impl;
import java.sql.SQLException;
import java.util.List;

import model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	

	public void deleteBean(User bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(User bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public User selectBean(String where) {
		List<User> list = this.getHibernateTemplate().find("from User "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from User  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<User> selectBeanList(final int start,final int limit,final String where) {
		return (List<User>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<User> list = session.createQuery(" from User"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(User bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<User> selectCount2(final User r) {
		return (List<User>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				String hql= "";
				
					 hql="select u.zhuanye,count(u.stauts),count(*)  from User u where u.role=1 group by u.zhuanye  " ; 
			
				List<User> list = session.createQuery(hql).list();
				return list;
			}
		});
	}
	
	
	
}
