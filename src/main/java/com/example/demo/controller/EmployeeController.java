package com.example.demo.controller;

import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
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
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    //返回员工列表
    @RequestMapping("/showEmps")
    public String showEmpList(Model model){
        List<Employee> employees = employeeService.selectAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    //跳转到添加员工页面
    @GetMapping("/toAddEmpPage")
    public String toAddEmpPage(Model model){
        //查出所有部门的信息
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping ("/addEmp")
    public String addEmp(Employee employee){
        //添加的操作
        System.out.println("add--->"+employee);
        employeeService.addEmployee(employee);
        return "redirect:/showEmps";
    }

    //跳转到员工修改页面
    @GetMapping("/toUpdateEmpPage/{id}")
    public String toUpdateEmpPage(@PathVariable("id") Integer id, Model model){
        //查出原来的数据
        System.out.println("id----->"+id);
        Employee employee = employeeService.selectEmployeeById(id);
        model.addAttribute("employee",employee);
        //查出所有部门的信息
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    //修改员工
    @PostMapping ("/updateEmp")
    public String updatEemp(Employee employee){
        System.out.println("save--->"+employee);
        employeeService.updateEmpById(employee);
        return "redirect:/showEmps";
    }

    //删除员工
    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/showEmps";
    }

    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
