package com.dakaii.pathtracker;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by dnakashi on 1/5/16.
 */
public class PathView extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int CURSORLOADER_ID = 0;
    private DatabaseHelper dbHelper;
    private ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        Button buttonView = (Button) this.findViewById(R.id.buttonReturn);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        adapter = new ListAdapter(this, null, 0);
        setListAdapter(adapter);

        getLoaderManager().initLoader(CURSORLOADER_ID, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args){
        return new CursorLoader(this, PathTrackerContentProvider.CONTENT_URI, null, null, null, "_id DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor){
        adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader){
        adapter.swapCursor(null);
    }
}
