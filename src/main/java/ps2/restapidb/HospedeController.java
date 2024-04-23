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
	private HospedeRepo hospedeRepo;

	@GetMapping("/api/hospedes")
	Iterable<Hospede> getHospedes() {
		return hospedeRepo.findAll();
	}
	
	@GetMapping("/api/hospedes/{id}")
	Optional<Hospede> getHospede(@PathVariable long id) {
		return hospedeRepo.findById(id);
	}
	
	@PostMapping("/api/hospedes")
	Hospede createHospede(@RequestBody Hospede d) {
		Hospede createdHos = hospedeRepo.save(d);
		return createdHos;
	}
	
	@PutMapping("/api/hospedes/{hospedeId}")
	Optional<Hospede> updateHospede(@RequestBody Hospede hospedeReq, @PathVariable long hospedeId) {
		Optional<Hospede> opt = hospedeRepo.findById(hospedeId);
		if (opt.isPresent()) {
			if (hospedeReq.getId() == hospedeId) {
				hospedeRepo.save(hospedeReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do hóspede com id " + hospedeId);
	}	
	
	@DeleteMapping("/api/hospedes/{id}")
	void deleteHospede(@PathVariable long id) {
		hospedeRepo.deleteById(id);
	}	
	
}