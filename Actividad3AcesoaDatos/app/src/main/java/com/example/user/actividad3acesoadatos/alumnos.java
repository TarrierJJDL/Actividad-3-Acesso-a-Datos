package com.example.user.actividad3acesoadatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class alumnos extends AppCompatActivity {
    private MyDBAdapter dbAdapter;
    EditText nombre, edad, ciclo, curso, nota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);
        ciclo = (EditText) findViewById(R.id.ciclo);
        curso = (EditText) findViewById(R.id.curso);
        nota = (EditText) findViewById(R.id.nota);
        dbAdapter = new MyDBAdapter(this);
        final Button guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String n = nombre.getText().toString();
                String e = edad.getText().toString();
                String c = ciclo.getText().toString();
                String cu = curso.getText().toString();
                String not = nota.getText().toString();

                dbAdapter.open();

                dbAdapter.insertarAlumno(n,e,c,cu,not);


            }
        });
    }
}
