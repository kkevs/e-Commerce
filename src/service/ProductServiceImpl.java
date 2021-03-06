package service;

import java.io.Serializable;
import java.util.List;

import org.primefaces.event.RowEditEvent;

import dao.ProductDaoImpl;
import model.Category;
import model.Product;

public class ProductServiceImpl implements ProductService, Serializable {
	private static final long serialVersionUID = 1L;
	ProductDaoImpl daoImpl = new ProductDaoImpl();

	@Override
	public List<Category> getAllCategories() {
		return daoImpl.getAllCategory();
	}

	@Override
	public void saveProduct(Product product) {
		daoImpl.saveProduct(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return daoImpl.getAllProduct();
	}

	public Category getCategoryById(int id) {
		return daoImpl.getCategoryById(id);
	}

	@Override
	public void deleteProduct(Product selectedProduct) {
		daoImpl.deleteProduct(selectedProduct);
	}

	public void updateProduct(RowEditEvent event) {
		daoImpl.updateProduct(event);
	}

	@Override
	public List<Product> getProductById(int id) {
		return daoImpl.getProductById(id);
	}

}
