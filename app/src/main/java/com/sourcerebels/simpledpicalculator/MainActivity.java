package com.sourcerebels.simpledpicalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.sourcerebels.simpledpicalculator.adapter.DensitiesAdapter;
import com.sourcerebels.simpledpicalculator.adapter.ResultsAdapter;
import com.sourcerebels.simpledpicalculator.model.DpiCalculator;
import com.sourcerebels.simpledpicalculator.model.ScreenDensity;

import org.lucasr.twowayview.TwoWayView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * MainActivity.
 */
public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener, TextView.OnEditorActionListener {

    private static final ScreenDensity DEFAULT_SCREEN_DENSITY = ScreenDensity.MDPI;

    @InjectView(R.id.list)
    TwoWayView mList;

    @InjectView(R.id.edt_pixels)
    EditText mEdtPixels;

    @InjectView(R.id.sp_densities)
    Spinner mSpDensities;

    ResultsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initialize();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initialize() {

        mSpDensities.setAdapter(new DensitiesAdapter(this));
        mAdapter = new ResultsAdapter(this);
        mList.setAdapter(mAdapter);
        mSpDensities.setSelection(DEFAULT_SCREEN_DENSITY.ordinal());
        mSpDensities.setOnItemSelectedListener(this);
        mEdtPixels.setOnEditorActionListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        calculate();
    }

    private void calculate() {

        ScreenDensity density = (ScreenDensity) mSpDensities.getSelectedItem();

        if (TextUtils.isEmpty(mEdtPixels.getText())) {

            mEdtPixels.setText(String.valueOf(0));
        }
        mAdapter.setResults(DpiCalculator.calculate(density, Float.valueOf(mEdtPixels.getText().toString())));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        // Do nothing
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_SEARCH) {

            InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(mEdtPixels.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            calculate();
            return true;
        }
        return false;
    }
}
