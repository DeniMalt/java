package Calculator.HandlerFunctions;

import Calculator.TrigonometricFunctionHandler;


public class TanHandler implements TrigonometricFunctionHandler {
    @Override
    public double calculate(double argument, boolean isDegrees) {
        return Math.tan(isDegrees ? Math.toRadians(argument) : argument);
    }

    @Override
    public void validate(double argument, boolean isDegrees) {
        if (isDegrees && (argument % 180) == 90) {
            throw new IllegalArgumentException("Tangent is undefined for 90° + k*180°");
        } else if (!isDegrees && (argument % Math.PI) == Math.PI/2) {
            throw new IllegalArgumentException("Tangent is undefined for π/2 + kπ");
        }
    }
}