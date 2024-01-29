package com.jci.service.Impl_phase2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.JciContractDao;
import com.jci.service_phase2.JciContractService;

@Service
public class JciContractServiceImpl implements JciContractService{

	@Autowired
	JciContractDao jciContractDao;
	
	@Override
	public void ContractFlagStausUpdate(String contractno) {
		// TODO Auto-generated method stub
		
		jciContractDao.ContractFlagStausUpdate(contractno);
	}

}
