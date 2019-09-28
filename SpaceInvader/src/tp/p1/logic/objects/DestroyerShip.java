package tp.p1.logic.objects;

public class DestroyerShip {
	private int vida=1, dir=-1;//quitando, va en move
	private int fila, columna, ciclo;
	private final int ptos=10;
	//el update inicializa con el tiempo en que se cambia y en 0 se mueve.
	//falta el to string
	//split(" ")...palabra a palabra?
	// showUsage() -> error
	public void destroyerDeath() {
		vida--;
	}
	public void iniFilaColum(int fil, int colum) {
		fila=fil;
		columna=colum;
	}
	
	public void destroyermove(boolean border) {
		if(border) {fila++;dir=-dir;}
		else columna+=dir;
	}
	
	public int getVida() {
		return vida;
	}
	
	public int getPtos() {
		return ptos;
	}
	public int getFila() {
		return fila;
	}
	public int getColumna() {
		return columna;
	}
	
}
