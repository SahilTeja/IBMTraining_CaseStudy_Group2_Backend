package com.ibm.entity;

public class EMIChart {
	
	private int add;
	private int subtract;
	private int mult;
	private int divide;
	

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}

	public int getSubtract() {
		return subtract;
	}

	public void setSubtract(int subtract) {
		this.subtract = subtract;
	}

	public int getMult() {
		return mult;
	}

	public void setMult(int mult) {
		this.mult = mult;
	}

	public int getDivide() {
		return divide;
	}

	public void setDivide(int divide) {
		this.divide = divide;
	}

	@Override
	public String toString() {
		return "EMIChart [add=" + add + ", subtract=" + subtract + ", mult=" + mult + ", divide=" + divide + "]";
	}

	
	
	

}
