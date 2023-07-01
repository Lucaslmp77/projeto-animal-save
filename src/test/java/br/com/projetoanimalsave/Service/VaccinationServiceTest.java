package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Vaccination;
import br.com.projetoanimalsave.Repository.VaccinationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VaccinationServiceTest {
    @Mock
    private VaccinationRepository vaccinationRepository;

    @InjectMocks
    private VaccinationService vaccinationService;

    @Captor
    private ArgumentCaptor<Vaccination> vaccinationCaptor;

    public VaccinationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_ShouldReturnSavedVaccination() {
        Vaccination vaccination = new Vaccination();
        when(vaccinationRepository.save(vaccination)).thenReturn(vaccination);

        Vaccination result = vaccinationService.save(vaccination);

        Assertions.assertEquals(vaccination, result);
        verify(vaccinationRepository, times(1)).save(vaccination);
    }

    @Test
    void listAll_ShouldReturnAllVaccinations() {
        List<Vaccination> vaccinationList = new ArrayList<>();
        when(vaccinationRepository.findAll()).thenReturn(vaccinationList);

        List<Vaccination> result = vaccinationService.listAll();

        Assertions.assertEquals(vaccinationList, result);
        verify(vaccinationRepository, times(1)).findAll();
    }

    @Test
    void findById_ShouldReturnVaccination_WhenVaccinationExists() {
        Long vaccinationId = 1L;
        Vaccination vaccination = new Vaccination();
        when(vaccinationRepository.findById(vaccinationId)).thenReturn(Optional.of(vaccination));

        Vaccination result = vaccinationService.findById(vaccinationId);

        Assertions.assertEquals(vaccination, result);
        verify(vaccinationRepository, times(1)).findById(vaccinationId);
    }

    @Test
    void findById_ShouldReturnNewVaccination_WhenVaccinationDoesNotExist() {
        Long vaccinationId = 1L;
        when(vaccinationRepository.findById(vaccinationId)).thenReturn(Optional.empty());

        Vaccination result = vaccinationService.findById(vaccinationId);

        Assertions.assertNotNull(result);
        verify(vaccinationRepository, times(1)).findById(vaccinationId);
    }

    @Test
    void update_ShouldUpdateVaccination_WhenVaccinationIdMatches() {
        Long vaccinationId = 1L;
        Vaccination vaccination = new Vaccination();
        vaccination.setId(vaccinationId);
        when(vaccinationRepository.save(any(Vaccination.class))).thenReturn(vaccination);

        vaccinationService.update(vaccination, vaccinationId);

        verify(vaccinationRepository, times(1)).save(vaccinationCaptor.capture());
        Vaccination updatedVaccination = vaccinationCaptor.getValue();
        Assertions.assertEquals(vaccination, updatedVaccination);
    }

    @Test
    void update_ShouldThrowRuntimeException_WhenVaccinationIdDoesNotMatch() {
        Long vaccinationId = 1L;
        Vaccination vaccination = new Vaccination();
        vaccination.setId(2L);

        Assertions.assertThrows(RuntimeException.class, () -> vaccinationService.update(vaccination, vaccinationId));
        verify(vaccinationRepository, never()).save(any(Vaccination.class));
    }

    @Test
    void disable_ShouldDisableVaccination_WhenVaccinationIdMatches() {
        Long vaccinationId = 1L;
        Vaccination vaccination = new Vaccination();
        vaccination.setId(vaccinationId);
        when(vaccinationRepository.findById(vaccinationId)).thenReturn(Optional.of(vaccination));

        vaccinationService.disable(vaccinationId);

        verify(vaccinationRepository, times(1)).findById(vaccinationId);
        verify(vaccinationRepository, times(1)).disable(vaccinationId);
    }

    @Test
    void disable_ShouldThrowRuntimeException_WhenVaccinationIdDoesNotMatch() {
        Long vaccinationId = 1L;
        Vaccination vaccination = new Vaccination();
        vaccination.setId(2L);
        when(vaccinationRepository.findById(vaccinationId)).thenReturn(Optional.of(vaccination));

        Assertions.assertThrows(RuntimeException.class, () -> vaccinationService.disable(vaccinationId));
        verify(vaccinationRepository, times(1)).findById(vaccinationId);
        verify(vaccinationRepository, never()).disable(anyLong());
    }
}
