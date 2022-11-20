package kz.talipovsn.quadratic;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_a; // Переменная для доступа к компоненту со значением "a"
    EditText editText_b;
    EditText editText_c;// Переменная для доступа к компоненту со значением "b"
    EditText editText_x;
    TextView textView_y; // Переменная для доступа к компоненту со значением результата
    Button buttonSum;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация переменных доступа к компонентам окна
        editText_a = findViewById(R.id.editText_a);
        editText_b = findViewById(R.id.editText_b);
        editText_c = findViewById(R.id.editText_c);
        editText_x = findViewById(R.id.editText_x);
        textView_y = findViewById(R.id.textView_y);


        // Проверка на переворот экрана и восстановление нужных значений в компонентах
        if (savedInstanceState != null) {
            textView_y.setText(savedInstanceState.getString("y"));
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Сохранение нужных нам значений компонент при перевороте экрана
        outState.putString("y", textView_y.getText().toString());
    }

    // МЕТОД ДЛЯ КНОПКИ РАСЧЕТА
    public void onCalc(View v) {

        // Локальные переменные
        double a, b, c, x, d, y;

        try { // НАЧАЛО ЗАЩИЩЕННОГО БЛОКА

            // Чтение данных из компонент
            a = Double.parseDouble(editText_a.getText().toString().trim());
            b = Double.parseDouble(editText_b.getText().toString().trim());
            c = Double.parseDouble(editText_c.getText().toString().trim());
            x = Double.parseDouble(editText_x.getText().toString().trim());
            // Основной алгоритм

            if (x < 4) {
                y = (x * x) + (a * a) * c / (2 * b) ;
                //label_otvet.setText("Ответ: " + String.format("%.2f",y));
            } else {
                y =  (x * x * x ) * (a - b) ;
            }
            // Вывод полученного значения в компонент
            textView_y.setText(String.valueOf(y));

        } catch (Exception e) { // ЧТО ДЕЛАТЬ ЕСЛИ ВОЗНИКНЕТ ОШИБКА В БЛОКЕ МЕЖДУ "TRY" И "CATCH":

            // Вывод сообщения об ошибке
            textView_y.setText("Неверные входные данные для расчета!");

        }  // КОНЕЦ ЗАЩИЩЕННОГО БЛОКА

    }

}