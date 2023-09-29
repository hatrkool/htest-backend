package com.htest.htest.service;

import com.htest.htest.entity.FormEntity;
import com.htest.htest.model.FormData;
import com.htest.htest.repository.FormRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FormServiceTest {
    @InjectMocks
    private FormService formService;
    @Mock
    private FormRepository formRepository;

    @Test
    public void testSaveFormData_ShouldSaveFormDataToRepositoryAndReturnUpdatedFormData() {
        FormData formDataIn = FormData.builder()
                .name("test")
                .sectorSelection(new int[]{1, 2})
                .agreeToTerms(true)
                .build();
        FormData formDataOutExpected = FormData.builder()
                .name("test")
                .sectorSelection(new int[]{1, 2})
                .agreeToTerms(true)
                .sessionId(1)
                .build();
        FormEntity formEntityIn = FormEntity.builder()
                .name("test")
                .sectorSelection(new int[]{1, 2})
                .agreeToTerms(true)
                .build();
        FormEntity formEntityOut = FormEntity.builder()
                .id(1)
                .name("test")
                .sectorSelection(new int[]{1, 2})
                .agreeToTerms(true)
                .build();
        Mockito.when(formRepository.save(formEntityIn)).thenReturn(formEntityOut);

        FormData formDataOut = formService.saveFormData(formDataIn);

        assertEquals(formDataOutExpected,formDataOut);
    }
}