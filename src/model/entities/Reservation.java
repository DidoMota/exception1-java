package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	//constructors
	public Reservation() {		
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	
	//getters and setters
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	
	//methods
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();					// o método getTime() traz a data informada em milisegundos, ideal para fazer o cálculo
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);			// converte diff em milesegundos para dias
	}
	
	public String updateDates(Date checkin, Date checkout) {		
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		} 
		if (!checkout.after(checkin)) {
			return "Error in reservation: check-out date must be after checkin date";
		} 
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation: Room ");
		sb.append(roomNumber);
		sb.append(", check-in: ");
		sb.append(sdf.format(checkin));
		sb.append(", check-out: ");
		sb.append(sdf.format(checkout));
		sb.append(", ");
		sb.append(duration());
		sb.append(" nights");
		
		return sb.toString();		
	}
	

}
