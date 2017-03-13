package donata.sandelys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class ItemDetailsActivity extends AppCompatActivity {
	public static final String TITLE_KEY       = "title_key";
	public static final String PRICE_KEY       = "price_key";
	public static final String DESCRIPTION_KEY = "description_key";

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String title = getIntent().getStringExtra(TITLE_KEY);
		String description = getIntent().getStringExtra(DESCRIPTION_KEY);
		float price = getIntent().getFloatExtra(PRICE_KEY, 0f);

		setContentView(R.layout.activity_item_details);

		((TextView) findViewById(R.id.price)).setText(String.valueOf(price) + "€");
		((TextView) findViewById(R.id.description)).setText(description);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setTitle(title);
	}


	@Override public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
		}

		return super.onOptionsItemSelected(item);
	}
}
