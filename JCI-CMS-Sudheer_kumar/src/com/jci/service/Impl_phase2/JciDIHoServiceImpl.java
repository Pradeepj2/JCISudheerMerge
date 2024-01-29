package com.jci.service.Impl_phase2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao_phase2.JciDIHoDao;
import com.jci.model.JciDIHoModel;
import com.jci.service_phase2.JciDIHoService;

@Service
public class JciDIHoServiceImpl implements JciDIHoService {

	@Autowired
	JciDIHoDao jciDIHoDao;

	@Override
	public void create(JciDIHoModel j) {
		jciDIHoDao.create(j);

	}

	@Override
	public void update(JciDIHoModel j) {
		jciDIHoDao.update(j);

	}

	@Override
	public JciDIHoModel edit(int id) {
		return jciDIHoDao.edit(id);
	}

	@Override
	public void delete(int id) {
		jciDIHoDao.delete(id);

	}

	/*
	 * @Override public JciDIHoModel find(int id) { return jciDIHoDao.find(id); }
	 */

	@Override
	public List<JciDIHoModel> getAll() {
		return jciDIHoDao.getAll();
	}

	@Override
	public boolean submitform(JciDIHoModel off) {
		return jciDIHoDao.submitform(off);
	}

	@Override
	public int Countrow() {
		//  
		return jciDIHoDao.Countrow();
		
	}
	
	  @Override public int CountFinancial() { // TODO Auto-generated method stub
	  return jciDIHoDao.CountFinancial(); }

	@Override
	public List<String> totalFCRef() {
		// TODO Auto-generated method stub
		return jciDIHoDao.totalFCRef();
	}
	public List<String> ContractNo()
	{
		return jciDIHoDao.ContractNo();
	}

	@Override
	public List<String> AllowedQty() {
		// TODO Auto-generated method stub
		return jciDIHoDao.AllowedQty();
	}
	public List<String> RegionalOffice()
	{
		return jciDIHoDao.RegionalOffice();
	}
	
	@Override
	public List<Object> MultiRegionoffice()
	{
		return jciDIHoDao.MultiRegionoffice();
	}
	public List<String> DPC()
	{
		return jciDIHoDao.DPC();
	}
	public List<String> findroname(String rocode)
	{
		return jciDIHoDao.findroname(rocode);
	}

	@Override
	public List<String> FetchContract_qty() {
		// TODO Auto-generated method stub
		return jciDIHoDao.FetchContract_qty();
	}
	
	 

}
