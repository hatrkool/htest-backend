package com.htest.htest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SectorItem {
    String nodeName;
    String nodePath;
    Integer nodeValue;
}
