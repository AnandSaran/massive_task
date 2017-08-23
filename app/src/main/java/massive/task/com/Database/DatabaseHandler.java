package massive.task.com.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import massive.task.com.model.pojo.Delivery;
import massive.task.com.model.pojo.Location;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "massive";

    // DeliveryList table name
    private static final String TABLE_DELIVERY_DATA = "delivery_data";
    // DeliveryList Table Columns names
    private static final String KEY_IMAGE_URL = "imageUrl";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_LATITUDE = "lat";
    private static final String KEY_LONGITUDE = "lng";
    private static final String TAG = "DatabaseHandler";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DELIVERY_LIST_TABLE = "CREATE TABLE " + TABLE_DELIVERY_DATA + "("
                + KEY_IMAGE_URL + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_ADDRESS + " TEXT,"
                + KEY_LATITUDE + " TEXT,"
                + KEY_LONGITUDE + " TEXT" + ")";
        db.execSQL(CREATE_DELIVERY_LIST_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Create tables again
        onCreate(db);
    }



    public void addDeliveryList(List<Delivery> deliveries, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i = 0; i < deliveries.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(KEY_IMAGE_URL, deliveries.get(i).getImageUrl());
            values.put(KEY_DESCRIPTION, deliveries.get(i).getDescription()); // FoodItem name
            values.put(KEY_ADDRESS, deliveries.get(i).getDescription()); // FoodItem amount
            values.put(KEY_LATITUDE, deliveries.get(i).getLocation().getLat());
            values.put(KEY_LONGITUDE, deliveries.get(i).getLocation().getLng());
            // Inserting Row
            db.insert(TABLE_DELIVERY_DATA, null, values);
        }
        db.close(); // Closing database connection

    }
    public List<Delivery> getDeliveryList() {
        List<Delivery> deliveryList = new ArrayList<Delivery>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DELIVERY_DATA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Delivery delivery = new Delivery();
                delivery.setImageUrl(cursor.getString(0));
                delivery.setDescription(cursor.getString(1));
                Location location=new Location();
                location.setAddress(cursor.getString(2));
                location.setLat(Double.valueOf(cursor.getString(3)));
                location.setLng(Double.valueOf(cursor.getString(4)));
                delivery.setLocation(location);
                // Adding foodItem to list
                deliveryList.add(delivery);
            } while (cursor.moveToNext());
        }

        // return contact list
        return deliveryList;
    }



}