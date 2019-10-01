package tp.p1.logic.lists;
import tp.p1.logic.objects.DestroyerShip;


public class DestroyerShipList {
		private DestroyerShip [] destroyerList; 
		private int numDestroyer=0;
		
		public void inilist(int n) {
			int rowIni=3, columnIni=6;
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
		
		public void addDestroyer(int fila,int columna) {
			destroyerList[numDestroyer]=new DestroyerShip();
			destroyerList[numDestroyer].iniRowColum(fila,columna);
			numDestroyer++;
		}
		
		//devolver� la posici�n si lo consigue, sino devuelve -1
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
		
		public int destroyerhit(int pos) {
			for(int i=pos;i<numDestroyer-1;i++) {
				destroyerList[i]=destroyerList[i+1];
			}
			numDestroyer--;
			return 0;
		}
		
		public int getNumDestroyer() {
			return numDestroyer;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return this.numDestroyer;
		}
		
		//NO SE ME OCURREN GETS...
}
