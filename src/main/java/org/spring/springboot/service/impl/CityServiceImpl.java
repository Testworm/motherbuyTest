package org.spring.springboot.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
    
	public int save(City city){
		return cityDao.save(city);
	}


}
