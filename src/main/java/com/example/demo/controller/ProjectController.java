package com.example.demo.controller;

import javax.annotation.Resource;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/project")
public class ProjectController
{

    // 注入mapper类
    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "{name}", method = RequestMethod.GET, produces = "application/json")
    public Project getUser(@PathVariable String name) throws Exception {

        Project project = this.projectService.getProjectByName(name);

        return project;
    }

}
