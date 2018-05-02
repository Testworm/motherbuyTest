package org.spring.springboot.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class City {

    /**
     * 城市编号
     */
	@ApiModelProperty(notes = "this is id")
    private Long id;

    /**
     * 省份编号
     */
	@ApiModelProperty(notes = "this is provinceId")
    private Long provinceId;

    /**
     * 城市名称
     */
	@ApiModelProperty(notes = "this is cityName")
    private String cityName;

    /**
     * 描述
     */
	@ApiModelProperty(notes = "this is description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
