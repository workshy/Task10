package ua.epam;

/**
 * Created by Viktoriia_Marynchak on 9/26/2016.
 */
public class Decorator {
    public void main(String[] args) {
        // write your code here
        PrinterInterface p1 = new QuotesDecorator(new Printer("hi"));
        p1.print();
    }

}
interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override

    public void print() {
        System.out.print(value);
    }
}

class QuotesDecorator implements PrinterInterface {
    PrinterInterface component;

    public QuotesDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}