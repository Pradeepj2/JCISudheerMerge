package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.millAcceptDao;
import com.jci.model.JcicontractModel;
import com.jci.service_phase2.MillAccept;
@Service
public class MillAcceptServiceImpl implements MillAccept{
	
	@Autowired 
	millAcceptDao millacceptpdao;
	
	@Override
	public List<JcicontractModel> getAll() {
		// TODO Auto-generated method stub
		return millacceptpdao.getAll();
	}
	
	
	@Override
	public void updatemillacceptflag(String contractId ,String filename) {
		
		millacceptpdao.updatemillacceptflag(contractId , filename);
		// TODO Auto-generated method stub
		
	}
	




}
