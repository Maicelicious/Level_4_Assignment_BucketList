package nl.hva.msi.bucketlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {BucketListItem.class}, version = 1, exportSchema = false)
public abstract class BucketItemRoomDatabase extends RoomDatabase {

    private final static String NAME_DATABASE = "item_database";
    public abstract BucketItemDao itemDao();

    private static volatile BucketItemRoomDatabase INSTANCE;

    protected static BucketItemRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BucketItemRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BucketItemRoomDatabase.class, NAME_DATABASE).allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
