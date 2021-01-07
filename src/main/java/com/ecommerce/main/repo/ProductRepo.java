package com.ecommerce.main.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ecommerce.main.model.Product;

public interface ProductRepo extends MongoRepository<Product, String> {
	
}
