package uk.example.api.database.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import uk.example.api.database.tables.Product;

@Component
public interface PRepo extends CrudRepository<Product, Long> {
}
