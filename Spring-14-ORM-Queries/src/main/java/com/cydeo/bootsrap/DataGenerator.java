package com.cydeo.bootsrap;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("-----------REGION START--------------");

        //how i will access to method that i just built
        System.out.println("findByCountry = " + regionRepository.findByCountry("Canada"));

        System.out.println("findDistinctByCountry = " + regionRepository.findDistinctByCountry("Canada"));

        System.out.println("findByCountryContaining= " + regionRepository.findByCountryContaining("United"));

        System.out.println("indByCountryContainingOrderByCountry = " + regionRepository.findByCountryContainingOrderByCountry("Asia"));

        System.out.println("findTopByCountry = " + regionRepository.findTop2ByCountry("Canada"));


        System.out.println("-----------REGION END--------------");

        System.out.println("-----------DEPARTMENT START--------------");

        System.out.println("findByDepartment= " + departmentRepository.findByDepartment("Toys"));

        System.out.println("findByDivisionIs " + departmentRepository.findByDivisionIs("Outdoors"));

        System.out.println("findDistinctTop3ByDivisionContaining = " + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));
        System.out.println("-----------DEPARTMENT END--------------");

        System.out.println("-----------EMPLOYEE START--------------");
    }
}
