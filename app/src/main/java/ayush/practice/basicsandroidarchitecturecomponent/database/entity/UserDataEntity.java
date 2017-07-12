package ayush.practice.basicsandroidarchitecturecomponent.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import static ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity.TABLE_NAME;

/**
 * Created by Ayush Jain on 7/12/17.
 */

@Entity(tableName = TABLE_NAME)
public class UserDataEntity implements Parcelable{

    public static final String TABLE_NAME = "users";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userEmail;
    private String userFaceBook;
    private String userTwitter;
    private String userLinkedin;
    private int userContactNumber;

    protected UserDataEntity(Parcel in) {
        id = in.readInt();
        userEmail = in.readString();
        userFaceBook = in.readString();
        userTwitter = in.readString();
        userLinkedin = in.readString();
        userContactNumber = in.readInt();
        userName = in.readString();
    }

    public static final Creator<UserDataEntity> CREATOR = new Creator<UserDataEntity>() {
        @Override
        public UserDataEntity createFromParcel(Parcel in) {
            return new UserDataEntity(in);
        }

        @Override
        public UserDataEntity[] newArray(int size) {
            return new UserDataEntity[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public UserDataEntity() {
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFaceBook() {
        return userFaceBook;
    }

    public void setUserFaceBook(String userFaceBook) {
        this.userFaceBook = userFaceBook;
    }

    public String getUserTwitter() {
        return userTwitter;
    }

    public void setUserTwitter(String userTwitter) {
        this.userTwitter = userTwitter;
    }

    public String getUserLinkedin() {
        return userLinkedin;
    }

    public void setUserLinkedin(String userLinkedin) {
        this.userLinkedin = userLinkedin;
    }

    public int getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(int userContactNumber) {
        this.userContactNumber = userContactNumber;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(userEmail);
        parcel.writeString(userFaceBook);
        parcel.writeString(userTwitter);
        parcel.writeString(userLinkedin);
        parcel.writeInt(userContactNumber);
        parcel.writeString(userName);
    }
}
