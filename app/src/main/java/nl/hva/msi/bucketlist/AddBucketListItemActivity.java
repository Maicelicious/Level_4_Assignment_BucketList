package nl.hva.msi.bucketlist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBucketListItemActivity extends AppCompatActivity {

    private String title;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bucket_list_item);

        Button addBucketItem = findViewById(R.id.addItemButton);
        final EditText titleEditText = findViewById(R.id.title_input);
        final EditText descriptionEditText = findViewById(R.id.description_input);

        addBucketItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = titleEditText.getText().toString();
                description = descriptionEditText.getText().toString();

                Intent returnToMain = new Intent();
                returnToMain.putExtra("title", title);
                returnToMain.putExtra("description", description);
                setResult(Activity.RESULT_OK, returnToMain);
                finish();
            }
        });

    }
}
