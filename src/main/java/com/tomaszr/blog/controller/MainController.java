package com.tomaszr.blog.controller;

import com.tomaszr.blog.model.entities.Post;
import com.tomaszr.blog.model.entities.PostComment;
import com.tomaszr.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public String postPage(Model model) {
        List<Post> postList = new ArrayList<>();

        Iterable<Post> postIterable = postRepository.findAll();

        for (Post post : postIterable) {
            postList.add(post);
        }

        model.addAttribute("posts", postList);
        return "posts";
    }

    @PostMapping("/addPost")
//    @ResponseBody
    public String addPost(@RequestParam(value = "title") String titleParam,
                          @RequestParam(value = "content") String content) {
        Post post = new Post(titleParam, content);
        PostComment postComment = new PostComment();
        postComment.setComment(titleParam);

        post.addComment(postComment);
        postRepository.save(post);

//        return "index";
        return "addPost";
    }
    @GetMapping("/addPost")
    public String addPost(){

        return "addPost"; // taka templatka html
    }

    @GetMapping("/post/{postId}")
    public String post(@PathVariable Long postId, Model model) {
        Optional<Post> postOptional=postRepository.findById(postId);
        postOptional.ifPresent(post ->{
            model.addAttribute("post",post);
        });
        return "post";
    }

    @GetMapping("/delete/{postId}")
    @ResponseBody
    public String delete(@PathVariable Long postId, Model model) {
        postRepository.deleteById(postId);

        return ("Usunieto: "+postId);
    }

    @PostMapping("/post/addComment")
    public String addComment(@RequestParam String commentBody,@RequestParam Long postId){
        PostComment postComment=new PostComment();
        postComment.setComment(commentBody);

        Optional<Post> postOptional=postRepository.findById(postId);

        postOptional.ifPresent(post->{
            post.addComment(postComment);
            postRepository.save(post);
        });

        return ("redirect:/post/"+postId);

    }

}
