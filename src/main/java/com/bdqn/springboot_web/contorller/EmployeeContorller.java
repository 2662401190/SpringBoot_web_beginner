package com.bdqn.springboot_web.contorller;

import com.bdqn.springboot_web.dao.DepartmentDao;
import com.bdqn.springboot_web.dao.EmployeeDao;
import com.bdqn.springboot_web.entities.Department;
import com.bdqn.springboot_web.entities.Employee;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author 贺威
 * @create 2018-11-30 13:46
 */
@Controller
public class EmployeeContorller {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    /**
     * 查询所有员工返回列表页面
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        final Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps", employees);

        return  "emp/list";
    }
    /**
     * 进入员工添加修改页面
     * @return
     */
    @GetMapping(value = "/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEnp(Employee employee){

        employeeDao.save(employee);

        //redirect : 重定向一个地址
        //forward: 转发 一个地址
        return "redirect:/emps";
    }


    /**
     * 去修改页面先查出，该员工信息
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditEmp(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "emp/add";
    }

    /**
     * 修改
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String delectEmp(@PathVariable("id") Integer id){

        employeeDao.delete(id);
        return "redirect:/emps";
    }





}
