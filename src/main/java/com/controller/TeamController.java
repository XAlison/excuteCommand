package com.controller;


import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
}


