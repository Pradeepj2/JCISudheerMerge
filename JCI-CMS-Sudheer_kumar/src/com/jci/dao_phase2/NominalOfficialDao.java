package com.jci.dao_phase2;

import java.util.List;

import com.jci.model.Jciclaim_NominationModel;
import com.jci.model.UserRegistrationModel;

public interface NominalOfficialDao {


	public void create(Jciclaim_NominationModel nominal);
	public void update(Jciclaim_NominationModel nominal);
	public Jciclaim_NominationModel edit(int id);
	public void delete(int id);

	public List <Jciclaim_NominationModel> getAll();
	public boolean submitform(Jciclaim_NominationModel off);

// Auto Fetching Data From Different Table.
	public List<String> millid_MillReceipt();
	public List<Object> FetchMillReceiptData(String millid);
	public List<String> contractno_ContractTable();
	
	// Auto Fetching Role From jciuserrole.
	
	public List<String> UsernameOM_jciumt(String role);	
	public List<String> UsernameFA_jciumt(String role);
	public List<UserRegistrationModel> getom_official();
	public List<UserRegistrationModel> getfa_official();	

}
