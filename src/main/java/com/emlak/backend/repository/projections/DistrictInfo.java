package com.emlak.backend.repository.projections;

public interface DistrictInfo {
    String getId();

    String getDistrict();

    CityInfo getCity();
}
