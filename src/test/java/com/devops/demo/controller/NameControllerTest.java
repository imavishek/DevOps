/**
 * @ProjectName: DevOps
 * @PackageName: com.devops.demo.controller
 * @FileName: NameControllerTest.java
 * @Author: Avishek Das
 * @CreatedDate: 08-09-2020
 */

package com.devops.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class NameControllerTest {

	@InjectMocks
	private NameController nameController;

	private MockMvc mockMvc;

	private static ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		mockMvc = MockMvcBuilders.standaloneSetup(nameController).build();
	}

	@Test
	public void getNameTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/getName").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();

		assertEquals("Hello", resultContent);
	}
}
