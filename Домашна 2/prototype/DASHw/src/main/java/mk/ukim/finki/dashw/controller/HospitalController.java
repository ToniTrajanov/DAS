package mk.ukim.finki.dashw.controller;

import mk.ukim.finki.dashw.model.Hospital;
import mk.ukim.finki.dashw.model.Municipality;
import mk.ukim.finki.dashw.service.HospitalService;
import mk.ukim.finki.dashw.service.MunicipalityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class HospitalController {

    private final HospitalService hospitalService;
    private final MunicipalityService municipalityService;

    public HospitalController(HospitalService hospitalService, MunicipalityService municipalityService) {
        this.hospitalService = hospitalService;
        this.municipalityService = municipalityService;
    }

    @GetMapping("/hospitals")
    public String getHospitals(Model model,
    @RequestParam(required = false) String municipality
    ){
        List<Hospital> hospitals;
        if(municipality == null || municipality == ""){
            hospitals = hospitalService.findAll();
            List<Municipality> municipalities = municipalityService.findAll();
            model.addAttribute("hospitals", hospitals);
            model.addAttribute("municipalities", municipalities);
        }
        else {
            hospitals = hospitalService.findAllByMunicipality(municipality);
            List<Municipality> municipalities = municipalityService.findAll();
            model.addAttribute("hospitals", hospitals);
            model.addAttribute("municipalities", municipalities);
        }
        return "hospitals";
    }

    @PostMapping("/addHospitals")
    public String insertHospitals(
            @RequestParam String hospitalsUrl
    ) throws IOException {
        this.hospitalService.addHospital(hospitalsUrl);
        return "redirect:/home";
    }
}
