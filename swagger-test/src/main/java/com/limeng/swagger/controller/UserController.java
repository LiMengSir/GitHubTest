package com.limeng.swagger.controller;

import com.limeng.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 动力节点1918李萌
 * 2020/6/18
 */

@Controller
public class UserController {

    //Swagger的所有注解定义在io.swagger.annotations包下
    //正式发布后，关闭swagger，避免接口暴露

    @GetMapping(value = "/hello")
    @ResponseBody
    public String toHello(){
        return "nihao";
    }

    @ApiOperation("toLimengHello接口方法说明")
    @GetMapping(value = "/limeng/hello")
    @ResponseBody
    public User toLimengHello(@ApiParam("id参数说明")int id, @ApiParam("name参数说明")String name){

        return new User(id,name);
    }

}
