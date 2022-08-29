package com.emlak.backend.api;

import com.emlak.backend.entity.City;
import com.emlak.backend.entity.District;
import com.emlak.backend.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictApi {

    private final DistrictService districtService;

    public DistrictApi(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/")
    public ResponseEntity<List<City>> findAllCities() {
        List<City> list = this.districtService.findAllCity();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<District>> findDistrictsByCityId(@PathVariable Integer id) {
        List<District> list = this.districtService.findDistrictByCityId(id);
        return ResponseEntity.ok(list);
    }
}
