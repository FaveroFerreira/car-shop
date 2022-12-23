package com.ambev.carshop.converter;

import com.ambev.carshop.dto.BrandDTO;
import com.ambev.carshop.entity.Brand;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BrandConverter {

    public static Brand toEntity(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setId(UUID.randomUUID());
        brand.setName(brandDTO.getName());
        return brand;
    }

}
