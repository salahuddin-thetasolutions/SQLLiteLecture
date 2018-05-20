package theta.solutions.sqllitelecture.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;


import java.util.ArrayList;

import theta.solutions.sqllitelecture.Models.Notification;

public class DbQuery {

	// singleton instance
	private static DbQuery instance;
	private DatbaseOpenHelper dbHelper;
	SQLiteDatabase database;


	public static DbQuery getIntance(Context mContext) {
		if(instance == null) {
			instance = new DbQuery(mContext);
		}
		return instance;
	}

	private DbQuery(Context mContext) {
		dbHelper = new DatbaseOpenHelper(mContext);
	}

	public void open() throws SQLiteException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		if(database == null) {
			return;
		}
		database.close();
	}

	public boolean isDBOpen() {
		if(database == null) {
			return false;
		}
		return database.isOpen();
	}

	public SQLiteDatabase getdb() {

		SQLiteDatabase db = this.dbHelper.getWritableDatabase();
		return db;
	}




	//==============Insert Notifications=============

	public long insertNotificationToDatabase(Notification object) {
		if(object == null) {
			return -1;
		}
		if(!isDBOpen()) {
			open();
		}
		ContentValues values = new ContentValues();
		values.put(DbInterfaces.TABLE_NOTIFICATION_COLMUNS.NOTIFICATION_ALERT, object.getNotification());
		values.put(DbInterfaces.TABLE_NOTIFICATION_COLMUNS.NOTIFICATION_STATUS, object.getStatus());
		return database.insert(DbInterfaces.Table.NOTIFICATION, null, values);

	}



	// ============Get ALL Notifications=======================

	public ArrayList<Notification> getallNotification() {
		ArrayList<Notification> list = new ArrayList<Notification>();
		SQLiteDatabase db = getdb();

		Cursor c = db.rawQuery("Select *" + " FROM "
				+ DbInterfaces.Table.NOTIFICATION, null);


		int idColumnIndex = c.getColumnIndex(DbInterfaces.TABLE_NOTIFICATION_COLMUNS.ID);
		int NotificationAlertIndex = c.getColumnIndex(DbInterfaces.TABLE_NOTIFICATION_COLMUNS.NOTIFICATION_ALERT);
		int StatusColumnIndex = c.getColumnIndex(DbInterfaces.TABLE_NOTIFICATION_COLMUNS.NOTIFICATION_STATUS);


		while (c.moveToNext()) {
			int studentID = c.getInt(idColumnIndex);
			String Notification = c.getString(NotificationAlertIndex);
			String Status = c.getString(StatusColumnIndex);

			Notification student = new Notification(studentID,Notification,Status);
			list.add(student);
		}

		db.close();
		return list;
	}


	//=============Delete One Student====================

	public int deleteNotification(Notification object) {
		return database.delete(DbInterfaces.Table.NOTIFICATION, DbInterfaces.TABLE_NOTIFICATION_COLMUNS.ID + "=" + object.getID(), null);
	}

//	// ==============Update One Student==================
//
	public int updateNotification(Notification object) {
		ContentValues values = new ContentValues();
		values.put(DbInterfaces.TABLE_NOTIFICATION_COLMUNS.NOTIFICATION_ALERT, object.getNotification());
		values.put(DbInterfaces.TABLE_NOTIFICATION_COLMUNS.NOTIFICATION_STATUS, object.getStatus());
		return database.update(DbInterfaces.Table.NOTIFICATION, values, DbInterfaces.TABLE_NOTIFICATION_COLMUNS.ID + "=" + object.getID(), null);

	}
}
