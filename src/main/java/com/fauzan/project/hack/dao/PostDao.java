package com.fauzan.project.hack.dao;

import com.fauzan.project.hack.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */

public interface PostDao {
    int insertPost(UUID id, Post post);

    default int insertPost(Post post){
        UUID id = UUID.randomUUID();
        return insertPost(id, post);
    }

    List<Post> selectAllPost();

    Optional<Post> selectPostById(UUID id);

    int deletePost(UUID id);

    int updatePost(UUID id, Post post);
}
