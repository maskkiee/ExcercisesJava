1.
SELECT COUNT(*) FROM employees;

2.
        SELECT first_name, last_name, salary FROM employees WHERE department_id = 1;

3.
        SELECT first_name, last_name, salaryFROM employees WHERE salary > 12000;

4.
SELECT first_name FROM employees WHERE phone IS NULL;

5.
SELECT MIN(salary) as najnizsza, MAX(salary) as najwyzsza FROM employees;

6.
SELECT DISTINCT city FROM departments;

7.
        SELECT first_name, last_name, hire_date FROM employees WHERE EXTRACT(YEAR FROM hire_date) = 2023;

8.
        SELECT title, price FROM books WHERE price > 150 ORDER BY price DESC;

9.
        SELECT title, in_stock FROM books WHERE in_stock < 15 ORDER BY in_stock;

10.
        SELECT title, publish_year FROM books WHERE publish_year < 2000;

11.
        SELECT department_id, COUNT(*) AS liczba FROM employees GROUP BY department_id ORDER BY department_id;

12.
SELECT ROUND(AVG(salary), 2) FROM employees;

13.
SELECT e.first_name, e.last_name, d.name FROM employees e LEFT JOIN departments d ON e.department_id = d.id WHERE e.department_id = 3;

14.
SELECT d.name, COUNT(e.first_name) AS liczba FROM departments d LEFT JOIN employees e ON e.department_id = d.id GROUP BY d.name HAVING COUNT(e.first_name) > 2;

15.
SELECT b.title, p.name, p.country FROM books b LEFT JOIN publishers p ON b.publisher_id = p.id GROUP BY b.title, p.name, p.country HAVING p.country = 'USA' ORDER BY p.title;

16.
SELECT p.name, COUNT(b.title) FROM publishers p LEFT JOIN books b ON b.publisher_id = p.id GROUP BY p.name ORDER BY COUNT(b.title), p.name;

17.
SELECT p.name, SUM(b.price*b.in_stock) AS wartosc_magazynu FROM publishers p LEFT JOIN books b ON b.publisher_id = p.id GROUP BY p.name ORDER BY wartosc_magazynu DESC;

18.
SELECT a.first_name, a.last_name FROM authors a LEFT JOIN book_authors ba ON ba.author_id  = a.id WHERE ba.book_id IS NULL;

19.
SELECT d.name, COUNT(e.is_active), ROUND(AVG(e.salary), 2) AS srednia FROM departments d LEFT JOIN employees e ON d.id = e.department_id WHERE e.is_active = true GROUP BY d.name ORDER BY srednia DESC;

20.
SELECT d.name, ROUND(AVG(e.salary), 2) AS srednia_pensja FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name HAVING ROUND(AVG(e.salary), 2) > 10000 ORDER BY srednia_pensja DESC;

21.
SELECT e.first_name || ' ' || e.last_name AS pracownik, ee.first_name || ' ' || ee.last_name AS manager FROM employees e JOIN employees ee ON ee.id = e.manager_id;

22.
        SELECT title, price, (SELECT ROUND(AVG(price), 2) FROM books) AS srednia_cena FROM books GROUP BY title, price HAVING price > (SELECT AVG(price) FROM books) ORDER BY price DESC;

23.
SELECT a.first_name || ' ' || a.last_name AS author, COUNT(ba.book_id) AS ilosc_ksiazek FROM authors a JOIN book_authors ba ON ba.author_id = a.id GROUP BY author ORDER BY ilosc_ksiazek DESC;

24.
SELECT p.name, b.price FROM publishers p LEFT JOIN books b ON p.id = b.publisher_id WHERE b.price = (SELECT MAX(price) FROM books WHERE publisher_id = p.id) ORDER BY b.price DESC;

25.
        SELECT department_name, first_name, last_name, salary FROM (
        SELECT d.name AS department_name, e.first_name, e.last_name, e.salary, ROW_NUMBER() OVER(PARTITION BY e.department_id ORDER BY e.salary DESC) AS rn
FROM employees e JOIN departments d ON d.id = e.department_id) WHERE rn = 2 ORDER BY department_name;

26.
WITH raport AS (
        SELECT p.country, COUNT(*) AS liczba_tytulow, SUM(b.price * b.in_stock) AS wartosc_magazynu, AVG(b.price) AS srednia_cena FROM publishers p JOIN books b ON b.publisher_id = p.id GROUP BY p.country HAVING SUM(b.price * b.in_stock) > 1000)
        SELECT country, liczba_tytulow, ROUND(wartosc_magazynu, 2) AS wartosc_magazynu, ROUND(srednia_cena, 2) AS srednia_cena FROM raport ORDER BY wartosc_magazynu DESC;