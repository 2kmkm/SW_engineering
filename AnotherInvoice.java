package com.example.java.refactoring.invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class AnotherInvoice {
	private MyCollection _orders;
	private String _name;
	
	private Printer _printer;
	
	public AnotherInvoice(String customer_name, MyCollection orders, Printer printer) {
		this._orders = orders;
		this._name = customer_name;
		
		this._printer = printer;
	}
	
	void printOwing() {
		Enumeration<Order> e = _orders.elements();
		double outstanding = 0.0;
		int count = 0;
		
		// print banner
		_printer.print("*************************");
		_printer.print("***** Customer Owes *****");
		_printer.print("*************************");
		
		// calculate outstanding
		while (e.hasMoreElements()) {
			Order each = e.nextElement();
			outstanding += each.getAmount();
			count += 1;
		}
		
		// print details
		_printer.print("name: " + _name);
		_printer.print("amount: " + outstanding);
		_printer.print("count: " + count);
	}
	
	public static void main(String[] args) {
		ArrayList<Order> arrList = new ArrayList<Order>();
		arrList.add(new Order(4.5));
		arrList.add(new Order(1.3));
		arrList.add(new Order(9.7));
		
		AnotherInvoice invoice = 
				new AnotherInvoice(
						"Hong gil dong", 
						new MyCollection(Collections.enumeration(arrList)), 
						new Printer() { 
							public void print(String msg) { 
								System.out.println(msg);
							}
						});
		
		invoice.printOwing();
	}
}
