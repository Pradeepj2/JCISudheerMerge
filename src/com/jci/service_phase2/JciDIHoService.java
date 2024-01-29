package com.jci.service_phase2;

import java.util.List;

import com.jci.model.JciDIHoModel;

public interface JciDIHoService {

	
	public void create(JciDIHoModel area);
	public void update(JciDIHoModel area);
	public JciDIHoModel edit(int id);
	public void delete(int id);
	public int Countrow();

	public int CountFinancial();
	/* public List<JciDIHoModel> findAll(); */
	/* public JciDIHoModel find(int id); */
	public List <JciDIHoModel> getAll();
	public boolean submitform(JciDIHoModel off);
	
	public List<String>ContractNo();
	public List<String> totalFCRef();
	public List<String> AllowedQty();
	public List<String> RegionalOffice();
	public List<Object> MultiRegionoffice();
	public List<String> DPC();
	public List<String> findroname(String rocode);
	public List<String> FetchContract_qty();
}
