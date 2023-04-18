package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope // TODO 配置热更新 第一种方式 1
public class UserController {

    @Autowired
    private UserService userService;

    /*@Value("${pattern.dateformat}") // TODO 配置热更新 第一种方式 2
    private String dateformat;*/

    @Autowired // TODO 配置热更新 第二种方式 2
    private PatternProperties patternProperties;

    @GetMapping("/prop")
    public PatternProperties prop() {
        return patternProperties;
    }

    @GetMapping("/now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth", required = false) String truth,
                          @RequestHeader(value = "Lotushint", required = false) String lotushint) {
        System.out.println("Truth = " + truth);
        System.out.println("Lotushint = " + lotushint);
        return userService.queryById(id);
    }
}
