package com.android.career_services_application;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by icyhot on 11/03/2017.
 * This class will eventually substitute the JobList class.
 */

public class Database extends AppCompatActivity {

    public Database() {
        try {
            SQLiteDatabase jobsDB = this.openOrCreateDatabase("Jobs", MODE_PRIVATE, null);
            createTable(jobsDB);
            addJobsToDB(jobsDB);
        } catch (Exception e) {
            e.printStackTrace();
            //ignore this comment. testing pull request.
            //ignore this comment again.
            //ok, this is the last pull request test.
        }
    }

    /**
     * Each job includes: title, company, location, how many days it's been posted, and a primary key
     * @param jobsDB
     */
    public void createTable(SQLiteDatabase jobsDB) {
        jobsDB.execSQL("CREATE TABLE IF NOT EXISTS jobs (title VARCHAR, company VARCHAR, " +
                "location VARCHAR, daysAgo INT(2), id INT PRIMARY KEY");
    }

    public void addJobsToDB(SQLiteDatabase jobsDB) {
        jobsDB.execSQL("INSERT INTO jobs (title, company, location, daysAgo) " +
                "VALUES ('Programmer', 'Google', 'Mountain View, CA', 5");  //inserts one job into database


    }


}
