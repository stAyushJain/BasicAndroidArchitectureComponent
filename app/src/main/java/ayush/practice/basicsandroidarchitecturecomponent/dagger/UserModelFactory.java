package ayush.practice.basicsandroidarchitecturecomponent.dagger;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import ayush.practice.basicsandroidarchitecturecomponent.application.UserApplication;

/**
 * Created by Ayush Jain on 7/12/17.
 */

public class UserModelFactory extends ViewModelProvider.NewInstanceFactory {

    private UserApplication userApplication;
    public UserModelFactory(@NonNull UserApplication application) {
        this.userApplication = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        T t = super.create(modelClass);
        if(t instanceof UserComponent.injectable)
        {
            ((UserComponent.injectable) t).inject(userApplication.getUserComponent());
        }
        return t;
    }
}
