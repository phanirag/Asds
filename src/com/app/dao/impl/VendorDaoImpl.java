package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {

	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveVendor(Vendor vendor) {
		return (int) ht.save(vendor);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		ht.update(vendor);
	}

	@Override
	public void deleteVendor(int id) {
		ht.delete(new Vendor(id));
	}

	@Override
	public Vendor getVendorById(int id) {
		return ht.get(Vendor.class, id);
	}

	@Override
	public List<Vendor> getAllVendor() {
		return ht.loadAll(Vendor.class);
	}

}
