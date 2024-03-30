package dev.artsman.poc.car;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/cars")
@RestController
@RequiredArgsConstructor
class CarController {
	private final CarRepository repository;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	List<CarEntity> allPeople() {
		return repository.findAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/load")
	void load() {
		var newCar = CarEntity.builder()
			.manufacturer("Tesla")
			.model("Model S")
			.build();
		repository.save(newCar);
	}
}
