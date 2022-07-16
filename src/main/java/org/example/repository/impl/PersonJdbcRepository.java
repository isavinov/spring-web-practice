package org.example.repository.impl;

import org.example.domain.Person;
import org.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository
public class PersonJdbcRepository implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public Collection<Person> findAll() {
//        return jdbcTemplate.query("SELECT * FROM person",
//                (rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));
//    }

    @Override
    public Collection<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Person(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
            }
        });
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(first_name, last_name) VALUES (?,?)", person.getFirstName(),
                person.getLastName());
    }
}
