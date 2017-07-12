package ayush.practice.basicsandroidarchitecturecomponent.database.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ayush.practice.basicsandroidarchitecturecomponent.database.dao.UserDAO;
import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;

/**
 * Created by Ayush Jain on 7/12/17.
 */

@Database(entities = {UserDataEntity.class},version = 1)
public  abstract class UserDataBase extends RoomDatabase{
    public abstract UserDAO getUserDAO();
}
