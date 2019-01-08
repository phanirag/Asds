package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Vendor;
import com.app.service.IVendorService;

@Controller
public class VendorController {

	@Autowired
	private IVendorService service;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String show(){
		return "VendorReg";
	}
	
	@RequestMapping(value="/insertVendor",method=RequestMethod.POST)
	public String insertVendor(@ModelAttribute Vendor vendor,ModelMap model){
		int id = service.saveVendor(vendor);
		model.addAttribute("msg","Record with Id : " + id);
		return "VendorReg";
	}
}
