package com.blitz.controller;

import com.blitz.controller.dto.PostsResponseDto;
import com.blitz.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;


}
