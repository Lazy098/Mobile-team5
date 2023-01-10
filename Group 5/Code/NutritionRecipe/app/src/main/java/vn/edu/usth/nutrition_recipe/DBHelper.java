package vn.edu.usth.nutrition_recipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Bocchi.db";
    public DBHelper(Context context) {
        super(context, "Bocchi.db", null, 1);
    }

    public static final String TABLE_NAME1 = "users";
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String table1 = "CREATE TABLE "+TABLE_NAME1+"(username TEXT PRIMARY KEY, password TEXT)";
        MyDB.execSQL(table1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int oldVer, int newVer) {
        _db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME1);
        onCreate(_db);
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert(TABLE_NAME1, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLE_NAME1+" where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLE_NAME1+" where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public void deleteAccount(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.delete(TABLE_NAME1, "username=?", new String[]{username});
        MyDB.delete(TABLE_NAME1, "password=?", new String[]{password});
        MyDB.close();
    }

}
