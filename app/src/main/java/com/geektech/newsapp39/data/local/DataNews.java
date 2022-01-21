package com.geektech.newsapp39.data.local;

import com.geektech.newsapp39.models.News;

import java.util.ArrayList;

public class DataNews {
    private ArrayList<News> newsList;

    public DataNews() {
        newsList  = new ArrayList<>();
        /*for (int i = 0; i < 15; i++) {
            newsList.add(new News("news: " + i, 101));
        }*/
    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }
}
