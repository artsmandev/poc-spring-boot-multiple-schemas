package dev.artsman.poc.person;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/people")
@RestController
@RequiredArgsConstructor
class PersonController {
	private final PersonRepository repository;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	List<PersonEntity> allPeople() {
		return repository.findAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/load")
	void load() {
		var newPerson = PersonEntity.builder()
			.birthday(LocalDate.of(1990, Month.APRIL, 19))
			.firstName("Bruno")
			.lastName("Andrade")
			.build();
		repository.save(newPerson);
	}
}
