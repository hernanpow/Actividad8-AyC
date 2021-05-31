package Algoritmos;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ysinordenar {

	public static Par franjaCercanos(List<Punto> franja, double d) {
		Par resultado = new Par() ;
		resultado.setDistancia(d);
		
		for(int i=0 ; i< franja.size() ; ++i) {
			for(int j = i+1 ; j< franja.size() ; j++) {
				double Ycandidato=(franja.get(i).getY() - franja.get(i).getY());
				if (!(Ycandidato > d)) {					
					if (distancia(franja.get(i),franja.get(j))< resultado.distancia()) {
						resultado.setDistancia(distancia(franja.get(i),franja.get(j)));
						resultado.setP1(franja.get(i));
						resultado.setP2(franja.get(j));
					}
			}
				
		}
			
	}
		return resultado;
		
	}
	
	public static Par PuntosCercanos(List<Punto> l) {
		if (l.size()<=3) {
			return DistanciaEntreTodos.DistanciaEntreTodos(l);
		}
		double xFranja = l.get(l.size()/2).getX(); /*obtenemos el valor de X de nuestro punto medio para luego usarlo*/
		int mitad= l.size()/2;
		/*double xMedio= l.get(mitad).getX();*/
		List<Punto> lizquierda = new ArrayList<Punto>();
		List<Punto> lderecha= new ArrayList<Punto>();
		lizquierda = l.subList(0,l.size()/2); /*Hace una sublista de la mitad izquierda*/
		lderecha = l.subList(l.size()/2, l.size()); /*Hace sublista de mitad derecha*/
		
		Par ResIzq = AlgoritmoYsinordenar(lizquierda); /*aplicamos el algoritmo a la lista izquierda*/
		Par ResDer = AlgoritmoYsinordenar(lderecha);	/* aplicamos el algoritmo a la lista derecha*/
		/*Encontramos cual es el minimo de cada mitad*/
		double minimo = Double.min(ResIzq.distancia(), ResDer.distancia());
		List<Punto> franja = new LinkedList<Punto>();
		List<Punto> listaOrdenadaY = Yordenado(l); /*Ordenamos la lista respecto de Y*/
		
		for(int i= 0 ; i< l.size() ; i++) {
			if (Math.abs(listaOrdenadaY.get(i).getX() - xFranja) < minimo){
				franja.add(listaOrdenadaY.get(i));
			}
		}
		
		Par ResulFranja = null;
		if(franja.size()>1)
			ResulFranja = franjaCercanos(franja,minimo);
		if(ResulFranja!=null && ResulFranja.distancia()<minimo) {
			return ResulFranja;
		}
		else {
			if(ResDer.distancia()<ResIzq.distancia()) {
				return ResDer;
			}
			else {
				return ResIzq;
			}
		}
		
	}
		
	
	public static  List<Punto> Xordenado(List<Punto> l){
		Collections.sort(l,new Comparator<Punto>() {
			
			public int compare(Punto o1, Punto o2) {
			    return Double.compare(o1.getX(), o2.getX());
			}		
		});
		return l;
	}
	
	
	public static  List<Punto> Yordenado(List<Punto> l){
		Collections.sort(l,new Comparator<Punto>() {
			
			public int compare(Punto o1, Punto o2) {
			    return Double.compare(o1.getY(), o2.getY());
			}		
		});
		return l;
		
	
	}
	
	
	
	public static Par AlgoritmoYsinordenar(List<Punto> lista) {
		List<Punto> ordenadoporX = Xordenado(lista);
		return PuntosCercanos(ordenadoporX);
	}
	public static double Resultado(Par par) {
		return distancia(par.getP1(),par.getP2());
	}
	
	public static double distancia(Punto p1,Punto p2) {
		double dx = (p1.getX() - p2.getX()); 
		double dy = (p1.getY() - p2.getY());
		return Math.sqrt(dx*dx + dy*dy); 
		
	}
}
