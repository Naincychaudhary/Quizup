package rcew.application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mydbms extends SQLiteOpenHelper {
    public mydbms(Context context) {
        super(context, "datas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String oss="create table detail(iid integer primary key autoincrement,email text,password text)";
        db.execSQL(oss);

        String lo="create table paper(id integer primary key autoincrement,que text,opt1 text,opt2 text,opt3 text,opt4 text,ansr text)";
        db.execSQL(lo);

        String lo1="create table paper1(id integer primary key autoincrement,que text,opt1 text,opt2 text,opt3 text,opt4 text,ansr text)";
        db.execSQL(lo1);

        String lo2="create table paper2(id integer primary key autoincrement,que text,opt1 text,opt2 text,opt3 text,opt4 text,ansr text)";
        db.execSQL(lo2);

        String lo3="create table paper3(id integer primary key autoincrement,que text,opt1 text,opt2 text,opt3 text,opt4 text,ansr text)";
        db.execSQL(lo3);

        String lo4="create table paper4(id integer primary key autoincrement,que text,opt1 text,opt2 text,opt3 text,opt4 text,ansr text)";
        db.execSQL(lo4);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXISTS paper1");

    }


    public void insert(String email,String password)
    {
        SQLiteDatabase d=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("email",email);
        c.put("password",password);
        d.insert("detail",null,c);
        d.close();
    }

    public Cursor login(String m,String p)
    {
        SQLiteDatabase d=this.getWritableDatabase();
        String lg="select * from detail where email='"+m+"' and password='"+p+"'";
        Cursor cc= d.rawQuery(lg,null);
        return cc;

    }
    public void add_quiz(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("que",qs);
        cv.put("opt1",p1);
        cv.put("opt2",p2);
        cv.put("opt3",p3);
        cv.put("opt4",p4);
        cv.put("ansr",anss);
        d.insert("paper",null,cv);
        d.close();

    }
    public Cursor get_quiz(int idd){
        SQLiteDatabase d=this.getWritableDatabase();
        String qus="select* from paper where id="+idd+"";

        Cursor c= d.rawQuery(qus,null);


        return c;

    }
    public void add_quiz1(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("que",qs);
        cv.put("opt1",p1);
        cv.put("opt2",p2);
        cv.put("opt3",p3);
        cv.put("opt4",p4);
        cv.put("ansr",anss);
        d.insert("paper1",null,cv);
        d.close();

    }
    public Cursor get_quiz1(int idd){
        SQLiteDatabase d=this.getWritableDatabase();
        String qus="select* from paper1 where id="+idd+"";

        Cursor c= d.rawQuery(qus,null);


        return c;

    }

    public void add_quiz2(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("que",qs);
        cv.put("opt1",p1);
        cv.put("opt2",p2);
        cv.put("opt3",p3);
        cv.put("opt4",p4);
        cv.put("ansr",anss);
        d.insert("paper2",null,cv);
        d.close();

    }
    public Cursor get_quiz2(int idd){
        SQLiteDatabase d=this.getWritableDatabase();
        String qus="select* from paper2 where id="+idd+"";

        Cursor c= d.rawQuery(qus,null);


        return c;

    }

    public void add_quiz3(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("que",qs);
        cv.put("opt1",p1);
        cv.put("opt2",p2);
        cv.put("opt3",p3);
        cv.put("opt4",p4);
        cv.put("ansr",anss);
        d.insert("paper3",null,cv);
        d.close();

    }
    public Cursor get_quiz3(int idd){
        SQLiteDatabase d=this.getWritableDatabase();
        String qus="select* from paper3 where id="+idd+"";

        Cursor c= d.rawQuery(qus,null);


        return c;

    }

    public void add_quiz4(String qs,String p1,String p2,String p3,String p4,String anss){

        SQLiteDatabase d=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("que",qs);
        cv.put("opt1",p1);
        cv.put("opt2",p2);
        cv.put("opt3",p3);
        cv.put("opt4",p4);
        cv.put("ansr",anss);
        d.insert("paper4",null,cv);
        d.close();

    }
    public Cursor get_quiz4(int idd){
        SQLiteDatabase d=this.getWritableDatabase();
        String qus="select* from paper4 where id="+idd+"";

        Cursor c= d.rawQuery(qus,null);


        return c;

    }
}
