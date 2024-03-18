package uk.example.api.database.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import uk.example.api.database.tables.Variation;

@Component
public interface VRepo extends CrudRepository<Variation, Long> {
}
