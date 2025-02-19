package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Calculator.HandlerFactory;
import Calculator.TrigonometricCalculator;

public class CalculateServlet extends HttpServlet {

    private TrigonometricCalculator calculator;

    @Override
    public void init() {
        this.calculator = new TrigonometricCalculator(new HandlerFactory());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/CalculatePage.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String function = getParameter(request, "function");
            double argument = parseArgument(request);
            String unit = getParameter(request, "unit");
            int precision = parsePrecision(request);

            double result = calculator.calculate(function, argument, unit);
            request.setAttribute("result", String.format("%." + precision + "f", result));
            request.getRequestDispatcher("/WEB-INF/view/CalculatePage.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            request.setAttribute("result", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/CalculatePage.jsp").forward(request, response);
        }
    }

    private String getParameter(HttpServletRequest request, String name) {
        String value = request.getParameter(name);
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Missing parameter: " + name);
        }
        return value;
    }

    private double parseArgument(HttpServletRequest request) {
        try {
            return Double.parseDouble(request.getParameter("argument"));
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid argument format");
        }
    }

    private int parsePrecision(HttpServletRequest request) {
        try {
            return Integer.parseInt(request.getParameter("precision"));
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid precision format");
        }
    }
}
