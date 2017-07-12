package ayush.practice.basicsandroidarchitecturecomponent.gui.AddUsers;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ayush.practice.basicsandroidarchitecturecomponent.R;
import ayush.practice.basicsandroidarchitecturecomponent.application.UserApplication;
import ayush.practice.basicsandroidarchitecturecomponent.dagger.UserModelFactory;

public class AddUserActivity extends AppCompatActivity {

    private EditText editTextUserName, editTextUserNumber, editTextUserEmail, editTextUserFaceBook, editTextUserTwitter, editTextUserLinkedin;
    private Button buttonSaveAction;
    private AddUserModel adduserModel;
    private View.OnClickListener saveButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isInfoCorrect()) {
                adduserModel.addUser();
                finish();
            }
            else
                Toast.makeText(AddUserActivity.this, "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
        }
    };

    private boolean isInfoCorrect() {
        if(editTextUserName.getText().length() > 0 &&
                editTextUserNumber.getText().length() > 0 &&
                editTextUserEmail.getText().length() > 0 &&
                editTextUserFaceBook.getText().length() > 0 &&
                editTextUserTwitter.getText().length() > 0 &&
                editTextUserLinkedin.getText().length() > 0)
            return true;

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        bindAllViews();
        setUpViewModel();
        attachTextWatcher();
    }

    private void setUpViewModel() {
        UserApplication userApplication = (UserApplication)getApplication();
        adduserModel = ViewModelProviders.of(this,new UserModelFactory(userApplication)).get(AddUserModel.class);
    }

    private void bindAllViews() {
        editTextUserName     = (EditText)findViewById(R.id.editTextUserName);
        editTextUserNumber   = (EditText) findViewById(R.id.editTextUserNumber);
        editTextUserEmail    = (EditText)findViewById(R.id.editTextUserEmail);
        editTextUserFaceBook = (EditText) findViewById(R.id.editTextUserFaceBook);
        editTextUserTwitter  = (EditText)findViewById(R.id.editTextUserTwitter);
        editTextUserLinkedin = (EditText) findViewById(R.id.editTextUserLinkedin);
        buttonSaveAction     = (Button) findViewById(R.id.saveUser);

        buttonSaveAction.setOnClickListener(saveButtonListener);
    }

    private void attachTextWatcher() {
        editTextUserEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adduserModel.setUserEmail(editable.toString());
            }
        });

        editTextUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adduserModel.setUserNameData(editable.toString());
            }
        });

        editTextUserNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    adduserModel.setUserContactNumber(Integer.parseInt(editable.toString()));
                }
                catch (NumberFormatException e)
                {
                    Log.e("afterTextChanged: ", "Limit exceeded");
                }
            }
        });

        editTextUserFaceBook.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adduserModel.setUserFaceBook(editable.toString());
            }
        });

        editTextUserTwitter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adduserModel.setUserTwitter(editable.toString());
            }
        });

        editTextUserLinkedin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adduserModel.setUserLinkedin(editable.toString());
            }
        });
    }
}
