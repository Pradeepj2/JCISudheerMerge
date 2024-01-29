package com.jci.dao.impl_phase2;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.JciContractDao;


@Transactional
@Repository
public class JciContractDaoImpl implements JciContractDao{
	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void ContractFlagStausUpdate(String contractno) {
		// TODO Auto-generated method stub
		String hql = "update dbo.jcicontract set Contract_acceptance_flag='1',Contract_status='Mill Accepted' where Contract_no = '"+contractno+"' " ;
		this.sessionFactory.getCurrentSession().createSQLQuery(hql).executeUpdate();
	}


	
	

}
