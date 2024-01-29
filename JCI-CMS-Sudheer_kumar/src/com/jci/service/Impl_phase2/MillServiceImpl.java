package com.jci.service.Impl_phase2;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.MillDao;
import com.jci.model.MillAcceptanceModel;
import com.jci.service_phase2.MillService;

@Service
public class MillServiceImpl implements  MillService
{

	@Autowired
	MillDao millDao;
	
	@Override
	public void create(MillAcceptanceModel millAcceptanceModel) {
		// TODO Auto-generated method stub
		millDao.create(millAcceptanceModel);
		
	}

	@Override
	public List<MillAcceptanceModel> getAll() {
		// TODO Auto-generated method stub
		return millDao.getAll();
	}

	@Override
	public List<String> ContractNo() {
		// TODO Auto-generated method stub
		return millDao.ContractNo();
	}

//	@Override
//	public String ContractDate(String contractno) {
//		// TODO Auto-generated method stub
//		return millDao.ContractDate(contractno);
//	}

	@Override
	public List<Object> FetchContractData(String contractno) {
		// TODO Auto-generated method stub
		return millDao.FetchContractData(contractno);
	}

	@Override
	public List<Object> fetchContractDate_FcRef_ContractQty_AllowedQty(String contractno) {
		// TODO Auto-generated method stub
		return millDao.fetchContractDate_FcRef_ContractQty_AllowedQty(contractno);
	}

	@Override
	public Object LastDateShipment(String contractno) {
		// TODO Auto-generated method stub
		return millDao.LastDateShipment(contractno);
	}
	
}
