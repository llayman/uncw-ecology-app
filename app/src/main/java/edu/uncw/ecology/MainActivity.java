package edu.uncw.ecology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.list_locations)
    ListView listLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter<Location> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Location.locations);

        listLocations.setAdapter(listAdapter);

    }

    @OnItemClick(R.id.list_locations)
    public void openLocation(View view, int position) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(getString(R.string.intent_location_to_open), Parcels.wrap(Location.locations[position]));
        startActivity(intent);

    }
}
