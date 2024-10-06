package com.example.shopphile;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductDao {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public ProductDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Open the database
    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    // Close the database
    public void close() {
        dbHelper.close();
    }

    // Insert a new product
    public long addProduct(String name, double price, String category) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_PRICE, price);
        values.put(DatabaseHelper.COLUMN_CATEGORY, category);

        return db.insert(DatabaseHelper.TABLE_PRODUCTS, null, values);
    }

    // Get all products
    public Cursor getAllProducts() {
        return db.query(DatabaseHelper.TABLE_PRODUCTS,
                null, null, null, null, null, null);
    }
}
