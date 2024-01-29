package com.jci.dao_phase2;

import java.util.List;


import com.jci.model.JciDIHoModel;

public interface JciDIHoDao {

	public void create(JciDIHoModel j);
	public void update(JciDIHoModel j);
	public JciDIHoModel edit(int id);
	public void delete(int id);
	public int Countrow();
	
	/* public int CountFinancial(); */

	/* public List<JciDIHoModel> findAll(); */
	/* public JciDIHoModel find(int id); */
	
	
	public List <JciDIHoModel> getAll();
	public boolean submitform(JciDIHoModel off);
	public int CountFinancial();

	/* Added on 18/09/2023 */
	
	public List<String> totalFCRef();

	// Added on 19/08/2023
	public List<String> ContractNo();

	public List<String> AllowedQty();
	public List<String> RegionalOffice();

	public List<Object> MultiRegionoffice();

	public List<String> DPC();

	// For AJAx Call
	public List<String> findroname(String rocode);

	public List<String> FetchContract_qty();
	
 
	
}