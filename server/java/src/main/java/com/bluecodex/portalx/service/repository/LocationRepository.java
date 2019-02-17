package com.bluecodex.portalx.service.repository;

import com.bluecodex.portalx.model.Locations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Locations, String> {

    Locations findByDescription(final String description);
}
