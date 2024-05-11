package ru.mirea.nadezhkinaea.employeedb;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();
        employee.id = 2;
        employee.name = "Человек-паук";
        employee.salary = 20000;

        // Запись сотрудников в базу
        employeeDao.insert(employee);

        // Загрузка всех работников
        List<Employee> employees = employeeDao.getAll();

        // Получение определенного работника с id = 2
        employee = employeeDao.getById(2);

        // Обновление полей объекта
        employee.salary = 30000;
        employeeDao.update(employee);

        Log.d("DB", employee.name + " " + employee.salary);
    }
}