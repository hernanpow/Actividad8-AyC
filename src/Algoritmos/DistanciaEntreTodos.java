package Algoritmos;

import java.util.List;

public class DistanciaEntreTodos {
	public static Par DistanciaEntreTodos(List<Punto> lista) {
		Par ParResultante= new Par();
			/*Caso que solo sean dos puntos en lista*/
		if(lista.size()==2) {
			ParResultante.setP1(lista.get(0));
			ParResultante.setP2(lista.get(1));
			/*Se calcula la distancia de los unicos dos puntos*/
			ParResultante.setDistancia(distancia(ParResultante.getP1(),ParResultante.getP2())); 
			return ParResultante;
		}
		
		/*Caso que sean mas de dos puntos en lista*/
		/*Elegimos maxValue porque se busca la menor*/
		ParResultante.setDistancia(Double.MAX_VALUE);
		
		for(int i=0 ; i<lista.size() ; i++) {
			for (int j=i+1 ; j<lista.size() ; j++) {
				double aux= distancia(lista.get(i),lista.get(j));
				if (ParResultante.distancia()>aux) {/*El primer caso siempre sera positivo por el MAXVALUE*/
					ParResultante.setDistancia(aux);
					ParResultante.setP1(lista.get(i));
					ParResultante.setP2(lista.get(j));
				}
			}
		}
		return ParResultante;
	}
	
	public static double distancia(Punto p1,Punto p2) {
		double dx = (p1.getX() - p2.getX()); 
		double dy = (p1.getY() - p2.getY());
		return Math.sqrt(dx*dx + dy*dy); 
		
	}
}
