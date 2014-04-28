package World.Exceptions;

@SuppressWarnings("serial")
public class WrongMapFormatException extends Exception{
	
	public WrongMapFormatException(){
		
	}
	
	public WrongMapFormatException(String msg){
		super(msg);
	}
	
}
