package Algoritmos;

import java.util.ArrayList;
import java.util.List;

public class test {

	
	public static void main(String[] args) {
		
		List<Punto> lista = new ArrayList<Punto>( );
		
		lista.add(new Punto(1, 3));
		lista.add(new Punto(1,1));
		lista.add(new Punto(3, 3));
		lista.add(new Punto(4, 3));
		lista.add(new Punto(1, 6));
		lista.add(new Punto(5, 6));
		
		
		Par dist = Ysinordenar.AlgoritmoYsinordenar(lista);
		System.out.println("["+dist.getP1().getX()+","+dist.getP1().getY()+"]["+dist.getP2().getX()+","+dist.getP2().getY()+"]");
		double res= Ysinordenar.Resultado(dist);
		System.out.println(res);
	
	}
	
}
