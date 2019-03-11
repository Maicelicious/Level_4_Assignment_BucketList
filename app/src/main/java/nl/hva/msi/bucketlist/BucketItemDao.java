package nl.hva.msi.bucketlist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.content.ClipData;

import java.util.List;

import nl.hva.msi.bucketlist.BucketListItem;

@Dao
public interface BucketItemDao {

    @Insert
    void insert(BucketListItem product);

    @Delete
    void delete(BucketListItem product);

    @Delete
    void delete(List<BucketListItem> products);

    @Query("SELECT * from item_table")
    List<BucketListItem> getAllItems();

}
