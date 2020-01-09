package com.aurel.lms.controller;

import com.aurel.lms.service.TermService;
import com.aurel.lms.service.dto.request.term.CreateTermRequest;
import com.aurel.lms.util.AppConstants;
import com.aurel.lms.validator.PageNumberAndSizeValidator;
import com.aurel.lms.validator.ValidNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/term")
public class TermController {

    TermService termService;

    @Autowired
    public TermController(TermService termService) {
        this.termService = termService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> postTerm(@Valid @RequestBody CreateTermRequest request){

        return termService.newTerm(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTerm(
            @PathVariable Integer id,
            @RequestParam(name = "page", required = false) int page,
            @RequestParam(name = "size", required = false) int size
        ){

        PageNumberAndSizeValidator.validate(page, size);

        return termService.getTerm(id);
    }

}
