package com.example.demo.project.domain.repository;

import com.example.demo.project.domain.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectRepository {

    @Insert("""
            insert into project (id, name, team_id, user_id) values (#{id}, #{name}, #{teamId}, #{userId})
            """)
    Project save(Project project);

    @Select("""
            select * from project where id = #{id}
            """)
    Project findById(String id);

    @Select("""
            select * from project
            """)
    List<Project> findAll();
}
