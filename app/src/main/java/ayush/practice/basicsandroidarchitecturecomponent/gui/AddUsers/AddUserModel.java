package ayush.practice.basicsandroidarchitecturecomponent.gui.AddUsers;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import javax.inject.Inject;

import ayush.practice.basicsandroidarchitecturecomponent.dagger.UserComponent;
import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;
import ayush.practice.basicsandroidarchitecturecomponent.repository.UserRepo;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ayush Jain on 7/12/17.
 */

public class AddUserModel extends ViewModel implements UserComponent.injectable{

    @Override
    public void inject(UserComponent userComponent) {
        userComponent.addUserInjection(this);
    }

    @Inject
    UserRepo userRepo;

    private MutableLiveData<String> userNameData       = new MutableLiveData<>();
    private MutableLiveData<Integer> userContactNumber = new MutableLiveData<>();
    private MutableLiveData<String> userEmail          = new MutableLiveData<>();
    private MutableLiveData<String> userFaceBook       = new MutableLiveData<>();
    private MutableLiveData<String> userTwitter        = new MutableLiveData<>();
    private MutableLiveData<String> userLinkedin       = new MutableLiveData<>();


    public String getUserNameData() {
        return userNameData.getValue();
    }

    public void setUserNameData(String userNameData) {
        this.userNameData.setValue(userNameData);
    }

    public int getUserContactNumber() {
        return userContactNumber.getValue();
    }

    public void setUserContactNumber(int userContactNumber) {
        this.userContactNumber.setValue(userContactNumber);
    }

    public String getUserEmail() {
        return userEmail.getValue();
    }

    public void setUserEmail(String userEmail) {
        this.userEmail.setValue(userEmail);
    }

    public String getUserFaceBook() {
        return userFaceBook.getValue();
    }

    public void setUserFaceBook(String userFaceBook) {
        this.userFaceBook.setValue(userFaceBook);
    }

    public String getUserTwitter() {
        return userTwitter.getValue();
    }

    public void setUserTwitter(String userTwitter) {
        this.userTwitter.setValue(userTwitter);
    }

    public String getUserLinkedin() {
        return userLinkedin.getValue();
    }

    public void setUserLinkedin(String userLinkedin) {
        this.userLinkedin.setValue(userLinkedin);
    }

    public void addUser()
    {
        UserDataEntity userDataEntity = new UserDataEntity();
        userDataEntity.setUserName(userNameData.getValue());
        userDataEntity.setUserEmail(userEmail.getValue());
        userDataEntity.setUserFaceBook(userFaceBook.getValue());
        userDataEntity.setUserLinkedin(userLinkedin.getValue());
        userDataEntity.setUserTwitter(userTwitter.getValue());
        if(userContactNumber.getValue() != null)
        userDataEntity.setUserContactNumber(userContactNumber.getValue());
        else
        userDataEntity.setUserContactNumber(1234567890);
        userDataEntity.setId(0);

        userRepo.addUser(userDataEntity).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("onComplete user added","");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("onError - add:", e.toString());
                    }
                });
    }
}
