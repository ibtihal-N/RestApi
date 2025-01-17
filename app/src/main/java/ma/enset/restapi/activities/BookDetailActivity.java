package ma.enset.restapi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import ma.enset.restapi.R;
import ma.enset.restapi.models.Book;

public class BookDetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_layout_detail);
        Intent intent=getIntent();
        Book book = (Book) intent.getSerializableExtra("book");
        TextView textViewTitle = findViewById(R.id.TextViewtitleDetails);
        TextView textViewAuthors = findViewById(R.id.TextViewAuthorsDetails);
        TextView textViewDescription = findViewById(R.id.TextViewDescriptionDetails);
        ImageView imageViewBook = findViewById(R.id.imageViwBookDetails);
        Button buttonShare = findViewById(R.id.buttonShare);
        if(book!=null) {
            textViewTitle.setText(book.getVolumeInfo().getTitle());
            textViewAuthors.setText(book.getVolumeInfo().getAuthors().toString());
           // textViewDescription.setText(book.getVolumeInfo().getDescription());
            Picasso.get().load(book.getVolumeInfo().getImageLinks().getThumbnail().replace("http://", "https://")).into(imageViewBook);
            buttonShare.setOnClickListener(view->{
                String sharedMsg="Titre:"+book.getVolumeInfo().getAuthors().toString()+"\n"
                        +"Description"+ book.getVolumeInfo().getDescription();
                Intent intent1=new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_TEXT, sharedMsg);
                startActivity(Intent.createChooser(intent1, "Partager via"));
            });
        }
    }
}
