package com.trabalho.faculdade.impacta.util;

import java.time.Instant;

public record ErrorResponse(String message, int statusCode, Instant timestamp) {
}
