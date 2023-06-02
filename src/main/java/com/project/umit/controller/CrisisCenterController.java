package com.project.umit.controller;

import com.project.umit.dto.CrisisCenterDto;
import com.project.umit.dto.Response;
import com.project.umit.service.CrisisCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/crisis-center")
@RequiredArgsConstructor
public class CrisisCenterController {

    private final CrisisCenterService crisisCenterService;

    @PostMapping
    public Response addCenter(@RequestBody Map<String, CrisisCenterDto> centerDtoMap) {
        crisisCenterService.addCenter(centerDtoMap);
        return Response.ok();
    }

    @GetMapping("/all")
    public Page<CrisisCenterDto> getAllCrisisCenters(Pageable pageable) {
        return crisisCenterService.getCrisisCenters(pageable);
    }

    @GetMapping("/{id}")
    public CrisisCenterDto getById(@PathVariable("id") Long id) {
        return crisisCenterService.getById(id);
    }


}
