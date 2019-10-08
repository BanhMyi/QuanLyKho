package com.quanlykho.service.base;

import java.util.List;

import com.quanlykho.model.Entity;
import com.quanlykho.model.ExportProduct;
import com.quanlykho.model.ImportProduct;
import com.quanlykho.model.Product;

public interface ProductService {

	public List<Product> getAllProduct();
	public Product getProductById(Integer id);
	public void addProduct(Product product);
	public void deleteProduct(Integer id);

	public void importProducts(ImportProduct importProduct);
	public void exportProducts(ExportProduct exportProduct);
	List<Product> searchProducts(String term);
	List<Entity> getHistoryImport();
	List<Entity> getHistoryExport();
	List<Entity> importProductSearch(Integer numberSearch, String dateSearch, String userNameSearch,
			String nameProductSearch, Integer productIdSearch, Integer employeeIdSearch);
	List<Entity> exportProductSearch(Integer numberSearch, String dateSearch, String userNameSearch,
			String nameProductSearch, Integer productIdSearch, Integer employeeIdSearch);
}
