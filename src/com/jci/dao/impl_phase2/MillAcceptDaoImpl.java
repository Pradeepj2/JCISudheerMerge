package com.jci.dao.impl_phase2;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.millAcceptDao;
import com.jci.model.EntryofpcsoModel;
import com.jci.model.JciEntryTdsModel;
import com.jci.model.JcicontractModel;
@Transactional
@Repository
public class MillAcceptDaoImpl implements millAcceptDao{
	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<JcicontractModel> getAll() {
	    List<JcicontractModel> ll = new ArrayList<>();
	    List<Object[]> rows = new ArrayList<>();
	    String querystr = "select Contract_no, Contract_date, Contract_qty, Contract_value, Payment_duedate, Contract_acceptance_flag, contract_id from jcicontract";
	    
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    SQLQuery query = session.createSQLQuery(querystr);
	    
	    rows = query.list();
	    
	    for (Object[] row : rows) {
	        String Contract_no = (String) row[0];
	        String Contract_date = (String) row[1];
	        String Contract_qty = (String) row[2];
	        Double Contract_value =(Double) row[3]; // Use BigDecimal for Contract_value
	        String Payment_duedate = (String) row[4];
	        int Contract_acceptance_flag = ((Number) row[5]).intValue();
	        Long contract_id = ((BigDecimal) row[6]).longValue(); // Use BigDecimal's longValue()

	        JcicontractModel cm = new JcicontractModel();
	        cm.setContract_no(Contract_no);
	        cm.setContract_date(Contract_date);
	        cm.setContract_qty(Contract_qty);
	        cm.setContract_value(Contract_value);
	        cm.setPayment_duedate(Payment_duedate);
	        cm.setContract_acceptance_flag(Contract_acceptance_flag);
	        cm.setContract_id(contract_id);

	        ll.add(cm);
	        System.out.println(ll.toString() + "kkkkkkkkkkkkkkkk");
	    }

	    return ll;
	}

//	public List<JcicontractModel> getAll() {
//
//		List<JcicontractModel> ll = new ArrayList<>();
//		List<Object[]> rows = new ArrayList<>();
//		String querystr = "select Contract_no  ,Contract_date ,Contract_qty , Contract_value, Payment_duedate , Contract_acceptance_flag , contract_id from jcicontract";
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		SQLQuery query = session.createSQLQuery(querystr);
//		
//		
//		rows = query.list();
//		for(Object[] row: rows) {
//		String	Contract_no =  (String) row[0];
//		String Contract_date = (String)row[1];
//		String Contract_qty = (String)row[2];
//		Double Contract_value  = (Double)row[3];
//		String Payment_duedate =(String)row[4];
//		int Contract_acceptance_flag = (int)row[5];
//		Long contract_id = (Long)row[6];
//		
//
//	
//		JcicontractModel cm = new JcicontractModel();
//		cm.setContract_no(Contract_no);
//		cm.setContract_date(Contract_date);
//	    cm.setContract_qty(Contract_qty);
//		cm.setContract_value(Contract_value);
//		cm.setPayment_duedate(Payment_duedate);
//		cm.setContract_acceptance_flag(Contract_acceptance_flag);
//		cm.setContract_id(contract_id);
//		
//		ll.add(cm);
//		System.out.println(ll.toString() + "kkkkkkkkkkkkkkkk");
//		}
//		return ll;
//	
//		
//	}
	@Override
	public void create(JcicontractModel millAccept) {
		currentSession().save(millAccept);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updatemillacceptflag(String tno) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date currentDate = new Date();
		String formattedDate = sdf.format(currentDate);
		
		
		//Contract_acceptance_date
		int contractacceptflag =1;	
		try {
		//String hql = "update jcicontract set Contract_acceptance_flag = '" + contractacceptflag + "'  where contract_id=" + tno;
		//String hql = "update jcicontract set Contract_acceptance_flag = '" + contractacceptflag + "' AND Contract_acceptance_date = '"formattedDate + "" where contract_id=" + tno;
		String hql = "update jcicontract set Contract_acceptance_flag = '" + contractacceptflag + "', Contract_acceptance_date = '" + formattedDate + "' where contract_id = " + tno;

				this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		      System.out.println("success");
		} catch (Exception e) {
			  System.out.println(e.getLocalizedMessage());
		}
		// TODO Auto-generated method stub
		
	}
		
	 
		
			

}
