package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@RequestMapping(value="/viewAllVendor",method=RequestMethod.GET)
	public String viewAllVendor(ModelMap map){
		List<Vendor> list = service.getAllVendor();
		map.addAttribute("list",list);
		return "VendorList"; 
	}
	
	@RequestMapping(value="/deleteVendor",method=RequestMethod.GET)
	public String deleteVendor(@RequestParam("vId")int id,ModelMap map){
		service.deleteVendor(id);
		return "redirect:viewAllVendor";
	}
	
	@RequestMapping(value="/updateVendor",method=RequestMethod.GET)
	public String updateVendor(@RequestParam("vId")int id,ModelMap map){
		Vendor vendor = service.getVendorById(id);
		map.addAttribute("vendor",vendor);
		return "VendorUpdate";
	}
	
	@RequestMapping(value="/updatedVendor",method=RequestMethod.POST)
	public String updatedVendor(@ModelAttribute Vendor vendor,ModelMap map){
		service.updateVendor(vendor);
		return "redirect:viewAllVendor";
	}
	
	@RequestMapping(value="/get-excel")
	public void getExcel(HttpServletRequest request,HttpServletResponse response) throws IOException{

		List<Vendor> vendor = service.getAllVendor();
		
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("content-Disposition", "inline;filename=Vendor List.xls");
	
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("FirstSheet");
		
		HSSFFont font = (HSSFFont) workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();
		style.setFont(font);
		
		HSSFRow rowhead = sheet.createRow((short)0);
		rowhead.createCell(0).setCellValue("Vendor ID");
		rowhead.createCell(1).setCellValue("Vendor Name");
		rowhead.createCell(2).setCellValue("Vendor Address");
		
		int rownum = 1;
		for(Vendor v:vendor){
			HSSFRow row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(v.getvId());
			row.createCell(1).setCellValue(v.getvName());
			row.createCell(2).setCellValue(v.getvAddr());
		}
		workbook.write(response.getOutputStream());
		workbook.close();
		
	}
	
}
