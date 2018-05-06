package com.example.android.abndp6guardiannewsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Efehan on 17.4.2018.
 */

public class NewsAdapter extends ArrayAdapter<NewsClass> {

    private static final String TITLE_SEPARATOR = "|";
    String articleTitle;
    String articleAuthor;


    public NewsAdapter(Activity context, ArrayList<NewsClass> News) {
        super(context, 0, News);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsClass news = getItem(position);
        String title = news.getTitle();

        if (articleTitle.contains(TITLE_SEPARATOR)) {
            String[] parts = articleTitle.split(TITLE_SEPARATOR);
            articleTitle = parts[0] + TITLE_SEPARATOR;
            articleAuthor = parts[1];
        } else {
            articleTitle = title;
        }


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);


        }
        TextView articleTitle = listItemView.findViewById(R.id.title);
        articleTitle.setText(news.getTitle());

        TextView section = listItemView.findViewById(R.id.pillarName);
        section.setText(news.getSection());

        TextView date = listItemView.findViewById(R.id.date);
        date.setText(news.getDate());

        TextView articleAuthor = listItemView.findViewById(R.id.articleAuthor);
        articleAuthor.setText(news.getAuthor());

        return listItemView;

    }
}