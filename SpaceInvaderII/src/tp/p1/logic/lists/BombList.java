package tp.p1.logic.lists;

import tp.p1.logic.objects.Bomb;

public class BombList {
	private Bomb [] list;
	private int max;
	private int count = 0;
	
	public BombList( int maxn) {
		super();
		this.max = maxn;
		this.count = 0;
		list = new Bomb[max];
	}
	
	public int getCount() {
		return count;
	}

	public int find(int row, int col) {
		int index = -1;
		int i = 0;
		while(i < this.count && index == -1) {
			if(list[i].getRow()== row && list[i].getCol() == col)
				index = i;
			i++;
		}
		return index;
	}
	
	public void insert(Bomb bomb) {
		list[count] = bomb;
		count++;
	}
		
	
	public void delete(int index) {
		for(int i = index; i <count- 1; i++) {
			list[i] = list[i + 1];
		}
		count--;
	}
	
	
	public void move(DestroyerShipList dlist) {
		int i=0;
		while (i<count) {
			if(this.list[i].move()) {i++;}
			else {
				dlist.destroyBomb(this.list[i]);
				delete(i);}
		}
	}
	
	public String toString(int pos) {
		return this.list[pos].toString();
	}
	
	public Bomb getBomb(int pos) {
		return this.list[pos];
	}

}
