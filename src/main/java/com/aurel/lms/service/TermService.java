package com.aurel.lms.service;

import com.aurel.lms.service.dto.request.term.CreateTermRequest;
import com.aurel.lms.repository.TermRepository;
import com.aurel.lms.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TermService {

    private TermRepository termRepository;

    @Autowired
    public TermService(TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    public ResponseEntity<?> newTerm(UserPrincipal principal, CreateTermRequest request){


        return null;
    }

}
