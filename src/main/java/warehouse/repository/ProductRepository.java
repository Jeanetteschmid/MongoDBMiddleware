package warehouse.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import warehouse.model.ProductData;

public interface ProductRepository extends MongoRepository<ProductData, String> {

    public ProductData findByProductID(String productID);
    public List<ProductData> findByWarehouseID(String warehouseID);
    public List<ProductData> findAll();

    public void deleteByProductID(String productID);
}
