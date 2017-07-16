package com.g1.expertise.controller.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.g1.expertise.configuration.AppInitializer;
import com.g1.expertise.controller.AppController;
import com.g1.expertise.service.EmployeeService;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes=AppInitializer.class)
public class AppControllerTest{
	
	@InjectMocks
    private AppController appController = new AppController();
	
	   @Mock
	    EmployeeService service;
	     
	   @Mock
	    MessageSource messageSource;
	   
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
    	// Process mock annotations
        MockitoAnnotations.initMocks(this);
    	mockMvc = MockMvcBuilders
				.standaloneSetup(appController)
				.build();
    }
    
    @Test
    public void testlistEmployees() throws Exception {
        mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("allemployees"));
         

    }
    
    @Test
    public void testnewEmployees() throws Exception {
        mockMvc.perform(get("/new"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("registration"));
         

    }

	

}
