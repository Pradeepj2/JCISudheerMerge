package com.jci.dao.impl_phase2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.NominalOfficialDao;
import com.jci.model.JciDIHoModel;
import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.RoDetailsModel;
import com.jci.model.UserRegistrationModel;


@Transactional
@Repository
public class Jciclaim_NominationImpl implements NominalOfficialDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void create(Jciclaim_NominationModel nominal) {
			currentSession().save(nominal);
		
	}

	@Override
	public void update(Jciclaim_NominationModel nominal) {
		currentSession().update(nominal);
	}

	@Override
	public Jciclaim_NominationModel edit(int id) {
		return (Jciclaim_NominationModel) currentSession().get(Jciclaim_NominationModel.class, id);
	
	}

	@Override
	public void delete(int id) {
		String hql = "Delete from  dbo.jciclaim_nomination where Settlement_id = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
		
	}

	@Override
	public List<Jciclaim_NominationModel> getAll() {
		// TODO Auto-generated method stub
		
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Jciclaim_NominationModel.class);
		List<Jciclaim_NominationModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(Jciclaim_NominationModel nominal) {
		// TODO Auto-generated method stub
		String sql = "select * from jciclaim_nomination";
		List list = this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(nominal);
		return false;
	}


	@Override
	public List<String>  millid_MillReceipt() {
		// TODO Auto-generated method stub
		String q="SELECT DISTINCT  Mill_id FROM jcimill_receipt"; 
		  List millid= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
	
		  return millid;
	}


	@Override
	public List<Object> FetchMillReceiptData(String millid) {
		// TODO Auto-generated method stub
		String q="SELECT Challan_no,MR_no,Bale_mark,Crop_year,Quality_claim,MoistureContent,NCV_percentage FROM jcimill_receipt where Mill_id = '"+millid+"'";
		List<Object> ContractListData= (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  System.out.println(ContractListData);
	
		  return ContractListData;
	}


	@Override
	public List<String> contractno_ContractTable() {
		// TODO Auto-generated method stub
		String q="SELECT DISTINCT  Contract_no FROM jcicontract"; 
		  List contractNo= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
	
		  return contractNo;
	}





	@Override
	public List<String> UsernameOM_jciumt(String role) {
		// TODO Auto-generated method stub
		String q="SELECT username from where roles_name = '"+role+"'";
		List<String> OmUsername= (List<String>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  System.out.println(OmUsername);
	
		  return OmUsername;
	}
	@Override
	public List<String> UsernameFA_jciumt(String role) {
		// TODO Auto-generated method stub
		String q="SELECT username from where roles_name = '"+role+"'";
		List<String> FMUsername= (List<String>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  System.out.println(FMUsername);
	
		  return FMUsername;
	}


	@Override
	public List<UserRegistrationModel> getom_official() {
		// TODO Auto-generated method stub
		String rolename = "OM Role";
		String querystr = "select username from jciumt where roles_name = '"+rolename+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<UserRegistrationModel> rows = query.list();
		return rows;
	}


	@Override
	public List<UserRegistrationModel> getfa_official() {
		// TODO Auto-generated method stub
		String rolename = "FA Role";
		String querystr = "select username from jciumt where roles_name = '"+rolename+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		List<UserRegistrationModel> rows = query.list();
		return rows;
	}


	@Override
	public int CountRecord() {
		// TODO Auto-generated method stub
		
		String q="SELECT COUNT(*) FROM jciclaim_nomination"; 
		  int total= (Integer) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
	 if(total>0)
		  return total;
	 else return 0;
	
	}


	@Override
	public List<Object> gradecomposition(String contractno) {
		String q=" SELECT"
				+ "  Jcigrade_composition.Jute_combination,\r\n"
				+ "  (jcigrade_composition.Proposed_composition*jcicontract.Contract_qty)/100 as new_proposed_composition\r\n"
				+ "   FROM Jcigrade_composition  INNER JOIN  jcicontract on  jcicontract.Grade_composition=jcigrade_composition.Label_name\r\n"
				+ "  WHERE Contract_no='"+contractno+"'";
		     List<Object> gradecomposition= (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
			  return gradecomposition;
		
		
	}

	
	
}
