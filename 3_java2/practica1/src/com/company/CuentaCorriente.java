package com.company;

public class CuentaCorriente {

	int m_saldo;

	public CuentaCorriente(int saldo) {
		m_saldo = saldo;
	}

	public CuentaCorriente(CuentaCorriente other) {
		m_saldo = other.getSaldo();
	}

	public int getSaldo() {
		return m_saldo;
	}

	public void setSaldo(int saldo) {
		m_saldo = saldo;
	}

	public void ingreso(int saldo) {
		m_saldo += saldo;
	}

	public void egreso(int saldo) {
		m_saldo -= saldo;
	}

	public void reintegro() {
		
	}

	public void transferencia() {

	}
}
