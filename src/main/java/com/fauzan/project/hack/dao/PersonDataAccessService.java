package com.fauzan.project.hack.dao;

import com.fauzan.project.hack.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 29/01/20
 */
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person(id, name) VALUES (?,?)";
        return jdbcTemplate.update(
                sql,
                UUID.randomUUID(), person.getName());
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT * FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
            return new Person(id, name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePerson(UUID id) {
        final String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(
                sql,
                id);
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        final String sql = "UPDATE person SET name = ? WHERE id = ?";
        return jdbcTemplate.update(
                sql,
                person.getName(),
                id);
    }
}
