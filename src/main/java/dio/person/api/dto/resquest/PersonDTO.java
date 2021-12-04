package dio.person.api.dto.resquest;

import dio.person.api.entities.Person;
import dio.person.api.entities.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String lastName;

    @CPF
    @NotEmpty
    private String cpf;

    @NotEmpty
    private List<Phone> phones = new ArrayList<>();


    public Person toPerson() {
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        person.setCpf(this.cpf);
        person.setPhones(this.phones);
        return person;
    }
}
