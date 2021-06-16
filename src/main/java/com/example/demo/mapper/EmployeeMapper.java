package com.example.demo.mapper;

import com.example.demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

//这个注解表示了这是一个mybatis的mapper类
@Mapper
@Repository
public interface EmployeeMapper {
    public List<Employee> selectAll();

    public void addEmployee(Employee employee);

    public Employee selectEmployeeById(Integer id);

    public void deleteEmployeeById(Integer id);

    public void updateEmp(Employee employee);
}