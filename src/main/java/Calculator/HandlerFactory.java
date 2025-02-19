package Calculator;

import java.util.*;

import Calculator.HandlerFunctions.*;

public class HandlerFactory {
    private final Map<String, TrigonometricFunctionHandler> handlers = new HashMap<>();

    public HandlerFactory() {
        register("sin", new SinHandler());
        register("cos", new CosHandler());
        register("tan", new TanHandler());
    }

    public void register(String name, TrigonometricFunctionHandler handler) {
        handlers.put(name.toLowerCase(), handler);
    }

    public TrigonometricFunctionHandler getHandler(String functionName) {
        TrigonometricFunctionHandler handler = handlers.get(functionName.toLowerCase());
        if (handler == null) throw new IllegalArgumentException("Invalid function");
        return handler;
    }
}
