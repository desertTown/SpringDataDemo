package com.jluzh.repository;

import com.jluzh.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Table;
import java.util.List;

public interface EmployeeRepository extends Repository<Employee, Integer>{
    Employee findByName(String name);

    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    @Query("select o from Employee o where id = (select max(id) from Employee )")
    Employee getEmployeeByMaxId();

    @Query("select o from Employee o where o.name = ?1 and o.age = ?2")
    Employee queryParams1(String name, Integer age);

    @Query("select o from Employee o where o.name =:name and o.age =:age")
    Employee queryParams2(@Param("name") String name, @Param("age")Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> queryLike1(String name);

    @Query(nativeQuery = true, value = "select count(1) from employee")
    long getCount();

    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    void updateAgeAccordingId(@Param("id")Integer id, @Param("age") Integer age);
}
