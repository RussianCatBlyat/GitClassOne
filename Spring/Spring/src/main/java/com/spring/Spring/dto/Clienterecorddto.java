package com.spring.Spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Clienterecorddto(@NotBlank@NotNull String cdempresa, @NotBlank String nmcliente) {
}
