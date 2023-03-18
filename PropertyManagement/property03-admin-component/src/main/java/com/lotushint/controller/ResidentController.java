package com.lotushint.controller;

import com.github.pagehelper.PageInfo;
import com.lotushint.entity.Resident;
import com.lotushint.entity.User;
import com.lotushint.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResidentController {
    @Autowired
    ResidentService service;
    //所有居民
    @RequestMapping(value = "resident/list",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25")int size){
        List<Resident> residents = service.findAll(page,size);
        PageInfo<User> pageInfo=new PageInfo(residents);
        model.addAttribute("pageInfo",pageInfo);
        return "residentlist";
    }
    //根据id查找居民
    @RequestMapping(value = "resident/info/{id}",method = RequestMethod.GET)
    public String info(@PathVariable("id")int id,Model model){
        Resident resident = service.get(id);
        model.addAttribute("resident",resident);
        return "residentInfo";
    }
    //更新或插入居民的现状
    @RequestMapping(value = "resident/update",method = RequestMethod.GET)
    public String update(int baseId,String current){

        service.update(baseId,current);
        System.out.println(baseId+current);
        return "redirect:/resident/info/"+baseId;
    }

    @RequestMapping(value = "resident/listByResidentName")
    public String listByResidentName(Model model, @RequestParam(name = "name", required = true) String name) {
        List<Resident> residents = service.findByName(name);
        System.out.println(residents);
        PageInfo<Resident> pageInfo = new PageInfo<>(residents);
        model.addAttribute("pageInfo", pageInfo);
        return "residentlist";
    }
}
