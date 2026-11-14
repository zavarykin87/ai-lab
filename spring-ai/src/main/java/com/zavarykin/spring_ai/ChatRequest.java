package com.zavarykin.spring_ai;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(@NotBlank String message) {
    // Record class for chat request with a non-blank
}
