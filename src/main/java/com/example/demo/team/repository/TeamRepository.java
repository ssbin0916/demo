package com.example.demo.team.repository;

import com.example.demo.team.domain.Team;
import com.example.demo.team.domain.request.SaveTeamRequest;
import com.example.demo.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamRepository {

    @Insert("""
            insert into team (id, name) values (#{id}, #{name})
            """)
    void save(Team team);

    @Insert("""
            insert into user_team (user_id, team_id) values (#{userId}, #{teamId})
            """)
    void addTeam(SaveTeamRequest saveTeamRequest);

    @Select("""
            select * from team where name = #{name}
            """)
    Team findByName(String name);

    @Select("""
            select
            u.*
            from team t
            join user_team ut on t.id = ut.team_id
            join user u on ut.user_id = u.id
            where t.name = #{name}
            """)
    List<User> findUserByTeamName(String name);

    @Select("""
            select
            t.*
            from team t
            join user_team ut on t.id = ut.team_id
            join user u on ut.user_id = u.id
            where u.name = #{name}
            """)
    List<Team> findTeamsByUsername(String name);
}
