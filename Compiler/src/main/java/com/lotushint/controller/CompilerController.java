package com.lotushint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hefan
 * @package com.lotushint
 * @date 2021/11/15 3:38
 * @description
 */
@Controller
public class CompilerController {
//    @RequestMapping("/testFirstFollow")
//    public String testFirstFollow(){
//        return "text_input";
//    }
//
//    @RequestMapping("/testLexicalAnalysis")
//    public String testLexicalAnalysis(){
//        return "code_input";
//    }

    @GetMapping(value = "/test/{id}")
    public String test(@PathVariable String id){
        switch (id){
            case "1":return "";
            case "2":return "code_input";
            case "3":return "text_input";
            case "4":return "";
            case "5":return "";
            case "6":return "";
            case "7":return "";
            case "8":return "";
        }
        return "error";
    }

//    @RequestMapping(value="/returnFirstFollowResolved/{data}",method = RequestMethod.POST)
//    public ModelAndView returnFirstFollowResolved(@PathVariable("data") String data){
//        ModelAndView mav = new ModelAndView();
//        //向请求域共享数据
//        mav.addObject("data", data);
//        //设置视图，实现页面跳转
//        mav.setViewName("first_follow_resolved");
//        return mav;
//    }


}
