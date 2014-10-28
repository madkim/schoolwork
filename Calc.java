// Calc.java
// Define a class for doing RPN.

public class Calc 
    {
    private int size;
    private double[] calcArray;
    private int top;
    private int count;

    public Calc() 
        {
        size = 100;
        calcArray = new double[size];
        top = -1;
        }
     
    public void push(double x) 
        {
        if(top == size-1){
            throw new RuntimeException ("stack is full"); 
        }
        else{
        calcArray[++top] = x;
        count++;    
        }   
    }
    
    public double pop() 
        {
        count--;
        return calcArray[top--];
        }
    
    public double peek() 
        {
        return calcArray[top];
        }
    

    public void add() 
        {
        double val2 = pop(); 
        if (top == -1) {
            throw new RuntimeException ("can't add without two numbers"); 
        }
        else{
            double val1 = pop();
            push(val1+val2);
        }
    }
    
    public void subtract() 
        {
        double val2 = pop();
        if (top == -1) {
            throw new RuntimeException ("can't subtract without two numbers"); 
        }
        else{
        double val1 = pop();
        push(val1-val2);
        }   
    }

    public void multiply() 
        {
        double val2 = pop();
        double val1 = pop();
        push(val1*val2);
    }

    public void divide() 
        {
        double val2 = pop();
        if (val2 == 0){
            throw new RuntimeException ("can't divide by zero");
        }
        else{
        double val1 = pop();
        push(val1/val2);
        }
    }
    
    public int depth() 
        {
        return count;    
    }

    public void reciprocal()
        {
        double val1 = pop();
        if( val1 == 0){
            throw new RuntimeException ("can't divide by zero");
        }
        else{
        double val2 = 1/val1;
        push(val2);
        }
    }
}
