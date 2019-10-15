package tp.p1.logic.lists;

import tp.p1.logic.Move;
import tp.p1.logic.objects.RegularShip;

public class RegularShipList {
	private RegularShip[] list;
	private int count=0;
	private int puntos = 5;
	
	public RegularShipList(int n) {
		int row=8, col=1;
		list = new RegularShip[n];
		for(int i=0;i<n;i++) {
			insert(row,col);
			row--;
			if(i==3) {//para los niveles hard e insane
				row=8;
				col=2;
			}
		}
	}
	
	public int getPoints() {
		return puntos;
	}
	
	public int find(int row, int col) {
		int index = -1;
		int i = 0;
		while(i < this.count && index != -1) {
			if(list[i].getRow()== row && list[i].getCol() == col)
				index = i;
			i++;
		}
		return index;
	}
	
	public void insert(int row, int col) {
		list[count] = new RegularShip(row,col);
		count++;
	}
		
	
	public void delete(int index) {
		if (this.list[index].getLife()==0) {
			for(int i = index; i < list.length - 1; i++) {
				list[i] = list[i + 1];
			}
		}
	}
	
	public boolean regularHit(int row, int col) {
		int pos=this.find(row, col);
		boolean resul=pos!=0;
		if(resul) {
			this.list[pos].hurt();
			this.delete(pos);
		}
		return resul;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public boolean isBorder() {
		int i=0;
		boolean resul=false;
		while(!resul & i<this.count) {
			resul=this.list[i].getCol()==0 |this.list[i].getCol()==8;
		}
		
		return resul;
	}
	
	public void move(Move dir) {
		for(int i=0;i<this.count;i++) {
			this.list[i].move(dir);
		}
	}

	public boolean hurt(int row, int col) {
		int i = this.find(row, col);
		if(i!= -1) {
			delete(i);
			return true;
		}
		else return false;
	}

}
