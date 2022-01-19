package a;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired(required=false) 
    private ProductService productService;
 
    // Save operation
    @PostMapping(value="/products", consumes = {"application/json"})
    public Product saveProduct(@Validated @RequestBody Product product)
    {
        return productService.saveProduct(product);
    }
 
    // Read operation
    @GetMapping("/products")
    public List<Product> fetchProductList()
    {
        return productService.fetchProductList();
    }
 
    // Update operation
    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable("id") Long departmentId)
    {
        return productService.updateDepartment(
            product, departmentId);
    }
 
    // Delete operation
    @DeleteMapping("/products/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        productService.deleteProductById(departmentId);
        return "Deleted Successfully";
    }

}
