package ps2.restapidb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class HospedeController {

	@Autowired
	private HospedeRepo disciplinaRepo;

	@GetMapping("/api/disciplinas")
	Iterable<Hospede> getDisciplinas() {
		return disciplinaRepo.findAll();
	}
	
	@GetMapping("/api/disciplinas/{id}")
	Optional<Hospede> getDisciplina(@PathVariable long id) {
		return disciplinaRepo.findById(id);
	}
	
	@PostMapping("/api/disciplinas")
	Hospede createDisciplina(@RequestBody Hospede d) {
		Hospede createdDis = disciplinaRepo.save(d);
		return createdDis;
	}
	
	@PutMapping("/api/disciplinas/{disciplinaId}")
	Optional<Hospede> updateDisciplina(@RequestBody Hospede disciplinaReq, @PathVariable long disciplinaId) {
		Optional<Hospede> opt = disciplinaRepo.findById(disciplinaId);
		if (opt.isPresent()) {
			if (disciplinaReq.getId() == disciplinaId) {
				disciplinaRepo.save(disciplinaReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da disciplina com id " + disciplinaId);
	}	
	
	@DeleteMapping("/api/disciplinas/{id}")
	void deleteDisciplina(@PathVariable long id) {
		disciplinaRepo.deleteById(id);
	}	
	
}