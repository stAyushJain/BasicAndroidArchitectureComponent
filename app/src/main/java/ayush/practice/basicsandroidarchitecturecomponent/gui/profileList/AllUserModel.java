package ayush.practice.basicsandroidarchitecturecomponent.gui.profileList;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import ayush.practice.basicsandroidarchitecturecomponent.dagger.UserComponent;
import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;
import ayush.practice.basicsandroidarchitecturecomponent.repository.UserRepo;

/**
 * Created by Ayush Jain on 7/12/17.
 */

public class AllUserModel extends ViewModel implements UserComponent.injectable {

    @Inject
    UserRepo userRepo;

    private LiveData<List<UserDataEntity>> usersList = new MutableLiveData<>();
    @Override
    public void inject(UserComponent userComponent) {
        userComponent.getAllUserInjection(this);
        usersList = userRepo.getAllUser();
    }

    public LiveData<List<UserDataEntity>> getUsersList() {
        return usersList;
    }
}
