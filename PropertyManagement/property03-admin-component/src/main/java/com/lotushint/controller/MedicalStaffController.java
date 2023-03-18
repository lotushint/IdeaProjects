package com.lotushint.controller;

import com.github.pagehelper.PageInfo;
import com.lotushint.entity.MedicalStaff;
import com.lotushint.entity.User;
import com.lotushint.service.MedicalStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MedicalStaffController {
    @Autowired
    MedicalStaffService service;
    //所有居民
    @RequestMapping(value = "medicalStaff/list",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25")int size){
        List<MedicalStaff> medicalStaffs = service.findAll(page,size);
        PageInfo<User> pageInfo=new PageInfo(medicalStaffs);
        model.addAttribute("pageInfo",pageInfo);
        return "medicalStafflist";
    }
    //根据id查找居民
    @RequestMapping(value = "medicalStaff/info/{id}",method = RequestMethod.GET)
    public String info(@PathVariable("id")int id,Model model){
        MedicalStaff medicalStaff = service.get(id);
        model.addAttribute("medicalStaff",medicalStaff);
        return "medicalStaffInfo";
    }
    //更新或插入居民的现状
    @RequestMapping(value = "medicalStaff/update",method = RequestMethod.GET)
    public String update(int baseId,String current){

        service.update(baseId,current);
        System.out.println(baseId+current);
        return "redirect:/medicalStaff/info/"+baseId;
    }

    @RequestMapping(value = "medicalStaff/listByMedicalStaffName")
    public String listByMedicalStaffName(Model model, @RequestParam(name = "name", required = true) String name) {
        List<MedicalStaff> medicalStaffs = service.findByName(name);
        System.out.println(medicalStaffs);
        PageInfo<MedicalStaff> pageInfo = new PageInfo<>(medicalStaffs);
        model.addAttribute("pageInfo", pageInfo);
        return "medicalStaffList";
    }
}
