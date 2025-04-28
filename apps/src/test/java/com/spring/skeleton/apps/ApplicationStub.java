package com.spring.skeleton.apps;

import com.spring.skeleton.Application;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {Application.class})
@AutoConfigureMockMvc
public class ApplicationStub {

}
