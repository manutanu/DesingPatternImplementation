package com.businessgame;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Bank implements Serializable, Cloneable {

	private volatile static Bank bankInstance = null;
	private int bankStore;

	private Bank(int amout) throws Exception {
			if (bankInstance == null) {
				this.bankStore = amout;
				System.out.println("Created Bank Instance");
			} else {
				throw new Exception();
			}
	}

	public static Bank getBankInstance(int amount) throws Exception {
		if(bankInstance == null) {
			return new Bank(amount);
		}
		return bankInstance;
	}

	public int getBankStore() {
		return bankStore;
	}

	public void setBankStore(int bankStore) {
		this.bankStore = bankStore;
	}

	public void deductMoney(int money) {
		this.bankStore -= money;
	}

	public void addMoney(int money) {
		this.bankStore += money;
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println("We have already created instance");
		return bankInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
