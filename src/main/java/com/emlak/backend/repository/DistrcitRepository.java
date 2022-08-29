package com.emlak.backend.repository;

import com.emlak.backend.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrcitRepository extends JpaRepository<District,Integer> {

    List<District> findDistrictsByCity_Id(Integer id);

}
