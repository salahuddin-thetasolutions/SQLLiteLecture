package theta.solutions.sqllitelecture.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatbaseOpenHelper extends SQLiteOpenHelper {


	private Context mContext;

	private static final String DATABASE_NAME = "myfirst.db";
	private static final int DATABASE_VERSION = 1;

	public DatbaseOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		mContext = context;
	}

	public static synchronized DatbaseOpenHelper getAppdb(Context context) {
		return new DatbaseOpenHelper(context);
	}

	public SQLiteDatabase getsqldb() {
		SQLiteDatabase db = getWritableDatabase();
		db.setLockingEnabled(true);
		return db;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.d("DB","CREATED");
//		createItemList(db);
		CreateTables(db);
//		tableRooms();


	}

	private void CreateTables(SQLiteDatabase db) {
		db.execSQL(" CREATE TABLE IF NOT EXISTS  "
				+ DbInterfaces.Table.NOTIFICATION + "( "
				+ DbInterfaces.TABLE_NOTIFICATION_COLMUNS.ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ DbInterfaces.TABLE_NOTIFICATION_COLMUNS.NOTIFICATION_ALERT + " TEXT,"
				+ DbInterfaces.TABLE_NOTIFICATION_COLMUNS.NOTIFICATION_STATUS + " TEXT,"
				+ DbInterfaces.TABLE_NOTIFICATION_COLMUNS.DATE + " TEXT"
				+ ")");

		db.execSQL(" CREATE TABLE IF NOT EXISTS  "
				+ DbInterfaces.Table.TEACHER + "( "
				+ DbInterfaces.TEACHER.ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ DbInterfaces.TEACHER.STRING_IMAGE+ " TEXT"
				+ ")");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		if (newVersion > oldVersion) {

			db.execSQL(" DROP TABLE IF EXISTS " + DbInterfaces.Table.NOTIFICATION);

			onCreate(db);

		}
	}

}
