package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.JcicontractModel;

public interface millAcceptDao {
	public List<JcicontractModel> getAll();
	public void updatemillacceptflag(String contractId ,String filename, Double Contract_value_lc);
	
	

}
