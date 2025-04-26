package com.spring.skeleton.apps;

import com.spring.skeleton.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {Application.class})
@AutoConfigureMockMvc
public class ApplicationStub {

    @Autowired
    public MockMvc mvc;
}
