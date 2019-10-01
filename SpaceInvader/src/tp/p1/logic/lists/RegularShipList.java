package tp.p1.logic.lists;

import tp.p1.logic.objects.RegularShip;

public class RegularShipList {
	private RegularShip[] list;
	private int max;
	private int count;
	
	public RegularShipList(int n) {
		this.max = max;
		this.count = 0;
		list = new RegularShip[max];
	}
	public int find(int row, int col) {
		int index = -1;
		int i = 0;
		while(i < list.length && index != -1) {
			if(list[i].getRow()== row && list[i].getCol() == col)
				index = i;
			i++;
		}
		return index;
	}
	
	public boolean insert(int row, int col) {
		if (find(row,col) == -1) {
			list[list.length] = new RegularShip(row,col);
			count++;
			return true;
			}
		else {return false;
		}
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
	public int getCount() {
		// TODO Auto-generated method stub
		return this.count;
	}
	
	

}
