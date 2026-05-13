package com.trabalho.faculdade.impacta.util;

import java.util.List;

public record PageResponse<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean first,
        boolean last
) {
    public boolean isEmpty() {
        return content.isEmpty();
    }
}
