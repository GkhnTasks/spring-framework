package com.cydeo.client;

import com.cydeo.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://dummyapi.io",name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {

    //https://dummyapi.io/data/v1/user?limit=10

    @GetMapping("/data/v1/user?limit=10")
    Employee getEmployee();

}
