package com.jci.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.dao.CommercialJuteVarietyGradesPriceDao;
import com.jci.model.CommercialJuteVarietyModel;
import com.jci.service.CommercialJuteVarietyGradesPriceService;

@Service
public class CommercialJuteVarietyGradesPriceServiceImpl implements CommercialJuteVarietyGradesPriceService {

	@Autowired
	CommercialJuteVarietyGradesPriceDao commercialJuteVarietyGradesPriceDao;

	@Override
	public void create(CommercialJuteVarietyModel commercialJuteVarietyModel) {
		commercialJuteVarietyGradesPriceDao.create(commercialJuteVarietyModel);
	}

	@Override
	public List<CommercialJuteVarietyModel> getAll() {
		return commercialJuteVarietyGradesPriceDao.getAll();
	}

	@Override
	public void delete(int id) {
		commercialJuteVarietyGradesPriceDao.delete(id);
	}

}
