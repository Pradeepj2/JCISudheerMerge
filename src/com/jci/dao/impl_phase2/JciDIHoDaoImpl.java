package com.jci.dao.impl_phase2;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.jci.dao_phase2.JciDIHoDao;
import com.jci.model.AreaDetailCode;
import com.jci.model.JciDIHoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class JciDIHoDaoImpl implements JciDIHoDao {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	/*
	 * public static void main(String[] args) { JciDIHoDaoImpl fr = new
	 * JciDIHoDaoImpl (); fr.findRegno("05","0212"); }
	 */
	
	
	@Override
	public void create(JciDIHoModel j) {
		currentSession().saveOrUpdate(j);
	}

	@Override
	public void update(JciDIHoModel j) {
		currentSession().update(j);
	}

	@Override
	public JciDIHoModel edit(int id) {
		return (JciDIHoModel) currentSession().get(JciDIHoModel.class, id);
	}

	/*
	 * private JciDIHoModel find(int id) { // TODO Auto-generated method stub return
	 * null; }
	 */

	@Override
	public void delete(int id) {
		/* JciDIHoModel j = new JciDIHoModel(); */
		String hql = "Delete from dbo.jciDI_ho where DI_HO_ID = '"+id+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}

	/*
	 * @Override public JciDIHoModel find(int id) { return (JciDIHoModel)
	 * currentSession().get(JciDIHoModel.class, id); }
	 */

	@Override
	public List<JciDIHoModel> getAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JciDIHoModel.class);
		
		c.addOrder(Order.desc("DI_HO_ID"));
		List<JciDIHoModel> ll=c.list();
		return ll;
	}

	@Override
	public boolean submitform(JciDIHoModel j) {
		
		String sql = "select * from jcirodetails";
		List list = this.sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(j);
		return false;
	}
	/*
	 * @Override public List<JciDIHoModel> getAll() { // TODO Auto-generated method
	 * stub return null; }
	 */

	@Override
	public int Countrow() {
		 String q="SELECT COUNT(*) FROM jciDI_ho";
		int r= (int) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
		 
		return r;
	}

	
	  @Override 
	  public int CountFinancial() 
	  {  //TODO Auto-generated method stub
	  String q="SELECT COUNT(*) FROM jcifinancial_concurrence"; 
	  
	  int r= (int) this.sessionFactory.getCurrentSession().createSQLQuery(q).uniqueResult();
	  return r;
	  }
	  public List<String> totalFCRef()
	  {
		  String q="SELECT FC_Ref_No FROM jcifinancial_concurrence"; 
		  List r= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  return r;
	  }

	@Override
	public List<String> ContractNo() {
		// TODO Auto-generated method stub
		String q="SELECT Contractno FROM jcifinancial_concurrence"; 
		  List cno= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
	
		  return cno;
	}

	@Override
	public List<String> AllowedQty() {
		// TODO Auto-generated method stub
		String q="SELECT QtyAllowed FROM jcifinancial_concurrence"; 
		  List allowqty= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
	
		  return allowqty;
		
	}

	
	@Override
	public List<String> RegionalOffice() {
		// TODO Auto-generated method stub
		String q="SELECT roname FROM jcirodetails"; 
		  List roname= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  System.out.println(roname);
	
		  return roname;
	}
	
	  //yah Single column ka data fetch kr raha h.
	

	@Override
	public List<Object> MultiRegionoffice()
	{
		String q="SELECT rocode,roname FROM jcirodetails"; 
		List<Object> multiro= (List<Object>) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  System.out.println(multiro);
	
		  return multiro;
		
	}
	@Override
	public List<String> DPC()
	{
		String q="SELECT centername from jcipurchasecenter INNER JOIN  jcirodetails ON jcipurchasecenter.rocode=jcirodetails.rocode";
	
		 List dpc= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
			
		  return dpc;
	}
	
	// For Ajax
	@Override
	public List<String> findroname(String rocode) {
		List<String> result = new ArrayList<>();
		String querystr = "SELECT distinct(centername) FROM jcipurchasecenter where rocode ='"+rocode+"'";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery(querystr);
		result = query.list();

		return result;
	}

	
	@Override
	public List<String> FetchContract_qty()
	{

		String q="SELECT Contract_qty FROM jcicontract"; 
		  List result= (List) this.sessionFactory.getCurrentSession().createSQLQuery(q).list();
		  System.out.println(result);
	
		  return result;
	}	 

	

}
