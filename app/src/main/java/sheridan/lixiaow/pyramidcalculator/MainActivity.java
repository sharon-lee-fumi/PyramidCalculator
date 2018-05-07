package sheridan.lixiaow.pyramidcalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ASG1";

    private Spinner mBaseNSpinner;
    private EditText mBaseSideEditText;
    private EditText mHeightEditText;
    private RadioGroup mDecimalRadioGroup;

    private Pyramid mPyramid;
    private double baseSide;
    private double height;
    private int decimals;

    private SharedPreferences mSharedPreferences;
    private static final String SAVED_GUI_STATE = "SavedState";
    private static final String BASEN = "BaseNSpinner";
    private static final String BASESIDE = "BaseSideEditText";
    private static final String HEIGHT = "HeightEditText";
    private static final String DECIMALS = "DecimalRadioGroup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBaseNSpinner = findViewById(R.id.baseNSpinner);
        mBaseSideEditText = findViewById(R.id.baseSideEditText);
        mHeightEditText = findViewById(R.id.heightEditText);
        mDecimalRadioGroup = findViewById(R.id.decimalRadioGroup);

        mPyramid = new Pyramid();
        mSharedPreferences = getSharedPreferences(SAVED_GUI_STATE, MODE_PRIVATE);

        Log.d(TAG, "created");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "paused");
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(BASEN, mBaseNSpinner.getSelectedItemPosition());
        editor.putString(BASESIDE, mBaseSideEditText.getText().toString());
        editor.putString(HEIGHT,  mHeightEditText.getText().toString());
        editor.putInt(DECIMALS, mDecimalRadioGroup.getCheckedRadioButtonId());
        editor.commit();
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "resumed");
        mBaseNSpinner.setSelection(mSharedPreferences.getInt(BASEN, 0));
        mBaseSideEditText.setText(mSharedPreferences.getString(BASESIDE, ""));
        mHeightEditText.setText(mSharedPreferences.getString(HEIGHT, ""));
        mDecimalRadioGroup.check(mSharedPreferences.getInt(DECIMALS, R.id.decimal_1));
    }


    public void calculate(View v)
    {
        try
        {
            baseSide = Double.parseDouble(mBaseSideEditText.getText().toString());
            height = Double.parseDouble(mHeightEditText.getText().toString());

            switch (mDecimalRadioGroup.getCheckedRadioButtonId())
            {
                case R.id.decimal_1 :
                    decimals = 1;
                    break;
                case R.id.decimal_3 :
                    decimals = 3;
                    break;
                default:
                    decimals = 1;
                    break;
            }

            mPyramid.setBaseN(mBaseNSpinner.getSelectedItemPosition() + 3);
            mPyramid.setBaseSide(baseSide);
            mPyramid.setHeight(height);

            Intent intent = new Intent(this, CalculationActivity.class);
            intent.putExtra(CalculationActivity.PYRAMID_EXTRA, mPyramid);
            intent.putExtra(CalculationActivity.EXTRA_MESSAGE, decimals);
            this.startActivity(intent);
        }
        catch(NumberFormatException e) {
            Toast.makeText(this, R.string.invalid_input, Toast.LENGTH_LONG).show();
        }
        catch(IllegalArgumentException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


}
