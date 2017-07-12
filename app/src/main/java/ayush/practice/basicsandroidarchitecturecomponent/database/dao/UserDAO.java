package ayush.practice.basicsandroidarchitecturecomponent.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;
import io.reactivex.Flowable;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Ayush Jain on 7/12/17.
 */

@Dao
public interface UserDAO {

    @Query("SELECT * FROM "+ UserDataEntity.TABLE_NAME+" ")
    LiveData<List<UserDataEntity>> festchAllUsers();

//    RXJava Users
//    Flowable<List<UserDataEntity>> festchAllUsers();

    @Insert(onConflict = REPLACE)
    void insertUser(UserDataEntity userDataEntity);

    @Update
    void updateUser(UserDataEntity userDataEntity);

//    @Delete
//    void deleteUser(UserDataEntity userDataEntity);

}
