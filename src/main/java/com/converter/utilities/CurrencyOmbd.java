package com.converter.utilities;

public record CurrencyOmbd(String base_code,
                           String target_code,
                           double conversion_rate,
                           double conversion_result) {
}

