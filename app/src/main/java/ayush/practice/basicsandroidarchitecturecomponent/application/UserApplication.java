package ayush.practice.basicsandroidarchitecturecomponent.application;

import android.app.Application;

import ayush.practice.basicsandroidarchitecturecomponent.dagger.DaggerUserComponent;
import ayush.practice.basicsandroidarchitecturecomponent.dagger.UserComponent;
import ayush.practice.basicsandroidarchitecturecomponent.dagger.UserModule;

/**
 * Created by Ayush Jain on 7/12/17.
 */

public class UserApplication extends Application {

    private final UserComponent userComponent = getMyUserComponent();

    private UserComponent getMyUserComponent() {
        return DaggerUserComponent.builder()
                .userModule(new UserModule(this))
                .build();
    }

    public UserComponent getUserComponent()
    {
        return userComponent;
    }

}
