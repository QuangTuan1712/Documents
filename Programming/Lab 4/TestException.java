
public class TestException extends Exception {
    private String exc;
    TestException(String s){
        super(s);
        exc = s;
    }

    public String getExc() {
        return exc;
    }
}
