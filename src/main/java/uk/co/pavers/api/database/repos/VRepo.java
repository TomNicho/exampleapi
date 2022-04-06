package uk.co.pavers.api.database.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import uk.co.pavers.api.database.tables.Variation;

@Component
public interface VRepo extends CrudRepository<Variation, Long> {
}
