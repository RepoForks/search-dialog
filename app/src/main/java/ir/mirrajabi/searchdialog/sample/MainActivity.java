package ir.mirrajabi.searchdialog.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.sample.models.SampleSearchModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SimpleSearchDialogCompat(MainActivity.this, "Search...",
                        "What are you looking for...?", null, createSampleData(),
                        new SearchResultListener<SampleSearchModel>() {
                            @Override
                            public void onSelected(BaseSearchDialogCompat dialog,
                                                   SampleSearchModel item, int position) {
                                Toast.makeText(MainActivity.this, item.getTitle(),
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }).show();
            }
        });
    }

    private ArrayList<SampleSearchModel> createSampleData(){
        ArrayList<SampleSearchModel> items = new ArrayList<>();
        items.add(new SampleSearchModel("First item"));
        items.add(new SampleSearchModel("Second item"));
        items.add(new SampleSearchModel("Third item"));
        items.add(new SampleSearchModel("The ultimate item"));
        items.add(new SampleSearchModel("Last item"));
        items.add(new SampleSearchModel("Lorem ipsum"));
        items.add(new SampleSearchModel("Dolor sit"));
        items.add(new SampleSearchModel("Some random word"));
        items.add(new SampleSearchModel("guess who's back"));
        return items;
    }
}
