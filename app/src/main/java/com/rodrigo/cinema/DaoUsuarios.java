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
    String tabla = "create table if not exists usuario(id integer primary key autoincrement,email text,pass text, nombre text,apellido text)";

    public DaoUsuarios(Context context) {
        this.context = context;
        sql = context.openOrCreateDatabase(bd, context.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuarios();
    }

    public boolean insertUsuario(Usuarios u) {
        if (buscar(u.getEmail()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("email", u.getEmail());
            cv.put("pass", u.getPassword());
            cv.put("nombre", u.getNombre());
            cv.put("apellido", u.getApellidos());
            return (sql.insert("usuario", null, cv) > 0);
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
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                Usuarios u = new Usuarios();
                u.setId(cr.getInt(0));
                u.setEmail(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellidos(cr.getString(4));
                lista.add(u);
            } while (cr.moveToNext());
        }
        return lista;
    }

    //Este metodo verifica si el usuario esta registrado para dejarle logearse
    public int login(String u, String p) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(1).equals(u) && cr.getString(2).equals(u)) {
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
