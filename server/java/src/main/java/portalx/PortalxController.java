package portalx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PortalxController {

    @GetMapping("/locations")
    @ResponseBody
    public Location getLocationsByDescription(@RequestParam(name="description", required=false, defaultValue="Test3") String description) {
        return new Location("1","2","Amsterdam");
    }
}
