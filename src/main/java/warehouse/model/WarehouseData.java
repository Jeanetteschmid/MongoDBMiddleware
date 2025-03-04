package warehouse.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "warehouses")
public class WarehouseData {
    @Id
    private String warehouseID;

    private String warehouseName;
    private String warehouseAddress;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;
    private Timestamp timestamp;

    private List<ProductData> productData;

    public WarehouseData() {}

    public WarehouseData(String name, String address, String postCode, String city, String country, Timestamp t, List<ProductData> p) {
        this.warehouseName = name;
        this.warehouseAddress = address;
        this.warehousePostalCode = postCode;
        this.warehouseCity = city;
        this.warehouseCountry = country;
        this.timestamp = t;
        this.productData = p;
    }

    public String getWarehouseID() { return warehouseID; }

    public String getWarehouseName() { return warehouseName; }
    public void setWarehouseName(String warehouseName) { this.warehouseName = warehouseName; }

    public String getWarehouseAddress() { return warehouseAddress; }
    public void setWarehouseAddress(String warehouseAddress) { this.warehouseAddress = warehouseAddress; }

    public String getWarehousePostalCode() { return warehousePostalCode; }
    public void setWarehousePostalCode(String warehousePostalCode) { this.warehousePostalCode = warehousePostalCode; }

    public String getWarehouseCity() { return warehouseCity; }
    public void setWarehouseCity(String warehouseCity) { this.warehouseCity = warehouseCity; }

    public String getWarehouseCountry() { return warehouseCountry; }
    public void setWarehouseCountry(String warehouseCountry) { this.warehouseCountry = warehouseCountry; }

    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }

    public List<ProductData> getProducts() { return productData; }
    public void setProducts(List<ProductData> products) { this.productData = products; }
}
