package com.aurel.lms.service;

import com.aurel.lms.model.Term;
import com.aurel.lms.service.dto.request.term.CreateTermRequest;
import com.aurel.lms.repository.TermRepository;
import com.aurel.lms.security.UserPrincipal;
import com.aurel.lms.service.dto.response.ARConstants;
import com.aurel.lms.service.dto.response.ApiResponse;
import com.aurel.lms.service.mapper.TermMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TermService {

    private TermRepository termRepository;
    private TermMapper termMapper;

    @Autowired
    public TermService(TermRepository termRepository, TermMapper termMapper) {
        this.termRepository = termRepository;
        this.termMapper = termMapper;
    }

    public ResponseEntity<?> newTerm(UserPrincipal principal, CreateTermRequest request){

        Term term = termMapper.createTermRequestToTerm(request);

        System.out.println(term);
        term = termRepository.save(term);


        Map<String, Term> map = new HashMap<>();
        map.put("term", term);

        return new ResponseEntity<>(new ApiResponse(ARConstants.success, map), HttpStatus.OK);
    }

}
