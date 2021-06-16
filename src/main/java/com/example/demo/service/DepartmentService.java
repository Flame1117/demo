package com.example.demo.service;

import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface DepartmentService {

    //获得所有部门信息
    public List<Department> getDepartments();

    //通过id得到部门
    public Department getDepartmentById(Integer id);
}
