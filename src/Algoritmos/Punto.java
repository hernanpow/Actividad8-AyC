package Algoritmos;

public class Punto {
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
	
}
