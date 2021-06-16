package com.example.demo.service.Impl;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.pojo.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public Employee selectEmployeeById(Integer id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeMapper.deleteEmployeeById(id);
    }

    @Override
    public void updateEmpById(Employee employee) {
        employeeMapper.updateEmp(employee);
    }
}
