package com.example.rowmapper;



import com.example.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student()
                .setName(rs.getString("name"))
                .setAge(rs.getInt("age"))
                .setCourse(rs.getString("course"));
    }
}
