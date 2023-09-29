package com.htest.htest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sector")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SectorEntity {
    @Id
    @Column(name = "nodeid")
    Integer nodeId;
    @Column(name = "nodename")
    String nodeName;
    @Column(name = "path")
    String nodePath;
    @Column(name = "nodevalue")
    Integer nodeValue;
}
