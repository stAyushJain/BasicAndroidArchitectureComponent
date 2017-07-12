package ayush.practice.basicsandroidarchitecturecomponent.gui.userProfile;

import android.media.Image;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ayush.practice.basicsandroidarchitecturecomponent.R;
import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;

import static ayush.practice.basicsandroidarchitecturecomponent.gui.userProfile.UserProfileActivity.State.*;

public class UserProfileActivity extends AppCompatActivity {

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }
    private CollapsingToolbarLayout mainCollapsing;
    private AppBarLayout mainAppbar;
    private TextView tbTextViewUserName;
    private ImageView imageViewBackButton;
    private TextView textViewUserName, textViewEmailId, textViewContact, textViewEmail, textViewFaceBook, textViewTwitter, textViewLinkedin;
    private UserDataEntity userDataEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userDataEntity = getIntent().getExtras().getParcelable("userData");

        bindAllViews();
        setUpValues();
        mainAppbar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                switch (state)
                {
                    case COLLAPSED:
                        tbTextViewUserName.setVisibility(View.VISIBLE);
                        break;
                    case EXPANDED:
                        tbTextViewUserName.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        tbTextViewUserName.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

    }

    private void setUpValues() {
        if(userDataEntity != null) {
            textViewLinkedin.setText(userDataEntity.getUserLinkedin());
            textViewUserName.setText(userDataEntity.getUserName());
            textViewEmailId.setText(userDataEntity.getUserEmail());
            textViewContact.setText(userDataEntity.getUserContactNumber()+"");
            textViewEmail.setText(userDataEntity.getUserEmail());
            textViewFaceBook.setText(userDataEntity.getUserFaceBook());
            textViewTwitter.setText(userDataEntity.getUserTwitter());
            tbTextViewUserName.setText(userDataEntity.getUserName());
        }
    }

    private void bindAllViews() {
        mainCollapsing = (CollapsingToolbarLayout)findViewById(R.id.mainCollapsing);
        tbTextViewUserName = (TextView)findViewById(R.id.tbTextViewUserName);
        mainAppbar = (AppBarLayout)findViewById(R.id.mainAppbar);
        imageViewBackButton = (ImageView)findViewById(R.id.imageViewBackButton);
        textViewLinkedin = (TextView)findViewById(R.id.textViewLinkeDin);
        textViewUserName = (TextView)findViewById(R.id.textViewUserName);
        textViewEmailId = (TextView)findViewById(R.id.textViewEmailId);
        textViewContact = (TextView)findViewById(R.id.textViewContact);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);
        textViewFaceBook = (TextView)findViewById(R.id.textViewFaceBook);
        textViewTwitter = (TextView)findViewById(R.id.textViewTwitter);

        imageViewBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {



        private State mCurrentState = IDLE;

        @Override
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i == 0) {
                if (mCurrentState != EXPANDED) {
                    onStateChanged(appBarLayout, EXPANDED);
                }
                mCurrentState = EXPANDED;
            } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
                if (mCurrentState != COLLAPSED) {
                    onStateChanged(appBarLayout, COLLAPSED);
                }
                mCurrentState = COLLAPSED;
            } else {
                if (mCurrentState != IDLE) {
                    onStateChanged(appBarLayout, IDLE);
                }
                mCurrentState = IDLE;
            }
        }

        public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
    }
}
