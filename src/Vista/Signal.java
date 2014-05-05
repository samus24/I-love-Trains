package Vista;

public class Signal {
	int x, y;

	public Signal(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	public String toString() {
		return "Señal (" + x + "," + y + ")";
	}
}
