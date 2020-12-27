package com.example.demo.repository;

import com.example.demo.model.Project;

public interface ProjectMapper
{

    // 对应xml映射文件元素的ID
    Project selectByName(String name);

}
