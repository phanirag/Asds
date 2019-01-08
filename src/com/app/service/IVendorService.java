package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {

	public int saveVendor(Vendor vendor);
	public void updateVendor(Vendor vendor);
	public void deleteVendor(int id);
	public Vendor getVendorById(int id);
	public List<Vendor> getAllVendor();

}
