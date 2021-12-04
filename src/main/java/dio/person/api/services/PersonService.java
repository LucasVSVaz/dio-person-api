package dio.person.api.services;

import dio.person.api.dto.response.MessageResponseDTO;
import dio.person.api.dto.resquest.PersonDTO;
import dio.person.api.entities.Person;
import dio.person.api.exceptions.PersonNotFoundException;
import dio.person.api.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    @Transactional
    public MessageResponseDTO create(PersonDTO personDTO) {
        Person personSaved = personDTO.toPerson();
        personRepository.save(personSaved);
        return MessageResponseDTO
                .builder()
                .message("Person created with ID " + personSaved.getId())
                .build();
    }

    @Transactional
    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfIdExist(id);
        Person personSaved = personDTO.toPerson();
        personRepository.save(personSaved);
        return MessageResponseDTO
                .builder()
                .message("Person updated with ID " + personSaved.getId())
                .build();
    }


    @Transactional
    public void delete(Long id) throws PersonNotFoundException {
        verifyIfIdExist(id);
        personRepository.deleteById(id);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }


    private void verifyIfIdExist(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
