package tp.p1.logic.lists;

import tp.p1.logic.objects.RegularShip;

public class RegularShipList {
	private RegularShip[] list;
	private int count=0;
	
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
		/*int index = find(row,col);
		 *if (index != -1){  // a lo mejor no hace falta comprobarlo si se da x hecho que existe
		 * for....
		 * */
		for(int i = index; i < list.length - 1; i++) {
			list[i] = list[i + 1];
		}
	}
	
	public boolean regularHit(int row, int col) {
		int pos=this.find(row, col);
		boolean resul=pos!=0;
		if(resul) {delete(pos);}
		return resul;
	}
	public int getCount() {
		return this.count;
	}
	
	

}
