package com.cydeo.repository;

import com.cydeo.entity.Course;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Display all employees with email address
    List<Employee> findByEmail(String email);

    //Display all employees with first name ' ' and last name ' ' also shows all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String  firstName, String lastName, String email);

    //Display all employees that first name is not " "
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ''
    List<Employee> findByLastNameStartingWith(String pattern);

    //Display all employees with salary higher than  ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less the ' "
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between " "  and " "
    List<Employee> findByHireDateBetween(LocalDate startDate,LocalDate endDate);

    //Display all employees where salaries greater and equal to " " in order
    List<Employee> findBySalaryGreaterThanOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than " "
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email adress
//    List<Employee> findByEmailIsNotNull(String  email);



    @Query("SELECT  e FROM  Employee e WHERE e.email='sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee  e WHERE  e.email='sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM  Employee  e WHERE  e.email=?1")
    Optional<Employee> getEmployeeDeatil(String Email);

    @Query("select e from Employee  e where  e.email=?1 and  e.salary=?2")
    Employee getEmployeeDetail(String email,int salary);

    //Not equal
    @Query("select e from Employee  e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //Like/contains/startwith/endwith
    @Query("select  e from  Employee  e where  e.firstName like  ?1")
    List<Employee> getEmployeeFirstNameLike(String  pattern);

    //less than
    @Query("select e from Employee e where e.salary< ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("select e from Employee e where e.salary>?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    //before
    @Query("select e from Employee  e where e.hireDate> ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    //between
    @Query("select  e from Employee  e where  e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //Not null
    @Query("select e from Employee  e where  e.email is not null ")
    List<Employee> getEmployeeEmailIsNull();

    //Sorting in asc order
    @Query("select  e from  Employee  e order by e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //Sorting in descorder
    @Query("select  e from  Employee  e order by e.salary desc ")
    List<Employee> getEmployeeSalaryOrderDesc();

    @Query(value = "select * from employees where salary ?1",nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);

    @Query("select e from Employee e where e.salary= :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee  e SET  e.email= 'admin@email.com' where e.id=:id")
    void updateEmployeeJPQL(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET  email= 'admin@email.com' where id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);







}
