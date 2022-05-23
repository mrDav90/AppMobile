package com.example.anewapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NewBase extends SQLiteOpenHelper {

    private static final String   NAME_BASE = "newbase.db";
    private static final  int BASE_VERSION = 1;

    public NewBase(@Nullable Context context) {
        super(context, NAME_BASE, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String requete = " create table  Connexion ( id integer primary key autoincrement , nom text not null , prenom text not null , login text not null , password text not null , confirmpassword text not null)";
         db.execSQL(requete);

        String req = " create table Score (user text not null , score integer not null)";
         db.execSQL(req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertInConnexion( String nom , String prenom , String login , String password , String ConfirmPassword)
    {
        nom = nom.replace("'","''");
        prenom = prenom.replace("'","''");
        login = login.replace("'","''");
        password = password.replace("'","''");
        ConfirmPassword = ConfirmPassword.replace("'","''");
        String requete = " insert into Connexion (nom , prenom , login , password , confirmpassword) values ('"+nom+"','"+prenom+"','"+login+"','"+password+"','"+ConfirmPassword+"') ";
        this.getWritableDatabase().execSQL(requete);
    }

    public  void insertInScore( String login , int score)
    {
        login = login.replace("'","''");

        String req1  = "insert into Score (user , score) values ('"+login+"',"+score+")";
        this.getWritableDatabase().execSQL(req1);
    }


    public  String recupLoginFromConnexion( String login)
    {
        login = login.replace("'" , "''");
        SQLiteDatabase db = this.getReadableDatabase();
        String request = "select login from Connexion where login ='"+login+"'";

        Cursor cursor = db.rawQuery(request , null);
        cursor.moveToLast();
        String theLogin = null;
        if (!cursor.isAfterLast())
        {
             theLogin = cursor.getString(0);

        }
        cursor.close();
        return  theLogin;

    }


    public  String recupPassFromConnexion( String login)
    {
        login = login.replace("'" , "''");
        SQLiteDatabase db = this.getReadableDatabase();
        String request = "select password from Connexion where login ='"+login+"'";

        Cursor cursor = db.rawQuery(request , null);
        cursor.moveToLast();
        String thePass = null;
        if (!cursor.isAfterLast())
        {
            thePass = cursor.getString(0);

        }
        cursor.close();
        return  thePass;

    }
}
