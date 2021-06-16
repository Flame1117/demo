package com.example.demo.service.Impl;

import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.pojo.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartments() {
        return departmentMapper.selectAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return null;
    }
}
