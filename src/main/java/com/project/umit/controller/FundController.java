package com.project.umit.controller;

import com.project.umit.dto.FundDto;
import com.project.umit.dto.Response;
import com.project.umit.service.FundService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/fund")
@RequiredArgsConstructor
public class FundController {

    private final FundService fundService;

    @PostMapping
    public Response addFund(@RequestBody Map<String, FundDto> fundDtoMap) {
        fundService.addFund(fundDtoMap);
        return Response.ok();
    }

    @GetMapping("/all")
    public Page<FundDto> getAllFunds(Pageable pageable) {
        return fundService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public FundDto getById(@PathVariable("id") Long id) {
        return fundService.getById(id);
    }

}
