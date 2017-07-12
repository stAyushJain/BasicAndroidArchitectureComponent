package ayush.practice.basicsandroidarchitecturecomponent.gui.profileList;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ayush.practice.basicsandroidarchitecturecomponent.application.UserApplication;
import ayush.practice.basicsandroidarchitecturecomponent.dagger.UserModelFactory;
import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;
import ayush.practice.basicsandroidarchitecturecomponent.gui.AddUsers.AddUserActivity;
import ayush.practice.basicsandroidarchitecturecomponent.R;
import ayush.practice.basicsandroidarchitecturecomponent.gui.profileList.adpter.UserListAdapter;
import ayush.practice.basicsandroidarchitecturecomponent.gui.userProfile.UserProfileActivity;


public class ProfileListActvity extends LifecycleActivity {

    private RecyclerView recyclerUserListView;
    private UserListAdapter userListAdapter;
    private TextView textViewAddUser;
    private AllUserModel allUserModel;
    private View.OnClickListener userProfileClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ProfileListActvity.this,UserProfileActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener textViewAddUserListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ProfileListActvity.this,AddUserActivity.class);
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);
        bindAllViews();
        setUpViewModel();
        attachUserList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        allUserModel.getUsersList().observe(this, new Observer<List<UserDataEntity>>() {
            @Override
            public void onChanged(@Nullable List<UserDataEntity> userDataEntities) {
                userListAdapter.setItems((ArrayList<UserDataEntity>) userDataEntities);
            }
        });
    }

    private void setUpViewModel() {
        UserApplication userApplication = (UserApplication) getApplication();
        allUserModel = ViewModelProviders.of(this, new UserModelFactory(userApplication)).get(AllUserModel.class);
    }

    private void attachUserList() {
        recyclerUserListView.setLayoutManager(new LinearLayoutManager(this));
        userListAdapter = new UserListAdapter(new ArrayList<UserDataEntity>(), this);
        recyclerUserListView.setAdapter(userListAdapter);
    }

    private void bindAllViews() {
        recyclerUserListView = (RecyclerView)findViewById(R.id.recyclerUserListView);
        textViewAddUser =(TextView)findViewById(R.id.textViewAddUser);
        textViewAddUser.setOnClickListener(textViewAddUserListener);
    }
}
