package theta.solutions.sqllitelecture.Models;

/**
 * Created by ThetaTeam2 on 20/05/2018.
 */

public class Notification {
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNotification() {
        return Notification;
    }

    public void setNotification(String notification) {
        Notification = notification;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    Integer ID;
    String Notification;
    String Status;
    public Notification(Integer ID,String Notification,String Status){
        this.ID=ID;
        this.Notification=Notification;
        this.Status=Status;
    }
    public Notification(String Notification,String Status){
        this.Notification=Notification;
        this.Status=Status;
    }
}
