package com.example.roel.qstudent.Models.InformationProvider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.R;

import java.util.List;

/**
 * Created by Maxime on 3-6-2016.
 */
public class CustomListviewAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private List<Post> items;

    public CustomListviewAdapter(Activity context, List<Post> items){
        super();

        this.items = items;
        this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post item = items.get(position);
        View vi = convertView;

        if(convertView == null){
            vi = inflater.inflate(R.layout.postitem_row, null);
        }

        ImageView studentFoto = (ImageView)vi.findViewById(R.id.postStudentPicture);
        TextView postTitle = (TextView)vi.findViewById(R.id.postTitle);
        TextView studentName = (TextView)vi.findViewById(R.id.postStudentName);
        TextView aantalAntwooren = (TextView)vi.findViewById(R.id.postStudenAmountOfAwnsers);

        studentFoto.setImageResource(item.foto);
        postTitle.setText(item.getNaam());
        studentName.setText(item.poster);
        aantalAntwooren.setText("" + item.aantalAntwoorden);

        return vi;
    }
}
