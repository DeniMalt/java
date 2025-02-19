<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset = "utf-8">
        <title>Тригонометрические функции</title>
        <style>
            <%@include file='../../styles/CalculatePage.css' %>
        </style>
    </head>

    <body>
        <div class="form-container">
            <h2>Вычислить тригонометрическую функцию</h2>
            <form action="CalculateServlet" method="POST">
                <div class="form-group">
                    <label for="function">Выберите функцию</label>
                    <select name="function" id="function" required>
                        <option value="">--Выберите--</option>
                        <option value="sin" ${param.function == 'sin' ? 'selected' : ''}>sin</option>
                        <option value="cos" ${param.function == 'cos' ? 'selected' : ''}>cos</option>
                        <option value="tan" ${param.function == 'tan' ? 'selected' : ''}>tan</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="argument">Введите аргумент</label>
                    <input type="text" name="argument" id="argument" value="${param.argument}" placeholder="Введите аргумент" required>
                </div>
                <div class="form-group">
                    <label for="unit">Выберите единицу измерения</label>
                    <select id="unit" name="unit" required>
                        <option value="">--Выберите--</option>
                        <option value="degrees" ${param.unit == 'degrees' ? 'selected' : ''}>Градусы</option>
                        <option value="radians" ${param.unit == 'radians' ? 'selected' : ''}>Радианы</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="precision">Точность</label>
                    <input type="text" name="precision" id="precision" value="${param.precision}" placeholder="Введите кол-во знаков после запятой" required>
                </div>
                <div class="form-group">
                    <label for="result">Результат</label>
                    <input name="result" class="result" id="result" type="text" value="${requestScope.result}" readonly>
                </div>
                <button type="submit" class="submit-button">Вычислить</button>
            </form>
        </div>
    </body>
</html>
