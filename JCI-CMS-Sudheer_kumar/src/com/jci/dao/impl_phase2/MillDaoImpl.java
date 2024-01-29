package com.jci.dao.impl_phase2;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.MillAcceptanceDao;
import com.jci.dao_phase2.MillDao;
import com.jci.model.JcicontractModel;
import com.jci.model.MillAcceptanceModel;

@Transactional
@Repository
public class MillDaoImpl  implements MillDao{

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(MillAcceptanceModel millAcceptanceModel) {
		// TODO Auto-generated method stub
		currentSession().save(millAcceptanceModel);
		
	}

	@Override
	public List<MillAcceptanceModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(MillAcceptanceModel.class);
		List<MillAcceptanceModel> ll=c.list();
		return ll;
	}
	@Override
	public List<String> ContractNo() {
		// TODO Auto-generated method stub
		String q="SELECT DISTINCT  Contract_no FROM jcicontract"; 
		  List cno= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
	
		  return cno;
	}

//	@Override
//	public String ContractDate(String contractno) {
//		// TODO Auto-generated method stub
//		String q="SELECT Contract_date FROM jcicontract where Contract_no = '"+contractno+"'"; 
//		  
//		   String r= (String) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
//		     return r;
//	}

	@Override
	public List<Object> FetchContractData(String contractno) {
		// TODO Auto-generated method stub
		String q="SELECT Contract_date,Contract_qty,Contract_value,Payment_duedate FROM jcicontract where Contract_no = '"+contractno+"'";
		List<Object> ContractListData= (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  System.out.println(ContractListData);
	
		  return ContractListData;
	}

	@Override
	public List<Object> fetchContractDate_FcRef_ContractQty_AllowedQty(String contractno) {
		// TODO Auto-generated method stub
		String q="SELECT Created_date,FC_Ref_No,Contracted_Qty,QtyAllowed FROM jcifinancial_concurrence where Contractno = '"+contractno+"'";
		List<Object> FcTableData= (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  System.out.println(FcTableData);
	
		  return FcTableData;
	}

	@Override
	public Object LastDateShipment(String contractno) {
		// TODO Auto-generated method stub
		String q="SELECT Last_shipment_date FROM jcipayment_arrangement where Contract_No = '"+contractno+"'"; 
		  
		   Object result= (Object) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
		  return result;
		
	}

	
	
}
