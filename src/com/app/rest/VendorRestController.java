package com.app.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Vendor;
import com.app.service.IVendorService;

@Component
@Path(value="/Vendor")
@Consumes(value="application/json")
@Produces(value="application/json")
public class VendorRestController {


	@Autowired
	private IVendorService service;
	
	@GET
	@Path(value="/getAllVendor")
	public Response getAllVendor(){
		List<Vendor> list = service.getAllVendor();
		if(list == null)
			return Response.status(Response.Status.BAD_REQUEST).build();
		else
			return Response.ok(list).build();
	}
	
	@GET
	@Path(value="/getVendorById/{id}")
	public Response getVendorById(@PathParam("id") int id){
		Vendor vendor = service.getVendorById(id);
		if(vendor == null)
			return Response.status(Response.Status.BAD_REQUEST).build();
		else
			return Response.ok(vendor).build();
	}
	
	@POST
	@Path(value="/insertVendor")
	public Response insertVendor(Vendor vendor){
		if(vendor == null)
			return Response.status(Response.Status.BAD_REQUEST).build();
			 int i = service.saveVendor(vendor);
		if(i >= 1)
			return Response.ok().build();
		else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	@DELETE
	@Path(value="/deleteVendor/{id}")
	public Response deleteVendor(@PathParam("id") int id){
		service.deleteVendor(id);
		return Response.ok().build();
	}
	
	@PUT
	@Path(value="/updateVendor/{id}")
	public Response updateVendor(@PathParam("id") int id,Vendor vendor){
		service.updateVendor(vendor);
		return Response.ok().build();
	}
}
