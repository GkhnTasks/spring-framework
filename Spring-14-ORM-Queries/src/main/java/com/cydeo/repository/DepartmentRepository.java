package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String > {

    //Display all departments in the furniture departments
    List<Department> findByDepartment(String  department);

    //Display all departments in the Health Division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display top 3 departments with division name includes "Hea, without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String division);

    @Query("select  d from  Department  d where d.division in  ?1")
    List<Department> getDepartmentDivision(List<String > division);

    @Query
    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);

}
