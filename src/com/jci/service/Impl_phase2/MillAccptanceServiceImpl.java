package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.MillAcceptanceDao;
import com.jci.model.JcicontractModel;
import com.jci.service_phase2.MillAccptanceService;

@Service
public class MillAccptanceServiceImpl implements MillAccptanceService{

	@Autowired
	MillAcceptanceDao  millAcceptanceDao;
	
	@Override
	public void create(JcicontractModel jcicontractModel) {
		// TODO Auto-generated method stub
		millAcceptanceDao.create(jcicontractModel);
		
		
	}

	@Override
	public List<JcicontractModel> getAll() {
		// TODO Auto-generated method stub
		return  millAcceptanceDao.getAll();
	}
	

}
