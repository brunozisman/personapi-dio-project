package com.bnz.personapi.service;

import com.bnz.personapi.dto.request.PersonDTO;
import com.bnz.personapi.dto.response.MessageResponseDTO;
import com.bnz.personapi.entity.Person;
import com.bnz.personapi.dto.mapper.PersonMapper;
import com.bnz.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }
}
