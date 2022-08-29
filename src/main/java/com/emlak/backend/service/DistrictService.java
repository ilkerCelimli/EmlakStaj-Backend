package com.emlak.backend.service;

import com.emlak.backend.entity.City;
import com.emlak.backend.entity.District;
import com.emlak.backend.repository.CityRepository;
import com.emlak.backend.repository.DistrcitRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictService {


    private final DistrcitRepository discritRepository;
    private final CityRepository cityRepository;
    public DistrictService(DistrcitRepository discritRepository, CityRepository cityRepository) {
        this.discritRepository = discritRepository;
        this.cityRepository = cityRepository;
    }


    public List<District> findDistrictByCityId(Integer id) {
        return this.discritRepository.findDistrictsByCity_Id(id);
    }

    public List<City> findAllCity() {
        return this.cityRepository.findAll(Sort.by("id").ascending());
    }


}
