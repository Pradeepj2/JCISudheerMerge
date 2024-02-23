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
	public void updatemillacceptflag(String tno ,String filename) {
		
		millacceptpdao.updatemillacceptflag(tno , filename);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void create(JcicontractModel millAccept1) {
		millacceptpdao.create(millAccept1);
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updatemillflag(String contract_no) {
		// TODO Auto-generated method stub
		millacceptpdao.updatemillflag(contract_no);
	}

}
