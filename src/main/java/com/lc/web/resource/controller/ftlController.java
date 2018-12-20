package com.lc.web.resource.controller;

import com.lc.web.resource.entity.treeStatistics_treespecies;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/19/019.
 */

@Controller

public class ftlController {



    @RequestMapping("/ftlindex")
    public String ftlindex(Map<String,Object> map){
        map.put("name","lt");
        map.put("age","20");
        return "index/layui";
    }

}
