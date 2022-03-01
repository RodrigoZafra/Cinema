package com.rodrigo.cinema;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rodrigo.cinema.Entidades.Usuarios;

import java.util.ArrayList;

public class DaoUsuarios {
    Context context;
    Usuarios u;
    ArrayList<Usuarios> lista;
    SQLiteDatabase sql;
    String bd = "BDUsuarios";
    String tabla = "create table if not exists user(id integer primary key autoincrement,nombre text,apellido text, email text,pass text)";

    public DaoUsuarios(Context context) {
        this.context = context;
        sql = context.openOrCreateDatabase(bd, context.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuarios();
    }

    public boolean insertUsuario(Usuarios u) {
        if (buscar(u.getNombre()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("nombre", u.getNombre());
            cv.put("apellido", u.getApellidos());
            cv.put("email", u.getEmail());
            cv.put("pass", u.getPassword());
            return (sql.insert("user", null, cv) > 0);
        } else {
            return false;
        }
    }

    public int buscar(String u) {
        int x = 0;
        lista = selectUsuario();
        for (Usuarios us : lista) {
            if (us.getEmail().equals(u)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuarios> selectUsuario() {
        ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
        Cursor cr = sql.rawQuery("select * from user", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                Usuarios u = new Usuarios();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setApellidos(cr.getString(2));
                u.setEmail(cr.getString(3));
                u.setPassword(cr.getString(4));
                lista.add(u);
            } while (cr.moveToNext());
        }
        return lista;
    }

    //Este metodo verifica si el usuario esta registrado para dejarle logearse
    public int login(String u, String p) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from user", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(3).equals(u) && cr.getString(4).equals(u)) {
                    a++;
                }
            } while (cr.moveToNext());
        }
        return a;
    }

    public Usuarios getUsuario(String u, String p) {
        lista = selectUsuario();
        for (Usuarios us :
                lista) {
            if (us.getEmail().equals(u) && us.getPassword().equals(p)) {
                return us;
            }
        }
        return null;
    }

    public Usuarios getUsuarioById(int id) {
        lista = selectUsuario();
        for (Usuarios us :
                lista) {
            if (us.getId() == id) {
                return us;
            }
        }
        return null;
    }
}
