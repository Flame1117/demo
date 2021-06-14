package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //返回员工列表
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    //跳转到添加员工页面
    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping ("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        System.out.println("save--->"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //跳转到员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmpPage(@PathVariable("id") Integer id, Model model){
        //查出原来的数据
        System.out.println("id----->"+id);
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    //删除员工
    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    //退出
    @RequestMapping("user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
