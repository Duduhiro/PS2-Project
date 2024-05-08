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
public class ReservaController {

	@Autowired
	private ReservaRepo reservaRepo;

	@GetMapping("/api/reservas")
	Iterable<Reserva> getReservas() {
		return reservaRepo.findAll();
	}
	
	@GetMapping("/api/reservas/{id}")
	Optional<Reserva> getReserva(@PathVariable long id) {
		return reservaRepo.findById(id);
	}
	
	@PostMapping("/api/reservas")
	Reserva createReserva(@RequestBody Reserva r) {
		Reserva createdRes = reservaRepo.save(r);
		return createdRes;
	}
	
	@PutMapping("/api/reservas/{reservaId}")
	Optional<Reserva> updateReserva(@RequestBody Reserva reservaReq, @PathVariable long reservaId) {
		Optional<Reserva> opt = reservaRepo.findById(reservaId);
		if (opt.isPresent()) {
			if (reservaReq.getId() == reservaId) {
				reservaRepo.save(reservaReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da reserva com id " + reservaId);
	}	
	
	@DeleteMapping("/api/reservas/{id}")
	void deleteReserva(@PathVariable long id) {
		reservaRepo.deleteById(id);
	}	
	
}