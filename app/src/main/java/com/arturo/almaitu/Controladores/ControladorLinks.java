package com.arturo.almaitu.Controladores;

import android.content.Context;
import android.database.Cursor;

import com.arturo.almaitu.BD.VinculoBD;
import com.arturo.almaitu.Modelos.ModeloDc;

import java.util.ArrayList;

public class ControladorLinks extends VinculoBD {

    public ControladorLinks() {
        super();
    }

    public ControladorLinks(Context context) {
        super(context);
    }

    public ArrayList<ModeloDc> getAllComics() {
        open();
        ArrayList<ModeloDc> comics = new ArrayList<>();
        Cursor cursor = bdGods.rawQuery("" +
                "SELECT Nombre, NombreImagen " +
                "FROM DcLinks " +
                "ORDER BY Nombre", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                final ModeloDc model = new ModeloDc();
                model.setNombre(cursor.getString(0));
                model.setNombreImagen(cursor.getString(1));
                comics.add(model);
                cursor.moveToNext();
            }
            cursor.close();
            close();
            return comics;
        } else {
            cursor.close();
            close();
            return null;
        }
    }

        public ArrayList<ModeloDc> getAllComicsByCompany(String company) {
            open();
            ArrayList<ModeloDc> comics = new ArrayList<>();
            Cursor cursor = bdGods.rawQuery("" +
                    "SELECT Nombre, NombreImagen " +
                    "FROM DcLinks " +
                    "WHERE Empresa = ? " +
                    "ORDER BY Nombre ", new String[]{company});
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    final ModeloDc model = new ModeloDc();
                    model.setNombre(cursor.getString(0));
                    model.setNombreImagen(cursor.getString(1));
                    comics.add(model);
                    cursor.moveToNext();
                }
                cursor.close();
                close();
                return comics;
            } else {
                cursor.close();
                close();
                return null;
            }

    }

    public ArrayList<ModeloDc> getLinksAndDescriptions(String title) {
        open();
        ArrayList<ModeloDc> links = new ArrayList<>();
        Cursor cursor = bdGods.rawQuery("" +
                "SELECT Link, Descripcion, Link2, Descripcion2, Link3, Descripcion3 " +
                "FROM DcLinks " +
                "WHERE Nombre =?", new String[]{title});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            final ModeloDc model = new ModeloDc();
            model.setLink(cursor.getString(0));
            model.setDescripcion(cursor.getString(1));
            model.setLink2(cursor.getString(2));
            model.setDescripcion2(cursor.getString(3));
            model.setLink3(cursor.getString(4));
            model.setDescripcion3(cursor.getString(5));
            links.add(model);
            cursor.moveToNext();
        }
        close();
        return links;
    }
}
