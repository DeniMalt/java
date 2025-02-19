package Calculator;

public interface TrigonometricFunctionHandler {
    double calculate(double argument, boolean isDegrees);
    void validate(double argument, boolean isDegrees);
}
