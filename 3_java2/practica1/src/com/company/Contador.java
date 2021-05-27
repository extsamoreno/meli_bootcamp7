package com.company;

public class Contador {
	int m_counter;

	public Contador(int val) {
		m_counter = val;
	}

	public Contador(Contador other) {
		m_counter = other.getCounter();
	}

	public int getCounter() {
		return m_counter;
	}

	public void setCounter(int counter) {
		m_counter = counter;
	}

	public void increment() {
		m_counter++;
	}

	public void decrement() {
		m_counter--;
	}
}
