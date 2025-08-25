package com.example.dao;


import com.example.model.Student;
import com.example.rowmapper.StudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /** Insert a record (duplicates allowed since no PK) */
    public int insert(Student s) {
        String sql = "INSERT INTO student (name, age, course) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, s.getName(), s.getAge(), s.getCourse());
    }

    /** Fetch all rows */
    public List<Student> findAll() {
        String sql = "SELECT name, age, course FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    /** Update a row using composite condition (since no primary key) */
    public int updateCourse(String name, int age, String oldCourse, String newCourse) {
        String sql = "UPDATE student SET course = ? WHERE name = ? AND age = ? AND course = ?";
        return jdbcTemplate.update(sql, newCourse, name, age, oldCourse);
    }

    /** Delete a row using composite condition */
    public int delete(String name, int age, String course) {
        String sql = "DELETE FROM student WHERE name = ? AND age = ? AND course = ?";
        return jdbcTemplate.update(sql, name, age, course);
    }

    /** Optional: find by name (may return duplicates) */
    public List<Student> findByName(String name) {
        String sql = "SELECT name, age, course FROM student WHERE name = ?";
        return jdbcTemplate.query(sql, new StudentRowMapper(), name);
    }
}
