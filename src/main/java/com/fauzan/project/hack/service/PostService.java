package com.fauzan.project.hack.service;

import com.fauzan.project.hack.dao.PostDao;
import com.fauzan.project.hack.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */
@Service
public class PostService {
    private final PostDao postDao;

    @Autowired
    public PostService(@Qualifier("postgres") PostDao postDao) {
        this.postDao = postDao;
    }

    public int addPost(Post post){
        return postDao.insertPost(post);
    }

    public List<Post> getAllPost(){
        return postDao.selectAllPost();
    }

    public Optional<Post> getPostById(UUID id){
        return postDao.selectPostById(id);
    }

    public int deletePost(UUID id) {
        return postDao.deletePost(id);
    }

    public int updatePost(UUID id, Post updatedPost){
        return postDao.updatePost(id, updatedPost);
    }
}
