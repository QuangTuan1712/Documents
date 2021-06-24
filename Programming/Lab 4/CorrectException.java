
public class CorrectException extends Exception {
    private String exc;
    CorrectException(String s){
        super(s);
        exc = s;
    }

    public String getExc() {
        return exc;
    }
}
