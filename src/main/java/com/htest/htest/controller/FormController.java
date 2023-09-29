package com.htest.htest.controller;

import com.htest.htest.model.FormData;
import com.htest.htest.model.SectorData;
import com.htest.htest.service.FormService;
import com.htest.htest.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/form")
@CrossOrigin(origins = "http://localhost:4200")
public class FormController {
    @Autowired
    private SectorService sectorService;
    @Autowired
    FormService formService;

    @ModelAttribute("selectionData")
    public SectorData getSelectionData() {
        return sectorService.getSectorData();
    }

    @GetMapping("/data")
    public ResponseEntity<SectorData> getFormData(@ModelAttribute("selectionData") SectorData sectorData) {
        return ResponseEntity.ok(sectorData);
    }

    @PostMapping("/submit")
    public ResponseEntity<FormData> processForm(@RequestBody FormData formData) {
        return ResponseEntity.ok(formService.saveFormData(formData));
    }
}