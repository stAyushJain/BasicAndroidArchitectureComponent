package ayush.practice.basicsandroidarchitecturecomponent.dagger;

import javax.inject.Singleton;

import ayush.practice.basicsandroidarchitecturecomponent.gui.AddUsers.AddUserModel;
import ayush.practice.basicsandroidarchitecturecomponent.gui.profileList.AllUserModel;
import dagger.Component;

/**
 * Created by Ayush Jain on 7/12/17.
 */
@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {

    void addUserInjection(AddUserModel addUserModel);
    void getAllUserInjection(AllUserModel allUserModel);


    interface injectable{
        void inject(UserComponent userComponent);
    }
}
