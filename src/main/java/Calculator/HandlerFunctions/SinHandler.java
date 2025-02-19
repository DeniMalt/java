package Calculator.HandlerFunctions;

import Calculator.TrigonometricFunctionHandler;


public class SinHandler implements TrigonometricFunctionHandler {
    @Override
    public double calculate(double argument, boolean isDegrees) {
        return Math.sin(isDegrees ? Math.toRadians(argument) : argument);
    }

    @Override
    public void validate(double argument, boolean isDegrees) {

    }
}