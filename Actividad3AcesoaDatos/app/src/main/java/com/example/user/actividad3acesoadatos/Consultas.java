package com.example.user.actividad3acesoadatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Consultas extends AppCompatActivity {

    private MyDBAdapter dbAdapter;
   TextView textView, textView2,textView3, textView4, textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) this.findViewById(R.id.textView);
        textView2 = (TextView) this.findViewById(R.id.textView2);
        textView3 = (TextView) this.findViewById(R.id.textView3);
        textView4 = (TextView) this.findViewById(R.id.textView4);
        textView5 = (TextView) this.findViewById(R.id.textView5);

        dbAdapter = new MyDBAdapter(this);

        final Button todosalumnos = (Button) findViewById(R.id.todosalumnos);
        todosalumnos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> discos = dbAdapter.todosAlumnos();
                textView.setText(discos.get(0));
                textView2.setText(discos.get(1));
                textView3.setText(discos.get(2));
                textView4.setText(discos.get(3));
                textView5.setText(discos.get(4));
            }
        });
        final Button estciclo = (Button) findViewById(R.id.estciclo);
        estciclo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> discos = dbAdapter.AlumnosCiclo();
                textView.setText(discos.get(0));
                textView2.setText(discos.get(1));
                textView3.setText(discos.get(2));
                textView4.setText(discos.get(3));
                textView5.setText(discos.get(4));
            }
        });
        final Button estcurso = (Button) findViewById(R.id.estcurso);
        estcurso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> discos = dbAdapter.AlumnosCurso();
                textView.setText(discos.get(0));
                textView2.setText(discos.get(1));
                textView3.setText(discos.get(2));
                textView4.setText(discos.get(3));
                textView5.setText(discos.get(4));
            }
        });
        final Button todosprofes = (Button) findViewById(R.id.todosprofes);
        todosprofes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> discos = dbAdapter.todosPrfes();
                textView.setText(discos.get(0));
                textView2.setText(discos.get(1));
                textView3.setText(discos.get(2));
                textView4.setText(discos.get(3));
                textView5.setText(discos.get(4));
            }
        });
        final Button profyal = (Button) findViewById(R.id.profyal);
        profyal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> discos = dbAdapter.Profyal();
                textView.setText(discos.get(0));
                textView2.setText(discos.get(1));
                textView3.setText(discos.get(2));
                textView4.setText(discos.get(3));
                textView5.setText(discos.get(4));
            }
        });


    }
}
