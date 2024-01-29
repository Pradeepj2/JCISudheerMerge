package com.jci.dao_phase2;


import java.util.List;

import com.jci.model.JciDIHoModel;
import com.jci.model.JciEntryTdsModel;

public interface EntryofTdsDao {
	
	public void create(JciEntryTdsModel j);
	public List <JciEntryTdsModel> getAll();

}
