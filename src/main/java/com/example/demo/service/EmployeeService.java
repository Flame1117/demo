package com.example.demo.service;

import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface EmployeeService {

    //增加一个员工
    public void addEmployee(Employee employee);

    //查询全部员工信息
    public List<Employee> selectAll();

    //通过id查询员工
    public Employee selectEmployeeById(Integer id);

    //通过id删除员工
    public void deleteEmployeeById(Integer id);


    public void updateEmpById(Employee employee);
}
