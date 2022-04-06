package uk.co.pavers.api.database.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import uk.co.pavers.api.database.tables.Stock;

@Component
public interface SRepo extends CrudRepository<Stock, Long> {
}
