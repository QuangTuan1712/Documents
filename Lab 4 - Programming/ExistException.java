
public class ExistException extends NullPointerException {
    private String exc  = " not initialized";
    
    ExistException(){
        exc = "Not initialized entity";
    }
    ExistException(String s){
        super(s);
        exc = s + exc;
    }
    
    public String getExc() {
        return exc;
    }
}
