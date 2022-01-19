package a;

import java.util.List;




public interface ProductService {
	// Save operation
    Product saveProduct(Product product);
 
    // Read operation
    List<Product> fetchProductList();
 
    // Update operation
    Product updateDepartment(Product product,
                                Long productId);
 
    // Delete operation
    void deleteProductById(Long productId);
}


