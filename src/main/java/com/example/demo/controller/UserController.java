package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.common.Result;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController
{

    // 注入mapper类
    @Resource
    private UserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUser(@PathVariable long id) throws Exception {

        User user = this.userService.getUserById(id);

        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public PageInfo<User> listUser(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "page-size", required = false, defaultValue = "5") int pageSize) {
        List<User> result = userService.listUser(page, pageSize);
        // PageInfo包装结果，返回更多分页相关信息
        PageInfo<User> pi = new PageInfo<User>(result);
        return pi;
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Result> hello(@RequestParam(value="bad", required=false, defaultValue="false") boolean bad) {

        // 结果封装类对象
        Result res = new Result(200, "ok");

        if(bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);
        }

        // 把结果数据放进封装类
        res.putData("words", "Hello world!");

        // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回200
        return ResponseEntity.ok(res);
    }

}
