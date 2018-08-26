package com.arturo.almaitu.BD;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class VinculoBD {

    private ObtenerBD bd;
    protected SQLiteDatabase bdGods;

    public VinculoBD() {
    }

    public VinculoBD(Context context) {
        this.bd = ObtenerBD.getInstance(context);
    }

    protected void open() {
        bd.open();
        this.bdGods = bd.obtenermiBD();
    }

    protected void close() {
        bd.close();
    }


}
