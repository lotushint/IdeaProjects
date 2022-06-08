package com.lotus.springboot2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 10:25
 * @package com.lotus.springboot2
 * @description 编写测试类
 * 我们使用MockServletContext来构建一个空的WebApplicationContext,
 * 这样我们创建的HelloBootApplication就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中.
 *
 * 使用MockServletContext来构建一个空的WebApplicationContext,
 * 这样我们创建的HelloController就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class HelloBootApplicationTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloBootApplication()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Spring Boot2!")));
    }

}