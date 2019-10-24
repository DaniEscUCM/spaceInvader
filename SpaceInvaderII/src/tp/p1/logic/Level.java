package tp.p1.logic;
//da el tamaño de la lista
//probabilidad
//velocidad

public enum Level {
	
	EASY, HARD, INSANE;
	
	public int getNumRegular() {
		int num;
		
		if(this==EASY) {num= 4;}
		else if(this ==HARD ||this==INSANE) {num=8;}
		else{num=0;}
		
		return num;
	}
	
	public int getNumDestroyers() {
		int num;
		
		if(this==EASY ||this ==HARD) {num= 2;}
		else if(this==INSANE) {num=4;}
		else{num=0;}
		
		return num;
	}
	
	public double getFrecShoot() {
		double num;
		
		if(this==EASY) {num= 0.1;}
		else if(this ==HARD) {num=0.3;}
		else if(this==INSANE) {num=0.5;}
		else {num=0;}
		
		return num;
	}
	
	public int getSpeed() {
		int num;
		if(this==EASY) {num= 3;}
		else if(this ==HARD) {num=2;}
		else if(this==INSANE) {num=1;}
		else{num=0;}
		
		return num;
	}
	
	public double getOvniProb() {
		double num;
		if(this==EASY) {num= 0.5;}
		else if(this ==HARD) {num=0.2;}
		else if(this==INSANE) {num=0.1;}
		else{num=0;}
		
		return num;
	}
		
	

}
