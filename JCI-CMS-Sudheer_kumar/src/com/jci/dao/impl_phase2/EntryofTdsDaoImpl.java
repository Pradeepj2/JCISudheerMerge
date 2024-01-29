//package com.jci.dao.impl_phase2;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.jci.dao_phase2.EntryofTdsDao;
//import com.jci.model.JciEntryTdsModel;
//
//public class EntryofTdsDaoImpl implements EntryofTdsDao{
//	
//
//	@Autowired
//	private HttpServletRequest request;
//
//	@Autowired
//	SessionFactory sessionFactory;
//	protected Session currentSession(){
//		return sessionFactory.getCurrentSession();
//	}
//
//	@Override
//	public void create(JciEntryTdsModel j) {
//		// TODO Auto-generated method stub
//		currentSession().save(j);
//		
//	}
//
//	@Override
//	public List<JciEntryTdsModel> getAll() {
//		// TODO Auto-generated method stub
//		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JciEntryTdsModel.class);
//		List<JciEntryTdsModel> ll=c.list();
//		return ll;
//	}
//
//}
