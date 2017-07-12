package ayush.practice.basicsandroidarchitecturecomponent.dagger;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import ayush.practice.basicsandroidarchitecturecomponent.application.UserApplication;
import ayush.practice.basicsandroidarchitecturecomponent.database.db.UserDataBase;
import ayush.practice.basicsandroidarchitecturecomponent.repository.UserImplemented;
import ayush.practice.basicsandroidarchitecturecomponent.repository.UserRepo;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ayush Jain on 7/12/17.
 */

@Module
public class UserModule {

    private UserApplication userApplication;

    public UserModule(UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    @Provides
    Context getApplicationContext(){return userApplication;}

    @Provides
    @Singleton
    UserRepo getUserRepository(UserDataBase userDataBase){ return new UserImplemented(userDataBase);}

    @Provides
    @Singleton
    UserDataBase getUserDataBase(Context context){
        return Room.databaseBuilder(context.getApplicationContext(),UserDataBase.class,"USER_DB").build();
    }
}
