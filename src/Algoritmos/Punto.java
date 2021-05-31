package Algoritmos;

import java.util.Comparator;

public class Punto implements Comparator<Punto> {
	double x;
	double y;

	public Punto(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Double getX() {
		return x;
	}
	public Double getY() {
		return y;
	}
	
	public void setX(Double x) {
		this.x=x;
	}
	public void setY(Double y) {
		this.y=y;	
	}
	
	public boolean equals(Object p) {
		boolean bool= (this.x== ((Punto) p).getX()&& this.y==((Punto)p).getY());
		return bool;
	}

	@Override
	public int compare(Punto o1, Punto o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	}
	
	

