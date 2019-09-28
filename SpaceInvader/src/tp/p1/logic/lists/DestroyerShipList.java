package tp.p1.logic.lists;
import tp.p1.logic.objects.DestroyerShip;

//update destroyer: ahi esta border y sus bombas
//los aliens ganan si han llegado a la ultima fila
//posicion inicial -> initgame

public class DestroyerShipList {
		private DestroyerShip [] destroyerList; 
		private int numDestroyer=0;
		
		public void inilista(int n) {
			//con n dado por level, longitud
		}
		
		public void addDestroyer(int fila,int columna) {
			destroyerList[numDestroyer]=new DestroyerShip();
			destroyerList[numDestroyer].iniFilaColum(fila,columna);
			numDestroyer++;
		}
		//luego hay que ver cómo se eliminan las naves, hay que hacer busqueda?
		public int destroyerhit() {
			numDestroyer--;
			return 0;
		}
		//se busca en la lista la posicion, si la vida es cero, se elimina
}
