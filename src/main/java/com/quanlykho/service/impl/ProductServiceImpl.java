package com.quanlykho.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlykho.model.Entity;
import com.quanlykho.model.ExportProduct;
import com.quanlykho.model.ImportProduct;
import com.quanlykho.model.Product;
import com.quanlykho.repository.base.ExportProductRepository;
import com.quanlykho.repository.base.ImportProductRepository;
import com.quanlykho.repository.base.ProductRepository;
import com.quanlykho.service.base.ProductService;
import com.quanlykho.utils.Convert;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ImportProductRepository importProductRepository;
	@Autowired
	private ExportProductRepository exportProductRepository;

	@Override
	public List<Product> getAllProduct() {
		List<Product> listProducts = productRepository.findAll();
		List<Product> actives = getActiveProducts(listProducts);
		return actives;
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public void addProduct(Product product) {
		product.setActive(1);
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(Integer id) {
		Product p = productRepository.findById(id).get();
		p.setActive(0);
		productRepository.save(p);
	}

	@Override
	public List<Product> searchProducts(String term) {
		List<Product> listProducts = productRepository.findByNameContaining(term);
		List<Product> actives = getActiveProducts(listProducts);
		return actives;
	}

	@Override
	public void importProducts(ImportProduct importProduct) {
		importProductRepository.save(importProduct);
		Product product = productRepository.findById(importProduct.getProduct().getId()).get();
		Integer number = product.getNumber() + importProduct.getNumber();
		productRepository.updateNumberProduct(product.getId(), number);
	}

	@Override
	public void exportProducts(ExportProduct exportProduct) {
		exportProductRepository.save(exportProduct);
		Product product = productRepository.findById(exportProduct.getProduct().getId()).get();
		Integer number = product.getNumber() - exportProduct.getNumber();
		productRepository.updateNumberProduct(product.getId(), number);
	}

	@Override
	public List<Entity> getHistoryImport() {
		List<ImportProduct> list = importProductRepository.findAll();
		System.out.println("list import size: " + list.size());
		List<Entity> responseList = new ArrayList<>();
		for (ImportProduct imp : list) {
			Entity entity = Convert.importProductToEntity(imp);
			System.out.println(entity.toString());
			responseList.add(entity);
		}
		Collections.reverse(responseList);
		return responseList;
	}
	@Override
	public List<Entity> getHistoryExport() {
		List<ExportProduct> list = exportProductRepository.findAll();
		List<Entity> responseList = new ArrayList<>();
		for (ExportProduct exp : list) {
			Entity entity = Convert.exportProductToEntity(exp);
			responseList.add(entity);
		}
		Collections.reverse(responseList);
		return responseList;
	}
	private List<Product> getActiveProducts(List<Product> listProducts) {
		List<Product> actives = new ArrayList<>();
		if (listProducts == null || listProducts.isEmpty()) {
			return actives;
		}
		for (Product p : listProducts) {
			if (p.getActive() == 1) {
				actives.add(p);
			}
		}
		return actives;
	}

	@Override
	public List<Entity> importProductSearch(Integer numberSearch, String dateSearch, String userNameSearch,
			String nameProductSearch, Integer productIdSearch, Integer employeeIdSearch) {
		List<Object[]> seachResult = importProductRepository.searchImportProduct(numberSearch, dateSearch, userNameSearch,
																																		nameProductSearch, productIdSearch, employeeIdSearch);
		List<Entity> results = new ArrayList<>();
		for (Object[] o : seachResult) {
			Entity entity = Convert.objectToEntity(o);
			results.add(entity);
		}
		return results;
	}

	@Override
	public List<Entity> exportProductSearch(Integer numberSearch, String dateSearch, String userNameSearch,
			String nameProductSearch, Integer productIdSearch, Integer employeeIdSearch) {
		List<Object[]> seachResult = exportProductRepository.searchExportProduct(numberSearch, dateSearch, userNameSearch,
																																		nameProductSearch, productIdSearch, employeeIdSearch);
		List<Entity> results = new ArrayList<>();
		for (Object[] o : seachResult) {
			Entity entity = Convert.objectToEntity(o);
			results.add(entity);
		}
		return results;
	}
}
