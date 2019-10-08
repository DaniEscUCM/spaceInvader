package tp.p1.logic.lists;
//blah

import tp.p1.logic.objects.Bomb;

public class BombList {
	private Bomb [] list;
	private int max;
	private double frec;
	private int count = 0;
	
	public BombList(double n, int maxn) {
		super();
		this.max = maxn;
		frec=n;
		this.count = 0;
		list = new Bomb[max];
	}
	
	public int getCount() {
		return count;
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
			list[list.length] = new Bomb(row,col);
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
		for(int i = index; i <count- 1; i++) {//con el lenght no va a funcionar cuando se empiecen a eleminar
			list[i] = list[i + 1];
		}
		count--;
	}
	
	
	public void move() {
		int i=0;
		while (i<count) {
			if(this.list[i].getRow()==8) {delete(i);}
			else {
				this.list[i].move();
				i++;
			}
		}
	}
	
}
