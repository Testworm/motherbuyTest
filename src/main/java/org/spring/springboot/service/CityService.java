package org.spring.springboot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;
import org.springframework.web.bind.annotation.RequestBody;

public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    List<City> findCityByName(String cityName);
	public int save(City city);

}
