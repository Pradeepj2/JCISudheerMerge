package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.JcicontractModel;

public interface millAcceptDao {
	public void create(JcicontractModel millAccept);
	public List<JcicontractModel> getAll();
	public void updatemillacceptflag(String tno);
	
	

}