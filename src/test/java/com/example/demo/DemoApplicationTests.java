package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//import com.example.controller.HelloWordController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//	@Test
//	public void contextLoads() {
//	}

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
     //   mvc = MockMvcBuilders.standaloneSetup(new HelloWordController()).build();
    }

    @Test
    public void getHello() throws Exception {
    	//构造一个请求
    	//MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/hello");
    	
      //  MockHttpServletRequestBuilder accept = mockHttpServletRequestBuilder.accept(MediaType.APPLICATION_JSON);
        
//        mvc.perform(
//        		 MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Hello World")));
    }
    
    @Test
    public void test2() {
    	System.out.println(sqlSessionTemplate);
    }
    
}
