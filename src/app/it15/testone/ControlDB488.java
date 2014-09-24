package app.it15.testone;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.animation.BounceInterpolator;

public class ControlDB488 extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "mydata488";
	private static final String TABLE_MEMBER = "kiattisak";
	private static final int DATABASE_VERSION = 1;

	public ControlDB488(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_MEMBER 
				+"(userID INTEGER PRIMARY KEY AUTOINCREMENT, " 
				+"Name TEXT(100)," + "Score DOUBLE,"
				+"Grade CHAR(2));");
		Log.d("CREATE TABLE", "Create Table Successfully");
		
	}

	public long InsertData(String strName, String strScore, String strGrade){
		String A = "A"; String Bp = "B+"; String B = "B"; String Cp = "C+"; String C = "C"; 
		String Dp = "D+"; String D = "D";String F = "F";
		
		try{
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Score", strScore);
			if(strScore != null){	
				Double point = Double.valueOf(strScore).doubleValue();				
				if(point >= 80){
					strGrade = A;
					values.put("Grade", strGrade);
				}
				else if(point >= 75){
					strGrade = Bp;
					values.put("Grade", strGrade);
				}
				else if(point >= 70){
					strGrade = B;
					values.put("Grade", strGrade);
				}
				else if(point >= 65){
					strGrade = Cp;
					values.put("Grade", strGrade);
				}
				else if(point >= 60){
					strGrade = C;
					values.put("Grade", strGrade);
				}
				else if(point >= 55){
					strGrade = Dp;
					values.put("Grade", strGrade);
				}
				else if(point >= 50){
					strGrade = D;
					values.put("Grade", strGrade);
				}
				else if(point < 50 ){
					strGrade = F;
					values.put("Grade", strGrade);					
				}
				
			}
			long l = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return l;
		}catch (Exception e){
			return -1;
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMBER);
		onCreate(db);

		
	}
	//Check Data
		public String[] CheckData(String strMemberID) {
		    try {
		        String arrData[] = null;
		        SQLiteDatabase db;
		        db = this.getReadableDatabase();

		        Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
		                "userID=?", new String[] { String.valueOf(strMemberID) },
		                null, null, null);
		        if (cursor != null) {
		            if (cursor.moveToFirst()) {
		                arrData = new String[cursor.getColumnCount()];
		                arrData[0] = cursor.getString(0);
		                arrData[1] = cursor.getString(1);
		                arrData[2] = cursor.getString(2);
		                arrData[3] = cursor.getString(3);
		            }
		        }
		        cursor.close();
		        db.close();
		        return arrData;

		    } catch (Exception e) {
		        return null;
		    }
		}
		//Select All
		public ArrayList<HashMap<String, String>> SelectAllData(){
			try{
				ArrayList<HashMap<String, String>> MyArrayList = new ArrayList<HashMap<String,String>>();
				HashMap<String, String> map;			
				SQLiteDatabase db;
				db = this.getReadableDatabase();
				
				String strSQL = "SELECT * FROM "+ TABLE_MEMBER;
				Cursor cursor = db.rawQuery(strSQL, null);
				if(cursor != null){
					if(cursor.moveToFirst()){
						do{
							map = new HashMap<String, String>();
							map.put("userID", cursor.getString(0));
							map.put("Name", cursor.getString(1));
							map.put("Score", cursor.getString(2));
							map.put("Grade", cursor.getString(3));
							MyArrayList.add(map);
						}while (cursor.moveToNext());
					}
				}
				cursor.close();
				db.close();
				return MyArrayList;
			
			}catch (Exception e){
				return null;
			}				
		}

}
