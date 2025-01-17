package ma.enset.restapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import ma.enset.restapi.R;
import ma.enset.restapi.models.Book;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_book_item, parent, false);
        }

        Book book = getItem(position);
        ImageView imageView = convertView.findViewById(R.id.imageViwBook);
        TextView textViewTitle = convertView.findViewById(R.id.TextViewtitleBook);
        TextView textViewAuthors = convertView.findViewById(R.id.TextViewAuthorsBook);
        TextView textViewDescription = convertView.findViewById(R.id.TextViewDescriptionBook);

        if (book != null) {
            textViewTitle.setText(book.getVolumeInfo().getTitle());
            textViewAuthors.setText(book.getVolumeInfo().getAuthors().toString());
           // textViewDescription.setText(book.getVolumeInfo().getDescription());
            Picasso.get().load(book.getVolumeInfo().getImageLinks().getThumbnail().replace("http://", "https://")).into(imageView);
        }

        return convertView;
    }
}
