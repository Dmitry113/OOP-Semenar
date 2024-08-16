package Semenar_7DZ.src;

public class MainProgram {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(4, 5);
        ComplexNumber num2 = new ComplexNumber(2, 3);

        ComplexOperation addition = new LoggingComplexOperationDecorator(new ComplexAddition());
        ComplexOperation multiplication = new LoggingComplexOperationDecorator(new ComplexMultiplication());
        ComplexOperation division = new LoggingComplexOperationDecorator(new ComplexDivision());

        System.out.println("Addition: " + addition.execute(num1, num2));
        System.out.println("Multiplication: " + multiplication.execute(num1, num2));
        System.out.println("Division: " + division.execute(num1, num2));
    }
}
