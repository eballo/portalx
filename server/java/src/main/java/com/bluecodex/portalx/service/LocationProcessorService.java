package com.bluecodex.portalx.service;

import com.bluecodex.portalx.model.Locations;
import com.bluecodex.portalx.service.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationProcessorService implements LocationService{

    private static final Logger LOG = LoggerFactory.getLogger(LocationProcessorService.class);

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Locations getLocationByDescription(String description) {
        LOG.info("Getting locations by description {}",description);
        Locations locations = locationRepository.findByDescription(description);
        return locations;
    }
}
