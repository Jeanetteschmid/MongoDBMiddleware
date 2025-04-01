package warehouse.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import warehouse.model.WarehouseData;

public interface WarehouseRepository extends MongoRepository<WarehouseData, String> {
    public List<WarehouseData> findAll();
    public WarehouseData findByWarehouseID(String warehouseID);
    public void deleteByWarehouseID(String warehouseID);

 }
