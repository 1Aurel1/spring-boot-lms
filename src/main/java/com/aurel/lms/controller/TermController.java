package com.aurel.lms.controller;

import com.aurel.lms.service.dto.request.term.CreateTermRequest;
import com.aurel.lms.security.UserPrincipal;
import com.aurel.lms.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/term")
public class TermController {

    TermService termService;

    @Autowired
    public TermController(TermService termService) {
        this.termService = termService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> postTerm(@AuthenticationPrincipal UserPrincipal principal, @RequestBody CreateTermRequest request){

        return termService.newTerm(principal, request);
    }
}
