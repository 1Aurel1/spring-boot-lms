package com.aurel.lms.service;

import com.aurel.lms.exeption.BadRequestException;
import com.aurel.lms.exeption.ResourceNotFoundException;
import com.aurel.lms.model.Term;
import com.aurel.lms.service.dto.request.term.CreateTermRequest;
import com.aurel.lms.repository.TermRepository;
import com.aurel.lms.security.UserPrincipal;
import com.aurel.lms.service.dto.response.ARConstants;
import com.aurel.lms.service.dto.response.ApiResponse;
import com.aurel.lms.service.dto.response.TermDTO;
import com.aurel.lms.service.mapper.TermMapper;
import com.aurel.lms.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    public ResponseEntity<?> newTerm(CreateTermRequest request){

        Term term = termMapper.createTermRequestToTerm(request);

        System.out.println(term);
        term = termRepository.save(term);

        Map<String, Term> map = new HashMap<>();
        map.put("term", term);

        return new ResponseEntity<>(new ApiResponse(ARConstants.success, map), HttpStatus.OK);
    }

    public ResponseEntity<?> getTerm(int id){

        Term term = termRepository.getById(id).orElseThrow(()->new ResourceNotFoundException("Term", "Id", id));

        Map<String, TermDTO> data = new HashMap<>();
        data.put("Term", new TermDTO(term));

        return new ResponseEntity<>(new ApiResponse(ARConstants.success, data), HttpStatus.OK);
    }

    public ResponseEntity<?> getAllTerms(int page, int size){


        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void validatePageNumberAndSize(int page, int size) {

        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size < 0) {
            throw new BadRequestException("Size number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}
