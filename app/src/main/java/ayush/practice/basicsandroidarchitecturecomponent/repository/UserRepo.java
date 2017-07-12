package ayush.practice.basicsandroidarchitecturecomponent.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;
import io.reactivex.Completable;

/**
 * Created by Ayush Jain on 7/12/17.
 */

public interface UserRepo {

    Completable addUser(UserDataEntity userDataEntity);

    LiveData<List<UserDataEntity>> getAllUser();

    Completable updateUser(UserDataEntity userDataEntity);
}
