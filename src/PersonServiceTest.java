import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PersonServiceTest {
    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    void testFindAll() {
        when(personRepository.findAll()).thenReturn(List.of(new Person()));

        List<Person> users = personService.findAll();
        assertEquals(1, users.size());
    }
    // Другие тесты
}
