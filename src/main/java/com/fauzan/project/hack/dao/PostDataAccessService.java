package com.fauzan.project.hack.dao;

import com.fauzan.project.hack.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 29/01/20
 */
@Repository("postgres")
public class PostDataAccessService implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    public PostDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPost(UUID id, Post post) {
        final String sql = "INSERT INTO post(id, author, title, content) VALUES (?,?,?,?)";
        return jdbcTemplate.update(
                sql,
                UUID.randomUUID(),
                post.getAuthor(),
                post.getTitle(),
                post.getContent());
    }

    @Override
    public List<Post> selectAllPost() {
        final String sql = "SELECT * FROM post";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("author");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            return new Post(id, name, title, content);
        });
    }

    @Override
    public Optional<Post> selectPostById(UUID id) {
        final String sql = "SELECT * FROM post WHERE id = ?";
        Post post = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    String name = resultSet.getString("name");
                    String title = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    return new Post(id, name, title, content);
                });
        return Optional.ofNullable(post);
    }

    @Override
    public int deletePost(UUID id) {
        final String sql = "DELETE FROM post WHERE id = ?";
        return jdbcTemplate.update(
                sql,
                id);
    }

    @Override
    public int updatePost(UUID id, Post post) {
        final String sql = "UPDATE post SET author = ?, title = ?, content = ? WHERE id = ?";
        return jdbcTemplate.update(
                sql,
                post.getAuthor(),
                post.getTitle(),
                post.getContent(),
                id);
    }
}
