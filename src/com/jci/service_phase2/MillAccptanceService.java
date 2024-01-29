package com.jci.service_phase2;

import java.util.List;

import com.jci.model.JcicontractModel;

public interface MillAccptanceService {

	public void create(JcicontractModel jcicontractModel);
	public List <JcicontractModel> getAll();
	
}
