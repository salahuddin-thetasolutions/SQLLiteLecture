package theta.solutions.sqllitelecture.database;

public interface DbInterfaces {

	public static interface Table {
		public static final String NOTIFICATION = "notification_table";
     	public static final String TEACHER = "teacher_table";

	}

	public static abstract interface TABLE_NOTIFICATION_COLMUNS {
		public static final String ID = "notification_id";
		public static final String NOTIFICATION_ALERT = "notification_alert";
		public static final String NOTIFICATION_STATUS = "notification_status";
		public static final String DATE = "date";
	}

	public static abstract interface TEACHER {
		public static final String ID = "tescher_id";
		public static final String STRING_IMAGE = "image";
	}
}
