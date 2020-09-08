/**
 * @ProjectName: DevOps
 * @PackageName: com.devops.demo.controller
 * @FileName: NameController.java
 * @Author: Avishek Das
 * @CreatedDate: 08-09-2020
 */

package com.devops.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	@GetMapping(value = "/getName", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getName() {

		return "Hello";
	}
}
