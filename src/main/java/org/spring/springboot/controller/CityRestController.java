package org.spring.springboot.controller;

import static springfox.documentation.builders.PathSelectors.regex;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 */
@RequestMapping("/api")
@RestController
@EnableSwagger2
public class CityRestController {

    @Autowired
    private CityService cityService;
    
	@Bean
	public Docket demoApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.spring.springboot.controller")).paths(regex("/api.*")).build()
				.apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API Demo by Torre Yang", "Spring Boot REST API for Simple Demo", "1.0",
				"termsOfServiceUrl",
				new Contact("Torre Yang", "https://github.com/Testworm/",
						"klyweiwei@163.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}

    @RequestMapping(value = "/checkcity", method = RequestMethod.GET, produces = "application/json")
    public List<City> findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }

//    @RequestMapping(value = "/api/addcity", method = RequestMethod.POST)
//    public int addCity(@RequestParam(value = "City", required = true) City city) {
//        return cityService.save(city);
//    }
    
	@ApiOperation(value = "增加城市", response = org.spring.springboot.domain.City.class, responseContainer = "city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @RequestMapping(value = "/addcity", method = RequestMethod.POST)
    public int addCity(@RequestBody City city) {
        return cityService.save(city);
    }
    
    
}
