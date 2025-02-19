package Calculator.HandlerFunctions;

import Calculator.TrigonometricFunctionHandler;


public class CosHandler implements TrigonometricFunctionHandler {
    @Override
    public double calculate(double argument, boolean isDegrees) {
        return Math.cos(isDegrees ? Math.toRadians(argument) : argument);
    }

    @Override
    public void validate(double argument, boolean isDegrees) {

    }
}