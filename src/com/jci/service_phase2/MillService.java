package com.jci.service_phase2;

import java.util.Date;
import java.util.List;

import com.jci.model.JcicontractModel;
import com.jci.model.MillAcceptanceModel;

public interface MillService {
	public void create(MillAcceptanceModel millAcceptanceModel);
	public List <MillAcceptanceModel> getAll();
	
	
	public List<String> ContractNo();
	//public String ContractDate(String contractno);
	public List<Object> FetchContractData(String contractno);
	public List<Object> fetchContractDate_FcRef_ContractQty_AllowedQty(String contractno);
	public Object LastDateShipment(String contractno) ;
	public String LastDateShipment1(String contractno);  // for Immediate Date
}
