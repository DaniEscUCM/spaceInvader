package tp.p1.logic.lists;

import tp.p1.logic.Level;
import tp.p1.logic.Move;
import tp.p1.logic.objects.Bomb;
import tp.p1.logic.objects.DestroyerShip;

public class DestroyerShipList {
	private DestroyerShip [] destroyerList; 
	private int numDestroyer=0;
	private final int points=10;
	
	public DestroyerShipList(int n, Level level) {
		int rowIni=2, columnIni=6;
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
		//destroyerList[numDestroyer]=new DestroyerShip(fila, columna);
		numDestroyer++;
	}
	
	public int find(int row, int col) {
		int index = -1;
		int i = 0;
		while(i < this.numDestroyer && index == -1) {
			if(destroyerList[i].getRow()== row && destroyerList[i].getColumn() == col) {
				index = i;					
			}
			i++;
		}
		return index;
	}
	
	public boolean destroyerhit(int rowl, int columnl) {
		int pos=this.find(rowl, columnl);
		boolean resul=pos!=-1;
		if(resul) {
			for(int i=pos;i<numDestroyer-1;i++) {
				destroyerList[i]=destroyerList[i+1];
			}
			numDestroyer--;	
		}	
		return resul;
	}
	
	public int getCount() {
		return numDestroyer;
	}
	
	public boolean isBorder(boolean right) {
		int i=0;
		boolean resul=false;
		while(!resul & i<this.numDestroyer) {
			resul=(this.destroyerList[i].getColumn()==0 && !right) ||(this.destroyerList[i].getColumn()==8 && right);
			i++;
		}			
		return resul;
	}
	
	public void move(Move dir) {
		for(int i=0;i<this.numDestroyer;i++) {
			this.destroyerList[i].move(dir);
		}
	}
	
	public int getRow(int index) {
		return this.destroyerList[index].getRow();
	}
	
	public int getColumn(int index) {
		return this.destroyerList[index].getColumn();
	}
	
	public String toString(int pos) {
		return this.destroyerList[pos].toString();
	}
	//DestroyerShip getShip
	
	public void destroyBomb(Bomb bomb) {//quitar?
		int pos=0;
		boolean enc=false;
		while(pos<this.numDestroyer && !enc) {//eliminar bomba ==
			if (!this.destroyerList[pos].getCanShoot() /*&& this.equalsBomb(bomb, pos)*/ ) {enc =true;this.destroyerList[pos].enableBomb();}
			else {pos++;}
		}
	}
	/*
	private boolean equalsBomb(Bomb bomb, int pos) {
		return this.destroyerList[pos].equalsbomb(bomb);
	}*/

	public int shockwave() {
		int i = 0, resul=this.numDestroyer*this.points;
		while(i < this.numDestroyer) {
			this.destroyerList[i].hurt();
			if(this.destroyerList[i].getLife() == 0){
				for(int j=i;j<numDestroyer - 1;j++) {
					destroyerList[j]=destroyerList[j + 1];	
				}
				numDestroyer--;	
			}
			else i++;
		}
		return resul;		
	}
	
	public DestroyerShip getShip(int i) {
		return this.destroyerList[i];
	}

}
