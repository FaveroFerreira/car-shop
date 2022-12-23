package com.ambev.carshop.controller;

import com.ambev.carshop.dto.BrandDTO;
import com.ambev.carshop.entity.Brand;
import com.ambev.carshop.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class BrandController {

    public static final String BASE_URL = "/brand";
    public static final String GET_BY_ID_URL = BASE_URL + "/{id}";

    private final BrandService brandService;

    @PostMapping(BASE_URL)
    public Brand createBrand(@RequestBody @Valid BrandDTO brandDTO) {
        return brandService.createBrand(brandDTO);
    }

    @GetMapping(GET_BY_ID_URL)
    public Brand findBrandById(@PathVariable UUID id) {
        return brandService.findBrandById(id);
    }

}
