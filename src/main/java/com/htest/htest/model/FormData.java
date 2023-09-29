package com.htest.htest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FormData {
    private String name;
    private int[] sectorSelection;
    private boolean agreeToTerms;
    private Integer sessionId;
}