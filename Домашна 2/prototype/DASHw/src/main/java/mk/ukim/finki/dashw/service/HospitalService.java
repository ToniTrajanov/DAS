package mk.ukim.finki.dashw.service;

import mk.ukim.finki.dashw.model.Hospital;

import java.io.IOException;
import java.util.List;

public interface HospitalService {
    List<Hospital> findAll();
    List<Hospital> addHospital(String hospitalsUrl) throws IOException;
    Hospital findById(Long id);
    List<Hospital> findAllByMunicipality(String municipality);

}
