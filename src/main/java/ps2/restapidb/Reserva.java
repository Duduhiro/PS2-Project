package ps2.restapidb;

import javax.persistence.*;

@Entity
@Table(name="reservas")
public class Reserva {
	@Id @GeneratedValue
	private long id;
	private String dataCheckIn;
	private String dataCheckOut;
	private double valorReserva;
	private long id_hospede;
		
	public Reserva() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setDataCheckIn(String dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	public String getDataCheckIn() {
		return dataCheckIn;
	}
	public void setDataCheckOut(String dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}
	public String getDataCheckOut() {
		return dataCheckOut;
	}
	public void setId_hospede(long id_hospede) {
		this.id_hospede = id_hospede;
	}
	public long getId_hospede() {
		return id_hospede;
	}
	public void setValorReserva(double valorReserva) {
		this.valorReserva = valorReserva;
	}
	public double getValorReserva() {
		return valorReserva;
	}

}