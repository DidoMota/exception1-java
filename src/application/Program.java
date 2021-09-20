package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room Number: ");
			Integer roomNumber = sc.nextInt();
			System.out.print("Check-in Date (dd/mm/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/mm/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/mm/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());	
			
			reservation.updateDates(checkin, checkout);
			System.out.println(reservation);
			
		} catch(ParseException e) {
			System.out.println("Invalid date format!");			
		} catch(DomainException e) {
			System.out.println(e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("unexpected error");
		}
	
		
		sc.close();
	}

}

/*
 * Esse programa ser� escrito de 3 formas, fazendo o tratamentod e exce��o de
 * uma maneira: muito ruim - l�gica de valida��o no programa principal ruim -
 * m�todo retornando String boa - tratamneto de exce��o
 * 
 * Esse commit � relacionado com a forma ruim
 */