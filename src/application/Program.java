package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("enter the number of tax payers: ");
		int n = sc.nextInt();
		
		int i = 0;
		for (i=0; i<n; i++) {
			System.out.println("tax payer #" + (i + 1) + " data: ");
			System.out.print("individual or company (i/c)? ");
			char ic = sc.next().charAt(0);
			System.out.print("name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("anual income: ");
			double anualIncome = sc.nextDouble();
			if(ic == 'i') {
				System.out.print("health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.print("number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
			
			double sum = 0;
			System.out.println();
			System.out.println("taxes paid: ");
			for (TaxPayer tp : list) {
				double tax = tp.tax();
				System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
				sum += tax;
			}
			
			System.out.println();
			System.out.println("total taxes: $ " + String.format("%.2f", sum));
		}
		
		sc.close();
	}
}
