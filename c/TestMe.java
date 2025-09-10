package c;

public class TestMe {
    
    private double value = Double.NaN;

    public TestMe(double v){
        System.out.println("Constructor called");
        value = v;
    }
    public TestMe(){
        System.out.println("Default constructor called");
        value = 999.99;
    }

    public double square() { 
        return value * value;
    }

    public void setValue(double v) {
        if (v >= 0) {
            value = v;
        } else {
            System.err.println("Error - must be non-negative.");
        }
    }
    public double getValue() {
        return value;
    }

}
