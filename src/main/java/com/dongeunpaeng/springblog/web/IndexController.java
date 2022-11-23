package com.dongeunpaeng.springblog.web;

import com.dongeunpaeng.springblog.config.auth.LoginUser;
import com.dongeunpaeng.springblog.config.auth.dto.SessionUser;
import com.dongeunpaeng.springblog.service.posts.PostsService;
import com.dongeunpaeng.springblog.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(Model model, @PathVariable Long id) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null)
            model.addAttribute("userName", user.getName());
        return "index";
    }
}
