package com.jci.dao.impl_phase2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jci.dao_phase2.MillAcceptanceDao;
import com.jci.model.JciDIHoModel;
import com.jci.model.JcicontractModel;

@Transactional
@Repository
public class MillAccptanceDaoImpl implements MillAcceptanceDao{

	@Autowired
	private HttpServletRequest request;

	@Autowired
	SessionFactory sessionFactory;
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(JcicontractModel jcicontractModel) {
		// TODO Auto-generated method stub
		currentSession().saveOrUpdate(jcicontractModel);
		
	}

	@Override
	public List<JcicontractModel> getAll() {
		// TODO Auto-generated method stub
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(JcicontractModel.class);
		List<JcicontractModel> ll=c.list();
		return ll;
	}

}
