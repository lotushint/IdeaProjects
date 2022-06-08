package com.lotushint.crowd.mvc.handler;

import com.lotushint.crowd.entity.Admin;
import com.lotushint.crowd.entity.ParamData;
import com.lotushint.crowd.entity.Student;
import com.lotushint.crowd.service.api.AdminService;
import com.lotushint.crowd.util.CrowdUtil;
import com.lotushint.crowd.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/13 12:49
 * @package com.lotushint.crowd.mvc.handler
 * @description 接收不了就用 String 类型接收
 */
@Controller
public class TestAjaxHandler {
    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestAjaxHandler.class);

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap, HttpServletRequest request) {
        boolean judgeResult = CrowdUtil.judgeRequestType(request);
        logger.info("judgeResult=" + judgeResult);

        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList", adminList);

        System.out.println(10 / 0);

        return "target";
    }

    /**
     * 通过 @RequestParam接收数组
     *
     * @param array
     * @return
     */
    @ResponseBody
    @RequestMapping("/send/array/one.html")
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
        for (Integer number : array) {
            System.out.println("number=" + number);
        }
        return "success";
    }


    /**
     * @param paramData 封装 List
     * @return
     */
    @ResponseBody
    @RequestMapping("/send/array/two.html")
    public String testReceiveArrayTwo(ParamData paramData) {
        List<Integer> array = paramData.getArray();
        for (Integer number : array) {
            System.out.println("number=" + number);
        }
        return "success";
    }

    /**
     * @param array
     * @return
     */
    @ResponseBody
    @RequestMapping("/send/array/three.html")
    public String testReceiveArrayThree(@RequestBody List<Integer> array) {
        for (Integer number : array) {
            logger.info("number=" + number);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/compose/object.html")
    public String testReceiveComposeObject(@RequestBody Student student) {
        logger.info(student.toString());
        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/compose/object.json")
    public ResultEntity<Student> testReceiveComposeObjectJson(@RequestBody Student student) {
        logger.info(student.toString());

        ResultEntity<Student> resultEntity = ResultEntity.successWithData(student);
        return resultEntity;
    }

    @ResponseBody
    @RequestMapping("/test/ajax/async.html")
    public String testAsync() throws InterruptedException {
        Thread.sleep(2000);
        return "success";
    }
}
