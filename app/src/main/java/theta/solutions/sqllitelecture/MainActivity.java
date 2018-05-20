package theta.solutions.sqllitelecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

import theta.solutions.sqllitelecture.Models.Notification;
import theta.solutions.sqllitelecture.database.DbQuery;

public class MainActivity extends AppCompatActivity {

    EditText mNotification,mStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mStatus=(EditText)findViewById(R.id.ALT);
//        mNotification=(EditText)findViewById(R.id.ALT);
        SaveNotificationdb();
        //DeleteNotification();
    }

    private void DeleteNotification() {
        Notification object=new Notification("Notification text abc","Unread");
        DbQuery db = DbQuery.getIntance(this);
        db.open();
        if (db.isDBOpen()) {
            long rowInserted=db.updateNotification(object);
            if (rowInserted != -1) {
                Log.d("Record", "Insereted");
                Integer id = (int)(long) rowInserted;
            } else {
                Log.d("Record", "Error Insereted");
            }
        }
    }

    private void SaveNotificationdb() {
        Notification object=new Notification("Notification text abc","Unread");
        DbQuery db = DbQuery.getIntance(this);
        db.open();
        if (db.isDBOpen()) {
            long rowInserted=db.insertNotificationToDatabase(object);
            if (rowInserted != -1) {
                Log.d("Record", "Insereted");
                Integer id = (int)(long) rowInserted;
            } else {
                Log.d("Record", "Error Insereted");
            }
        }
    }


    private void AllNotificationFromDatabase() {


        DbQuery db = DbQuery.getIntance(this);
        db.open();
        if (db.isDBOpen()) {
           ArrayList<Notification> list = db.getallNotification();
        }

    }
}
