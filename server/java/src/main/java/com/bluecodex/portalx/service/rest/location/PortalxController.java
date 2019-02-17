package com.bluecodex.portalx.service.rest.location;

import com.bluecodex.portalx.model.Locations;
import com.bluecodex.portalx.service.LocationProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PortalxController {

    @Autowired
    private LocationProcessorService locationProcessorService;

    @GetMapping("/locations/{description}")
    @ResponseBody
    public Locations getLocationsByDescription(@PathVariable(name="description", required=false) String description) {
        return locationProcessorService.getLocationByDescription(description);
    }
}
