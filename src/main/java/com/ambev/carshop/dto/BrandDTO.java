package com.ambev.carshop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BrandDTO {

    @NotBlank(message = "{brand.name.required}")
    private String name;

}
