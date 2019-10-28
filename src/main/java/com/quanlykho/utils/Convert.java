package com.quanlykho.utils;

import com.quanlykho.model.Employee;
import com.quanlykho.model.Entity;
import com.quanlykho.model.ExportProduct;
import com.quanlykho.model.ImportProduct;
import com.quanlykho.model.Product;

public class Convert {

	public static Entity importProductToEntity(ImportProduct imp) {
		Product p = imp.getProduct();
		Employee e = imp.getEmployee();
		Entity entity = new Entity(p.getId(), p.getNameProduct(), e.getId(), e.getUserName(), imp.getDateUpdate(), imp.getNumber(), imp.getPrice());
		return entity;
	}

	public static ImportProduct entityToImportProduct( Entity entity, Product p, Employee e) {
		ImportProduct imp = new ImportProduct(entity.getNumber(), entity.getDate(),e, p, entity.getPrice());
		return imp;
	}

	public static Entity exportProductToEntity(ExportProduct exp) {
		Product p = exp.getProduct();
		Employee e = exp.getEmployee();
		Entity entity = new Entity(p.getId(), p.getNameProduct(), e.getId(), e.getUserName(), exp.getDateExport(), exp.getNumber(), exp.getPrice());
		return entity;
	}

	public static ExportProduct entityToExportProduct( Entity entity, Product p, Employee e) {
		ExportProduct exp = new ExportProduct(entity.getNumber(), entity.getDate(),e, p, entity.getPrice());
		return exp;
	}

	public static Entity objectToEntity(Object[] o) {
		Integer productId = Integer.valueOf(o[0].toString());
		String productName = o[1].toString();
		Integer userId = Integer.valueOf(o[2].toString());
		String userName = o[3].toString();
		Integer number = Integer.valueOf(o[4].toString());
		String date  = o[5].toString();
		Double price = Double.valueOf(o[6].toString());
		Entity entity = new Entity(productId, productName, userId, userName, date, number, price);
		return entity;
	}
}
