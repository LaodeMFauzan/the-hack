package com.fauzan.project.hack.api;

import com.fauzan.project.hack.model.Post;
import com.fauzan.project.hack.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */
@RequestMapping("api/v1/post")
@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @GetMapping
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    @GetMapping(path = "{id}")
    public Post getPostById(@PathVariable("id") UUID id){
        return postService.getPostById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePostById(@PathVariable("id") UUID id){
        postService.deletePost(id);
    }

    @PutMapping(path = "{id}")
    public void updatePost(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Post updatedPost) {
        postService.updatePost(id, updatedPost);
    }

}
