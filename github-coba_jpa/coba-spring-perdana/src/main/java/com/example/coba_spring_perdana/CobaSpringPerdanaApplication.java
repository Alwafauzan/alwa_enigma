package com.example.coba_spring_perdana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

class car {
	private String name;
	private String color;
	private engine engine;

	public car() {
	}

	public car(String name, String color, engine engine) {
		this.name = name;
		this.color = color;
		this.engine = engine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public engine getEngine() {
		return engine;
	}

	@Override
	public String toString() {
		return "car [name=" + name + ", color=" + color + ", engine=" + (engine == null ? "null" : engine.toString())
				+ "]";
	}

	public void setEngineType(int type) {
		switch (type) {
			case 1:
				this.engine = new engine(1, 0, 0);
				break;
			case 2:
				this.engine = new engine(0, 1, 0);
				break;
			case 3:
				this.engine = new engine(0, 0, 1);
				break;
			default:
				this.engine = new engine(0, 0, 0);
				break;
		}
	}

}

class engine {
	private int electrical;
	private int gasoline;
	private int diesel;

	public engine() {
	}

	public engine(int electrical, int gasoline, int diesel) {
		this.electrical = electrical;
		this.gasoline = gasoline;
		this.diesel = diesel;
	}

	public int getElectrical() {
		return electrical;
	}

	public void setElectrical(int electrical) {
		this.electrical = electrical;
	}

	public int getGasoline() {
		return gasoline;
	}

	public void setGasoline(int gasoline) {
		this.gasoline = gasoline;
	}

	public int getDiesel() {
		return diesel;
	}

	public void setDiesel(int diesel) {
		this.diesel = diesel;
	}

	@Override
	public String toString() {
		return "engine [electrical=" + electrical + ", gasoline=" + gasoline + ", diesel=" + diesel + "]";
	}

}

@SpringBootApplication
public class CobaSpringPerdanaApplication {

	@Autowired
	private car car;

	public static void main(String[] args) {

		String name = System.console().readLine("inputkan nama : ");
		int engineType = Integer
				.parseInt(System.console().readLine("inputkan jenis mesin [1.electrical, 2.gasoline, 3.diesel] : "));

		car Car = new car(name, "pink pastel", null);
		Car.setEngineType(engineType);
		System.out.println(Car);

	}

}
