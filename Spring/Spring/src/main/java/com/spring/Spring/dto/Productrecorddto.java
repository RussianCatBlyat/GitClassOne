package com.spring.Spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record Productrecorddto(@NotBlank String nmproduto, @NotNull BigDecimal vlproduto) {

}
