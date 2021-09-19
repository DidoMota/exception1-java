package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		Integer roomNumber = sc.nextInt();
		System.out.print("Check-in Date (dd/mm/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out Date (dd/mm/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) { // verifica se a data de checkout é posterior a de checkin
			System.out.println("Error in reservation: check-out date must be after checkin date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/mm/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkin, checkout);
			if(error != null) {
				System.out.println(error);
			}else {
				System.out.println(reservation);
			}
			
			
		}

		sc.close();
	}

}

/*
 * Esse programa será escrito de 3 formas, fazendo o tratamentod e exceção de
 * uma maneira: muito ruim - lógica de validação no programa principal ruim -
 * método retornando String boa - tratamneto de exceção
 */