package ayush.practice.basicsandroidarchitecturecomponent.gui.profileList.adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ayush.practice.basicsandroidarchitecturecomponent.R;
import ayush.practice.basicsandroidarchitecturecomponent.database.entity.UserDataEntity;
import ayush.practice.basicsandroidarchitecturecomponent.gui.profileList.ProfileListActvity;
import ayush.practice.basicsandroidarchitecturecomponent.gui.userProfile.UserProfileActivity;

/**
 * Created by Ayush Jain on 7/11/17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListHolder> {

    private Context context;
    private ArrayList<UserDataEntity> userDataEntities;

    public UserListAdapter(ArrayList<UserDataEntity> userDataEntities, Context context) {
        this.context = context;
        this.userDataEntities = userDataEntities;
    }

    @Override
    public UserListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new UserListHolder(((LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.user_info_cell,parent,false));
    }

    @Override
    public void onBindViewHolder(UserListHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UserProfileActivity.class);
                intent.putExtra("userData", userDataEntities.get(position));
                context.startActivity(intent);
            }
        });
        if(userDataEntities.size() > 0)
        {
            holder.textViewUserName.setText(userDataEntities.get(position).getUserName());
            holder.textViewUserEmail.setText(userDataEntities.get(position).getUserEmail());
            holder.textViewUserContact.setText(userDataEntities.get(position).getUserContactNumber()+"");
        }
    }

    @Override
    public int getItemCount() {
        return userDataEntities.size();
    }

    public class UserListHolder extends RecyclerView.ViewHolder{
        TextView textViewUserName, textViewUserContact, textViewUserEmail;
        public UserListHolder(View itemView) {
            super(itemView);
            textViewUserName = (TextView) itemView.findViewById(R.id.textViewUserName);
            textViewUserContact = (TextView) itemView.findViewById(R.id.textViewUserContact);
            textViewUserEmail = (TextView) itemView.findViewById(R.id.textViewUserEmail);
        }
    }

    public void setItems(ArrayList<UserDataEntity> userDataEntities)
    {
        this.userDataEntities = userDataEntities;
        notifyDataSetChanged();
    }
}
