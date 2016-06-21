package com.example.roel.qstudent.Models.InformationProvider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roel.qstudent.Models.Bericht;
import com.example.roel.qstudent.Models.Post;
import com.example.roel.qstudent.R;

import java.util.List;

/**
 * Created by Maxime on 9-6-2016.
 */
public class CustomListviewAdapterAwnser extends BaseAdapter{
    private LayoutInflater inflater;
    private List<Bericht> items;

    public CustomListviewAdapterAwnser(Activity context, List<Bericht> items){
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
        Bericht item = items.get(position);
        View vi = convertView;

        if(convertView == null){
            vi = inflater.inflate(R.layout.content_post_awnsers, null);
        }

        ImageView studentFoto = (ImageView)vi.findViewById(R.id.postStudentAwnserQuestionPicture);
        TextView postTitle = (TextView)vi.findViewById(R.id.postStudentAwnserQuestionText);
        TextView studentName = (TextView)vi.findViewById(R.id.postStudentAwnserQuestionName);
        ImageButton upvote = (ImageButton)vi.findViewById(R.id.postUpVote);
        ImageButton downvote = (ImageButton)vi.findViewById(R.id.postDownVote);
        TextView punten = (TextView)vi.findViewById(R.id.postStudentPoints);

        studentFoto.setImageResource(item.getPoster());
        postTitle.setText(item.getInhoud());
        studentName.setText(item.getPostName());
        upvote.setImageResource(item.upvote);
        downvote.setImageResource(item.downvote);
        punten.setText("" + item.punten);

        return vi;
    }
}
