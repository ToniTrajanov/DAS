package mk.ukim.finki.dashw.controller;

import mk.ukim.finki.dashw.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class PharmacyController {
    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }



    @PostMapping("/addPharmacies")
    public String insertPharmacies(@RequestParam String pharmaciesUrl) throws IOException {


        this.pharmacyService.addPharmacy(pharmaciesUrl);

        return "redirect:/home";
    }
}
