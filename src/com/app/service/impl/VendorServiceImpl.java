package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	private IVendorDao dao;
	
	@Override
	public int saveVendor(Vendor vendor) {
		return dao.saveVendor(vendor);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		dao.updateVendor(vendor);
	}

	@Override
	public void deleteVendor(int id) {
		dao.deleteVendor(id);
	}

	@Override
	public Vendor getVendorById(int id) {
		return dao.getVendorById(id);
	}

	@Override
	public List<Vendor> getAllVendor() {
		return dao.getAllVendor();
	}

}
