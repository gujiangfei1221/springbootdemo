package com.example.demo.service.impl;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectMapper;
import com.example.demo.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    // 注入mapper类
    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Project getProjectByName(String name) {
        return projectMapper.selectByName(name);
    }
}
