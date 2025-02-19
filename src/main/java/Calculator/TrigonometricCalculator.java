package Calculator;

public class TrigonometricCalculator {
    private final HandlerFactory factory;

    public TrigonometricCalculator(HandlerFactory factory) {
        this.factory = factory;
    }

    public double calculate(String function, double argument, String unit) {
        TrigonometricFunctionHandler handler = factory.getHandler(function);
        boolean isDegrees = "degrees".equals(unit);
        handler.validate(argument, isDegrees);
        return handler.calculate(argument, isDegrees);
    }
}
