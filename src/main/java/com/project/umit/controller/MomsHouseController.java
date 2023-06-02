package com.project.umit.controller;

import com.project.umit.dto.MomsHouseDto;
import com.project.umit.dto.Response;
import com.project.umit.service.MomsHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/moms-house")
@RequiredArgsConstructor
public class MomsHouseController {

    private final MomsHouseService momsHouseService;

    @PostMapping
    public Response addMomsHouse(@RequestBody Map<String, MomsHouseDto> momsHouseDtoMap) {
        momsHouseService.addMomsHouse(momsHouseDtoMap);
        return Response.ok();
    }

    @GetMapping("/all")
    public Page<MomsHouseDto> getAllMomsHouses(Pageable pageable) {
        return momsHouseService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public MomsHouseDto getById(@PathVariable("id") Long id) {
        return momsHouseService.getById(id);
    }
}
