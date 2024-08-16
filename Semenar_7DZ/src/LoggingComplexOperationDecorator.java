package Semenar_7DZ.src;

import java.util.logging.Logger;

public class LoggingComplexOperationDecorator implements ComplexOperation {
    private final ComplexOperation decoratedOperation;
    private final Logger logger = Logger.getLogger(LoggingComplexOperationDecorator.class.getName());

    public LoggingComplexOperationDecorator(ComplexOperation operation) {
        this.decoratedOperation = operation;
    }

    @Override
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = decoratedOperation.execute(num1, num2);
        logger.info(String.format("Executed operation: %s. Result: %s", decoratedOperation.getClass().getSimpleName(),
                result));
        return result;
    }
}
