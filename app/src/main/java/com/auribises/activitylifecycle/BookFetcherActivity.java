package com.auribises.activitylifecycle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class BookFetcherActivity extends AppCompatActivity {

    StringBuilder builder;

    TextView txtResponse;
    ArrayList<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_fetcher);

        builder = new StringBuilder();

        txtResponse = findViewById(R.id.textViewResponse);

        bookList = new ArrayList<>();

        new BookFetchTask().execute();
        //new BookFetchThread().start();

    }


    /*private class BookFetchThread extends Thread{

        public void run(){

        }
    }*/

    class BookFetchTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {

            try {

                URL url = new URL("http://www.json-generator.com/api/json/get/chQLxhBjaW?indent=2");

                // Sending the Request
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                // Reading the Response
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line = "";
                while((line = bufferedReader.readLine())!=null){
                    builder.append(line+"\n");
                }


            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            txtResponse.setText(builder.toString());

            try {
                JSONObject jsonObject = new JSONObject(builder.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("bookstore");


                String p="",n="",a="";
                for(int i=0;i<jsonArray.length();i++){

                    JSONObject jObj = jsonArray.getJSONObject(i);
                    p = jObj.getString("price");
                    n = jObj.getString("name");
                    a = jObj.getString("author");

                    Book book = new Book(p,n,a);
                    bookList.add(book);
                }


                // Further Pass the bookList in a custom adapter and show the same

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            txtResponse.setText("Please Wait...");
        }
    }
}
