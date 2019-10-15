package tp.p1.logic.lists;
import tp.p1.logic.Level;
import tp.p1.logic.Move;
import tp.p1.logic.objects.DestroyerShip;


public class DestroyerShipList {
		private DestroyerShip [] destroyerList; 
		private int numDestroyer=0;
		private final int points=10;
		
		public DestroyerShipList(int n, Level level) {
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
		public int find(int row, int col) {
			int index = -1;
			int i = 0;
			while(i < this.numDestroyer && index != -1) {
				if(destroyerList[i].getRow()== row && destroyerList[i].getColumn() == col)
					index = i;
				i++;
			}
			return index;
		}
		
		public boolean destroyerhit(int rowl, int columnl) {
			int pos=this.find(rowl, columnl);
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
		
		public int getRow(int index) {
			return this.destroyerList[index].getRow();
		}
		
		public int getColumn(int index) {
			return this.destroyerList[index].getColumn();
		}

		public boolean hurt(int row, int col) {
		int i = this.find(row, col);
		if(i!= -1) {
			delete(i);
			return true;
		}
		else return false;
	}

		public void delete(int index) {
		if (this.destroyerList[index].getLife()==0) {
			for(int i = index; i < destroyerList.length - 1; i++) {
				destroyerList[i] = destroyerList[i + 1];
			}
		}
	}
		
		
}
