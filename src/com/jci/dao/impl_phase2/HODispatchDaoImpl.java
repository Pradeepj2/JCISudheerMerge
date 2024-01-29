package com.jci.dao.impl_phase2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao.HoDispatchdao;
import com.jci.dao_phase2.DispatchHODao;
import com.jci.model.HODispatchInstructionModel;
import com.jci.model.JciDIHoModel;
@Repository
@Transactional
public class HODispatchDaoImpl implements DispatchHODao{

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Autowired
	HttpServletRequest request;
	
	@Override
	public List<String> getContract() {
		
		String sqlString="Select Contractno from jcifinancial_concurrence";
		List<String> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
     
		return list;
	}

	@Override
	public List<String> getDetails(String contractNo) {
		List<String> result = new ArrayList<>();
	String sqlString="select * from jcicontract where Contract_no ='" + contractNo + "'" ;
	String sqlString2="select * from jcifinancial_concurrence where Contractno ='" + contractNo + "'";
	String sqString3 ="select Expiry_date from jcipayment_arrangement where Contract_No ='" + contractNo + "'";
	
	 List<String> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
	 List<String> list2 = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString2).list();
	 Date list3 =  (Date) this.sessionFactory.getCurrentSession().createSQLQuery(sqString3).uniqueResult();
	
	
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	 String strDate= formatter.format(list3); 
	
	 
	 Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(sqlString);
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			result.add(row[6].toString());
			result.add(row[23].toString());
			result.add(row[9].toString());//Contradate-Cropyear-contractqty
		}
		Session session2 = sessionFactory.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		SQLQuery query2 = session2.createSQLQuery(sqlString2);
		List<Object[]> rows2 = query2.list();
		for(Object[] row : rows2){
			result.add(row[5].toString());
			result.add(row[6].toString());//Contradate-Cropyear-contractqty
		}
		
		result.add(strDate);
		
		
		String userRole =(String) request.getSession().getAttribute("rolename");
		String userRoname =(String) request.getSession().getAttribute("zonename");
		
		
		
		return result;
	}

	@Override
	public List<Object[]> getRoname() {
		
		String sqlString="Select roname,rocode from jcirodetails";
		List<Object[]> list = this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).list();
		
      
		return list;
	}

	

	@Override
	public Object getCount(String reg) {
		// TODO Auto-generated method stub
		String sqlString="select Count(DI_HO_ID) from jciDI_ho where Regional_office ='" + reg + "'" ;
		Object list3 =  (Object) this.sessionFactory.getCurrentSession().createSQLQuery(sqlString).uniqueResult();
		
		return list3;
	}

	
	@Override
	public void save(JciDIHoModel hodispatch) {
		// TODO Auto-generated method stub
		currentSession().save(hodispatch);
		return;
	}

	@Override
	public List<JciDIHoModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JciDIHoModel.class);
		
		c.addOrder(Order.desc("DI_HO_ID"));
		List<JciDIHoModel> ll=c.list();
		return ll;
	}
	

	
		
		
	

}
