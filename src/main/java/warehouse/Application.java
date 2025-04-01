package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import warehouse.model.ProductData;
import warehouse.model.WarehouseData;
import warehouse.repository.ProductRepository;
import warehouse.repository.WarehouseRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;

	@Autowired WarehouseRepository wrepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();
		wrepository.deleteAll();

		ProductData p1 = new ProductData("1","00-443175","Bio Orangensaft Sonne","Getraenk", 2500);
		ProductData p2 = new ProductData("1","00-871895","Bio Apfelsaft Gold","Getraenk", 3420);
		ProductData p3 = new ProductData("1","01-926885","Ariel Waschmittel Color","Waschmittel", 478);
		ProductData p4 = new ProductData("1","02-234811","Mampfi Katzenfutter Rind","Tierfutter", 1324);
		ProductData p5 = new ProductData("2","03-893173","Saugstauberbeutel Ingres","Reinigung", 7390);
		ProductData p6 = new ProductData("2","04-567812","Mikrofasertuch Ultra","Reinigung", 499);
		ProductData p7 = new ProductData("2","05-981234","Staubsaugerfilter Pro","Reinigung", 1299);
		ProductData p8 = new ProductData("2","06-753159","Fensterreiniger Spray","Reinigung", 899);

		// POST /products
		repository.save(p1);
		repository.save(p2);
		repository.save(p3);
		repository.save(p4);
		repository.save(p5);
		repository.save(p6);
		repository.save(p7);
		repository.save(p8);

		// POST /warehouse
		wrepository.save(new WarehouseData("1", "Lager Hamburg", "Musterstraße 1", "20095", "Hamburg", "Deutschland", null, repository.findByWarehouseID("1")));
		wrepository.save(new WarehouseData("2", "Lager München", "Mustergasse 2", "208", "München", "Deutschland", null, repository.findByWarehouseID("2")));

		System.out.println();

		// GET /warehouse
		System.out.println("Record(s) found with findAll():");
		System.out.println("--------------------------------");
		for (WarehouseData warehousedata : wrepository.findAll()) {
			System.out.println(warehousedata);
		}
		System.out.println();

		// GET /warehouse/{id}
		System.out.println("Record found with findByWarehouseID(\"2\"):");
		System.out.println("--------------------------------");
		System.out.println(wrepository.findByWarehouseID("2"));
		System.out.println();

		// GET /product
		System.out.println("ProductData found with findAll():");
		System.out.println("-------------------------------");
		for (ProductData productdata : repository.findAll()) {
			System.out.println(productdata);
		}
		System.out.println();

		// GET /product/{id}
		System.out.println("Record(s) found with ProductID(\"02-234811\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByProductID("02-234811"));
		System.out.println();

		// DELETE /product/{id}
		System.out.println("Deleting Product By Id(\"02-234811\"):");
		System.out.println("--------------------------------");
		repository.deleteByProductID("02-234811");
		System.out.println("Erfolgreich gelöscht!");
		System.out.println();
		//Kontrolle
		System.out.println("Record(s) found with ProductID(\"02-234811\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByProductID("02-234811"));
		System.out.println();

		//DELETE /warehouse/{id}
		System.out.println("Deleting Warehouse By Id(\"2\"):");
		System.out.println("--------------------------------");
		wrepository.deleteByWarehouseID("2");
		System.out.println("Erfolgreich gelöscht!");
		System.out.println();
		//Kontrolle
		System.out.println("Record(s) found with findAll():");
		System.out.println("--------------------------------");
		for (WarehouseData warehousedata : wrepository.findAll()) {
			System.out.println(warehousedata);
		}
		System.out.println();

	}

}
