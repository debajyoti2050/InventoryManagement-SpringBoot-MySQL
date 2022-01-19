package a;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;


public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	// Save operation
    @Override
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }
	
   // Read operation
    @Override public List<Product> fetchProductList()
    {
        return (List<Product>)
            productRepository.findAll();
    }
    
 // Update operation
    @Override
    public Product
    updateDepartment(Product product,
                     Long productId)
    {
        Product prodDB
            = productRepository.findById(productId)
                  .get();
 
        if (Objects.nonNull(product.getProductName())
            && !"".equalsIgnoreCase(
                product.getProductName())) {
            prodDB.setProductName(
                product.getProductName());
        }
 
        if (Objects.nonNull(
                product.getProductManufacturer())
            && !"".equalsIgnoreCase(
                product.getProductManufacturer())) {
            prodDB.setProductManufacturer(
                product.getProductManufacturer());
        }
 
        if (Objects.nonNull(product.getProductPrice())
            && !"".equalsIgnoreCase(
                product.getProductPrice())) {
            prodDB.setProductPrice(
                product.getProductPrice());
        }
 
        return productRepository.save(prodDB);
    }
    
 // Delete operation
    @Override
    public void deleteProductById(Long productId)
    {
        productRepository.deleteById(productId);
    }



}
