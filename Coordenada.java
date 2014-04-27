package Entidad;

public class Coordenada {
	private int x;
	private int y;
	public Coordenada(int _x, int _y){
		x = _x;
		y = _y;
	}
	public String toString(){
		return "( "+ x +" , "+ y + " )";
	}
	public int getCordenadaX(){
		return x;
	}
	public int getCordenadaY(){
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	

}
