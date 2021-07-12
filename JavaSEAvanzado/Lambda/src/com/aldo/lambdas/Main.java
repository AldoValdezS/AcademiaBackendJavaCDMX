package com.aldo.lambdas;



public class Main {

	public static void main(String[] args) {
		
		OnOneListener oneListener = new OnOneListener() {
		
		@Override
		public void onOne(String message) {
			// TODO Auto-generated method stub
			System.out.println("One: "+message);
			}
		};
				
		OnOneListener oneListener2 = (String message)->{
			System.out.println("One: "+message);
		};
		oneListener.onOne("Sin lambda");
		oneListener2.onOne("Con lambda");
		
		OnOneListener oneListener3 = message -> System.out.println("Tu mensaje "+ message);
		
				
		}
}