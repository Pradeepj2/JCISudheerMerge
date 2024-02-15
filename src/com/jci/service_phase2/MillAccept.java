package com.jci.service_phase2;

import java.util.List;

import com.jci.model.JcicontractModel;
import com.jci.model.MillAcceptanceModel;



public interface MillAccept {
	public void create(JcicontractModel millAccept);
	public List<JcicontractModel> getAll();
	public void updatemillacceptflag(String tno);
	
	
	
	

}
