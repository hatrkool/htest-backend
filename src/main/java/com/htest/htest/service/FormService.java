package com.htest.htest.service;

import com.htest.htest.entity.FormEntity;
import com.htest.htest.model.FormData;
import com.htest.htest.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    @Autowired
    FormRepository formRepository;

    public FormData saveFormData(FormData formData) {
        FormEntity formEntity = FormEntity.builder()
                .id(formData.getSessionId())
                .name(formData.getName())
                .sectorSelection(formData.getSectorSelection())
                .agreeToTerms(formData.isAgreeToTerms())
                .build();

        formEntity = formRepository.save(formEntity);
        formData.setSessionId(formEntity.getId());

        return formData;
    }
}
