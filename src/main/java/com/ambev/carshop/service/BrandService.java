package com.ambev.carshop.service;

import com.ambev.carshop.converter.BrandConverter;
import com.ambev.carshop.dto.BrandDTO;
import com.ambev.carshop.entity.Brand;
import com.ambev.carshop.exception.DomainItemNotFoundException;
import com.ambev.carshop.repository.BrandRepository;
import com.ambev.carshop.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public Brand createBrand(BrandDTO brandDTO) {
        final Brand brand = BrandConverter.toEntity(brandDTO);
        return brandRepository.save(brand);
    }

    public Brand findBrandById(UUID id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new DomainItemNotFoundException(ErrorMessage.BRAND_ID_NOT_FOUND, id.toString()));
    }
}
