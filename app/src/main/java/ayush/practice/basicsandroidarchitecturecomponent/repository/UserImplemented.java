package ayush.practice.basicsandroidarchitecturecomponent.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import ayush.practice.basicsandroidarchitecturecomponent.database.db.UserDataBase;
import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;
import io.reactivex.Completable;
import io.reactivex.functions.Action;

/**
 * Created by Ayush Jain on 7/12/17.
 */

public class UserImplemented implements UserRepo {

    @Inject
    UserDataBase userDataBase;

    public UserImplemented(UserDataBase userDataBase) {
        this.userDataBase = userDataBase;
    }

    @Override
    public Completable addUser(final UserDataEntity userDataEntity) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                userDataBase.getUserDAO().insertUser(userDataEntity);
            }
        });
    }

    @Override
    public LiveData<List<UserDataEntity>> getAllUser() {
        return userDataBase.getUserDAO().festchAllUsers();
    }

    @Override
    public Completable updateUser(final UserDataEntity userDataEntity) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                userDataBase.getUserDAO().updateUser(userDataEntity);
            }
        });
    }
}
