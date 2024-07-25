package com.navdeep.billsplitter.controller;

import com.navdeep.billsplitter.entity.GroupDetail;
import com.navdeep.billsplitter.service.GroupDetailService;
import com.navdeep.billsplitter.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final GroupDetailService groupDetailService;

    @GetMapping
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Ok Auth is working.");
    }

    @GetMapping("/groups")
    public List<String> grouplist(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return groupDetailService.groupList(username);
    }
}
