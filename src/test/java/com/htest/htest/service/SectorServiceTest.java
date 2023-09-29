package com.htest.htest.service;

import com.htest.htest.entity.SectorEntity;
import com.htest.htest.model.SectorData;
import com.htest.htest.model.SectorItem;
import com.htest.htest.repository.SectorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SectorServiceTest {

    @InjectMocks
    SectorService sectorService;
    @Mock
    SectorRepository sectorRepository;

    @Test
    public void testGetSectorData_ShouldGetSectorData() {
        SectorEntity sectorEntity1 = SectorEntity.builder()
                .nodeId(1)
                .nodeName("node1")
                .nodeValue(1)
                .nodePath("/1/")
                .build();
        SectorEntity sectorEntity2 = SectorEntity.builder()
                .nodeId(2)
                .nodeName("node2")
                .nodeValue(2)
                .nodePath("/1/2/")
                .build();
        List<SectorEntity> sectorEntities = new ArrayList<>(Arrays.asList(sectorEntity1,sectorEntity2));

        SectorItem sectorItem1 = SectorItem.builder().nodeName("node1").nodeValue(1).nodePath("/1/").build();
        SectorItem sectorItem2 = SectorItem.builder().nodeName("node2").nodeValue(2).nodePath("/1/2/").build();
        SectorData sectorDataExpected = SectorData.builder()
                .sectorList(new ArrayList<>(Arrays.asList(sectorItem1,sectorItem2)))
                .build();
        Mockito.when(sectorRepository.findAll()).thenReturn(sectorEntities);

        SectorData sectorData = sectorService.getSectorData();

        assertEquals(sectorDataExpected,sectorData);
    }
}