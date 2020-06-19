package com.limeng.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

/**
 * 动力节点1918李萌
 * 2020/6/18
 */


//只要这个实体在请求接口的返回值上（即使是泛型），都能映射到实体项中
@ApiModel("用户实体")
public class User {

    @ApiModelProperty("用户编号")
    private int id;

    @ApiModelProperty("用户名")
    private String name;

    public User() {     //无参构造
    }

    public User(int id, String name) {  //有参构造
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }


}
