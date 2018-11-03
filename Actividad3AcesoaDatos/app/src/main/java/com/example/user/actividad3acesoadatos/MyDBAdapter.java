package com.example.user.actividad3acesoadatos;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDBAdapter {

    private static final String DATABASE_NAME = "dbcologio.db";
    private static final String DATABASE_TABLE = "alumnos";
    private static final int DATABASE_VERSION = 1;

    private static final String nombreA = "Nombre alumno";
    private static final String edadA = "Edad alumno";
    private static final String cicloA = "Ciclo alumno";
    private static final String cursoA = "Curso alumno";
    private static final String notaA = "Nota media alumno";
    private static final String nombreP = "Nombre profesor";
    private static final String edadP = "Edad profesor";
    private static final String cicloP = "Ciclo profesor";
    private static final String cursoP = "Curso profesor";
    private static final String despachoP = "Despacho profesor";

    private static final String DATABASE_CREATE = "CREATE TABLE "+DATABASE_TABLE+" (_id integer primary key autoincrement, title text, year integer);";
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS "+DATABASE_TABLE+";";

    private final Context context;
    private MyDbHelper dbHelper;
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insertarAlumno(String n, String e, String c, String cur, String not){

        ContentValues newValues = new ContentValues();

        newValues.put(nombreA,n);
        newValues.put(edadA,e);
        newValues.put(cicloA,c);
        newValues.put(cursoA,cur);
        newValues.put(notaA,not);

        db.insert(DATABASE_TABLE,null,newValues);
    }

    public void insertarProfesores(String y, String t, String r, String o, String des){

        ContentValues newValues = new ContentValues();

        newValues.put(nombreP,y);
        newValues.put(edadP,t);
        newValues.put(cicloP,r);
        newValues.put(cursoP,o);
        newValues.put(despachoP,des);

        db.insert(DATABASE_TABLE,null,newValues);
    }


    public ArrayList<String> todosAlumnos(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5));
            }while (cursor.moveToNext());
        }
        return gen;
    }

    public ArrayList<String> AlumnosCiclo(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(1)+" "+cursor.getString(3));
            }while (cursor.moveToNext());
        }
        return gen;
    }

    public ArrayList<String> AlumnosCurso(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(1)+" "+cursor.getString(4));
            }while (cursor.moveToNext());
        }
        return gen;
    }

    public ArrayList<String> todosPrfes(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(6)+" "+cursor.getString(7)+" "+cursor.getString(8)+" "+cursor.getString(9)+" "+cursor.getString(10));
            }while (cursor.moveToNext());
        }
        return gen;
    }
    public ArrayList<String> Profyal(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(1)+" "+cursor.getString(6));
            }while (cursor.moveToNext());
        }
        return gen;
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            onCreate(db);
        }



    }
}

