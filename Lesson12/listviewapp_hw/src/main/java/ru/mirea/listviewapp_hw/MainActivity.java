package ru.mirea.listviewapp_hw;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final String[][] authorsAndBooks = {
            {"Лев Толстой", "Война и мир"},
            {"Федор Достоевский", "Преступление и наказание"},
            {"Антон Чехов", "Вишневый сад"},
            {"Габриэль Гарсиа Маркес", "Сто лет одиночества"},
            {"Джордж Оруэлл", "1984"},
            {"Джейн Остин", "Гордость и предубеждение"},
            {"Маргарет Митчелл", "Унесенные ветром"},
            {"Эрих Мария Ремарк", "Три товарища"},
            {"Дж. Р. Р. Толкин", "Властелин колец"},
            {"Данте Алигьери", "Божественная комедия"},
            {"Михаил Булгаков", "Мастер и Маргарита"},
            {"Артур Конан Дойл", "Шерлок Холмс"},
            {"Агата Кристи", "Десять негритят"},
            {"Марк Твен", "Приключения Тома Сойера"},
            {"Джек Лондон", "Белый клык"},
            {"Луис Кэрролл", "Алиса в стране чудес"},
            {"Фрэнсис Скотт Фицджеральд", "Великий Гэтсби"},
            {"Харпер Ли", "Убить пересмешника"},
            {"Джон Стейнбек", "Гроздья гнева"},
            {"Чарльз Диккенс", "Оливер Твист"},
            {"Уильям Шекспир", "Гамлет"},
            {"Франц Кафка", "Процесс"},
            {"Гомер", "Одиссея"},
            {"Рэй Брэдбери", "451 градус по Фаренгейту"},
            {"Джордж Мартин", "Игра престолов"},
            {"Виктор Гюго", "Отверженные"},
            {"Герман Гессе", "Игра в бисер"},
            {"Марио Пьюзо", "Крестный отец"},
            {"Эрнест Хемингуэй", "Старик и море"},
            {"Альбер Камю", "Чума"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.books_list_view);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_2, android.R.id.text1, authorsAndBooks) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);

                text1.setText(authorsAndBooks[position][0]);
                text2.setText(authorsAndBooks[position][1]);
                return view;
            }
        };
        listView.setAdapter(adapter);
    }
}