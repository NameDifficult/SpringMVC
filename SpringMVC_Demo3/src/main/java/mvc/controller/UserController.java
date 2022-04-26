package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Mi
 * @Date 2022/3/30 17:31
 * @Version 1.0
 */
@Controller
public class UserController {

    @RequestMapping("/testRestful")
    public String testRestful(){
        return "testRestful";
    }

    /**
     *      使用RESTFUL模拟用户资源的增删改查
     *  GET：    查询
     *  POST:    保存
     *  PUT：    修改
     *  DELETE： 删除
     */


    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getAllUsers(){
        System.out.println("查询所有用户信息");
        return "success";
    }


    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public String getAllUsersById(@PathVariable("id")String id){
        System.out.println("根据id查询用户信息" + "  id=" +id);
        return "success";
    }


    /**
     *  添加用户
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public String postUser(String username,String password){
        System.out.println("添加用户" + username + password);
        return "success";
    }



    /**
     *  修改用户
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    public String PUTUser(String username,String password){
        System.out.println("修改用户" + username + password);
        return "success";
    }


}
