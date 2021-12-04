package dio.person.api.controllers;

import dio.person.api.dto.response.MessageResponseDTO;
import dio.person.api.dto.resquest.PersonDTO;
import dio.person.api.entities.Person;
import dio.person.api.exceptions.PersonNotFoundException;
import dio.person.api.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO)
            throws PersonNotFoundException {
        return personService.update(id, personDTO);
    }


    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.getById(id);
    }


}
