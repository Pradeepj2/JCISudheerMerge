package com.jci.dao_phase2;

import java.util.List;


import com.jci.model.JcicontractModel;
import com.jci.model.MillAcceptanceModel;

public interface MillAcceptanceDao {
	public void create(JcicontractModel jcicontractModel);
	public List <JcicontractModel> getAll();
	

}
