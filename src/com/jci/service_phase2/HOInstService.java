package com.jci.service_phase2;

import java.util.List;

import org.apache.poi.poifs.storage.ListManagedBlock;

import com.jci.model.HODispatchInstructionModel;
import com.jci.model.JciDIHoModel;

public interface HOInstService {
   List<String> getContract();

List<String> getDetails(String contractNo);

List<Object[]> getRoname();

Object getCount(String reg);

void create(JciDIHoModel diHo);
public List <JciDIHoModel> getAll();
   
}
