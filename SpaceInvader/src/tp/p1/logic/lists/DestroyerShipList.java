package tp.p1.logic.lists;
import tp.p1.logic.Level;
import tp.p1.logic.Move;
import tp.p1.logic.objects.DestroyerShip;


public class DestroyerShipList {//hay que hacer el comando move, no se como verificar si estan en el borde, igual con regular
		private DestroyerShip [] destroyerList; 
		private int numDestroyer=0;
		private final int points=10;
		
		public DestroyerShipList(int n, Level level) {//mejor el nivel
			int rowIni=3, columnIni=6;
			destroyerList= new DestroyerShip[n];
			if(level==Level.HARD |level==Level.INSANE) {rowIni++;}
			for(int i=0;i<n;i++) {
				addDestroyer(rowIni,columnIni);
				if(columnIni==7) {
					rowIni++;
					columnIni=6;
				}
				else {
					columnIni++;
				}
			}
		}
		
		public int getPoints() {
			return points;
		}
		
		public void addDestroyer(int fila,int columna) {
			destroyerList[numDestroyer]=new DestroyerShip(fila, columna);
			numDestroyer++;
		}
		
		//devolveria la posicion si lo consigue, sino devuelve -1
		public int search(int rowS,int columnS) {
			int pos=0;
			boolean finded=false;
			while(!finded & pos<numDestroyer) {
				if(destroyerList[pos].getRow()==rowS && destroyerList[pos].getColumn()==columnS) {
					finded=true;
				}
				else pos++;
			}
			if (!finded) {pos=-1;}
			return pos;
		}
		
		public boolean destroyerhit(int rowl, int columnl) {
			int pos=this.search(rowl, columnl);
			boolean resul=pos!=1;
			if(resul) {
				for(int i=pos;i<numDestroyer-1;i++) {
					destroyerList[i]=destroyerList[i+1];
				}
				numDestroyer--;	
			}	
			return resul;
		}
		
		public int getNumDestroyer() {
			return numDestroyer;
		}

		public int getCount() {
			return this.numDestroyer;
		}
		
		public boolean isBorder() {
			int i=0;
			boolean resul=false;
			while(!resul & i<this.numDestroyer) {
				resul=this.destroyerList[i].getColumn()==0 |this.destroyerList[i].getColumn()==8;
			}
			
			return resul;
		}
		
		public void move(Move dir) {
			for(int i=0;i<this.numDestroyer;i++) {
				this.destroyerList[i].destroyermove(dir);
			}
		}
		
		
}
