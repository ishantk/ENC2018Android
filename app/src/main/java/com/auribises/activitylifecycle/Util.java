package com.auribises.activitylifecycle;

import android.net.Uri;

/**
 * Created by ishantkumar on 27/02/18.
 */

public class Util {

    // Database specific Info
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Customers.db";

    // Table Specific Info
    public static final String TAB_NAME = "Customer";

    public static final String COL_ID = "_ID";
    public static final String COL_NAME = "name";
    public static final String COL_PHONE = "phone";
    public static final String COL_CITY = "city";
    public static final String COL_GENDER = "gender";

    // Create Table Query
    public static final String CREATE_TAB_QUERY = "create table Customer(" +
            "_ID integer primary key autoincrement," +
            "name varchar(256)," +
            "phone varchar(16)," +
            "city varchar(256)," +
            "gender varchar(10)" +
            ")";

    public static final Uri URI_CUSTOMER = Uri.parse("content://com.auribises.activitylifecycle.customersprovider/"+TAB_NAME);

}
