package com.htest.htest.service;

import com.htest.htest.entity.SectorEntity;
import com.htest.htest.model.SectorData;
import com.htest.htest.model.SectorItem;
import com.htest.htest.repository.SectorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    public SectorData getSectorData() {
        List<SectorEntity> sectorEntities = sectorRepository.findAll();
        List<SectorItem> sectorItems = new ArrayList<>();

        sectorEntities.forEach(sectorEntity -> sectorItems.add(SectorItem.builder()
                .nodeName(sectorEntity.getNodeName())
                .nodeValue(sectorEntity.getNodeValue())
                .nodePath(sectorEntity.getNodePath())
                .build()));

        return SectorData.builder().sectorList(sectorItems).build();
    }
}
