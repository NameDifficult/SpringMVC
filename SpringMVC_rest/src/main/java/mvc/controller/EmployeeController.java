package mvc.controller;

import mvc.bean.Employee;
import mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @Author Mi
 * @Date 2022/4/2 14:24
 * @Version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;



    @GetMapping("/employee")
    public ModelAndView getAllEmployee(){
        Collection<Employee> all = employeeDao.getAll();
        System.out.println(all);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Employees",all);
        modelAndView.setViewName("allEmployee");
        return modelAndView;
    }


    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        System.out.println(id);
        return "redirect:/employee";
    }

}
