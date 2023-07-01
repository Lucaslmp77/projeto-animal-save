package br.com.projetoanimalsave.Service;

import br.com.projetoanimalsave.Entity.Occurrence;
import br.com.projetoanimalsave.Repository.CaregiverRepository;
import br.com.projetoanimalsave.Repository.OccurrenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OccurrenceServiceTest {

    @Mock
    private OccurrenceRepository occurrenceRepository;

    @Mock
    private CaregiverRepository caregiverRepository;

    @InjectMocks
    private OccurrenceService occurrenceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveOccurrence() {
        Occurrence occurrence = new Occurrence();

        when(occurrenceRepository.save(occurrence)).thenReturn(occurrence);

        Occurrence savedOccurrence = occurrenceService.save(occurrence);

        assertNotNull(savedOccurrence);
        assertSame(occurrence, savedOccurrence);

        verify(occurrenceRepository, times(1)).save(occurrence);
    }

    @Test
    void testListAllOccurrences() {
        List<Occurrence> occurrenceList = new ArrayList<>();
        occurrenceList.add(new Occurrence());
        occurrenceList.add(new Occurrence());

        when(occurrenceRepository.findAll()).thenReturn(occurrenceList);

        List<Occurrence> result = occurrenceService.listAll();

        assertEquals(2, result.size());
        assertSame(occurrenceList, result);

        verify(occurrenceRepository, times(1)).findAll();
    }

    @Test
    void testFindOccurrenceById() {
        Long occurrenceId = 1L;
        Occurrence occurrence = new Occurrence();
        occurrence.setId(occurrenceId);

        when(occurrenceRepository.findById(occurrenceId)).thenReturn(Optional.of(occurrence));

        Occurrence result = occurrenceService.findById(occurrenceId);

        assertNotNull(result);
        assertSame(occurrence, result);
        assertEquals(occurrenceId, result.getId());

        verify(occurrenceRepository, times(1)).findById(occurrenceId);
    }

    @Test
    void testFindOccurrenceByIdNotFound() {
        Long occurrenceId = 1L;

        when(occurrenceRepository.findById(occurrenceId)).thenReturn(Optional.empty());

        Occurrence result = occurrenceService.findById(occurrenceId);

        assertNotNull(result);
        assertNull(result.getId());

        verify(occurrenceRepository, times(1)).findById(occurrenceId);
    }

    @Test
    void testUpdateOccurrence() {
        Long occurrenceId = 1L;
        Occurrence occurrence = new Occurrence();
        occurrence.setId(occurrenceId);

        when(occurrenceRepository.save(occurrence)).thenReturn(occurrence);

        occurrenceService.update(occurrence, occurrenceId);

        verify(occurrenceRepository, times(1)).save(occurrence);
    }

    @Test
    void testUpdateOccurrenceWithMismatchedId() {
        Long occurrenceId = 1L;
        Occurrence occurrence = new Occurrence();
        occurrence.setId(2L);

        assertThrows(RuntimeException.class, () -> occurrenceService.update(occurrence, occurrenceId));

        verify(occurrenceRepository, never()).save(any(Occurrence.class));
    }

    @Test
    void testDisableOccurrence() {
        Long occurrenceId = 1L;
        Occurrence occurrence = new Occurrence();
        occurrence.setId(occurrenceId);

        when(occurrenceRepository.findById(occurrenceId)).thenReturn(Optional.of(occurrence));

        occurrenceService.disable(occurrenceId);

        verify(occurrenceRepository, times(1)).findById(occurrenceId);
        verify(occurrenceRepository, times(1)).disable(occurrenceId);
    }

    @Test
    void testDisableOccurrenceWithMismatchedId() {
        Long occurrenceId = 1L;
        Occurrence occurrence = new Occurrence();
        occurrence.setId(2L);

        when(occurrenceRepository.findById(occurrenceId)).thenReturn(Optional.of(occurrence));

        assertThrows(RuntimeException.class, () -> occurrenceService.disable(occurrenceId));

        verify(occurrenceRepository, times(1)).findById(occurrenceId);
        verify(occurrenceRepository, never()).disable(anyLong());
    }

    @Test
    void testFindByOccurrenceActives() {
        List<Occurrence> activeOccurrences = new ArrayList<>();
        activeOccurrences.add(new Occurrence());
        activeOccurrences.add(new Occurrence());

        when(occurrenceRepository.findByOccurrenceActives()).thenReturn(activeOccurrences);

        List<Occurrence> result = occurrenceService.findByOccurrenceActives();

        assertEquals(2, result.size());
        assertSame(activeOccurrences, result);

        verify(occurrenceRepository, times(1)).findByOccurrenceActives();
    }

    @Test
    void testFindByOccurrenceInactives() {
        List<Occurrence> inactiveOccurrences = new ArrayList<>();
        inactiveOccurrences.add(new Occurrence());
        inactiveOccurrences.add(new Occurrence());

        when(occurrenceRepository.findByOccurrenceInactives()).thenReturn(inactiveOccurrences);

        List<Occurrence> result = occurrenceService.findByOccurrenceInactives();

        assertEquals(2, result.size());
        assertSame(inactiveOccurrences, result);

        verify(occurrenceRepository, times(1)).findByOccurrenceInactives();
    }
}
