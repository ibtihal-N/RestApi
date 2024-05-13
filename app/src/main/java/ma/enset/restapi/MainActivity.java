package ma.enset.restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import ma.enset.restapi.activities.BookDetailActivity;
import ma.enset.restapi.adapters.BookAdapter;
import ma.enset.restapi.models.Book;
import ma.enset.restapi.models.GoogleBoooksResponse;
import ma.enset.restapi.services.GoogleBooksService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listViewBooks;
    Button buttonSearch;
    EditText editTextQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Book> books;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        books = new ArrayList<>();
        BookAdapter bookBookAdapter=new BookAdapter(this, R.layout.list_book_item, books);
         listViewBooks = findViewById(R.id.listViewBooks);
         buttonSearch = findViewById(R.id.buttonSearch);
         editTextQuery = findViewById(R.id.editTextQuery);
        listViewBooks.setAdapter(bookBookAdapter);


        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        buttonSearch.setOnClickListener(view ->{
            String query=editTextQuery.getText().toString();



        GoogleBooksService booksService=retrofit.create(GoogleBooksService.class);

        Call<GoogleBoooksResponse> call = booksService.searchBooks(query);
        call.enqueue(new Callback<GoogleBoooksResponse>() {
            @Override
            public void onResponse(Call<GoogleBoooksResponse> call, Response<GoogleBoooksResponse> response) {

               GoogleBoooksResponse boooksResponse = response.body();
               books.clear();
               books.addAll(boooksResponse.getItems());
               bookBookAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GoogleBoooksResponse> call, Throwable throwable) {
                throwable.printStackTrace();
               // Toast.makeText(MainActivity.this, "Erreur de connexion", Toast.LENGTH_SHORT);
            }
        });
        });

        listViewBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent(getApplicationContext(), BookDetailActivity.class);
                 intent.putExtra("book",  books.get(position));
                 startActivity(intent);
            }
        });

    }
}