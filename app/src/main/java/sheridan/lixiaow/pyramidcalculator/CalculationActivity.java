package sheridan.lixiaow.pyramidcalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {

    public static final String PYRAMID_EXTRA = "pyramid";
    public static final String EXTRA_MESSAGE = "decimals";
    private int decimals;

    private TextView mBaseNTextView;
    private TextView mBaseSideTextView;
    private TextView mHeightTextView;
    private TextView mBaseAreaTextView;
    private TextView mVolumeTextView;

    private Pyramid mPyramid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        Intent intent = getIntent();
        decimals = intent.getIntExtra(EXTRA_MESSAGE, 1);

        mBaseNTextView = findViewById(R.id.displayBaseN);
        mBaseSideTextView = findViewById(R.id.displayBaseSide);
        mHeightTextView = findViewById(R.id.displayHeight);
        mBaseAreaTextView = findViewById(R.id.displayBaseArea);
        mVolumeTextView = findViewById(R.id.displayVolume);

        mPyramid = (Pyramid)getIntent().getSerializableExtra(PYRAMID_EXTRA);
        display();
    }

    public void display()
    {
        if (decimals == 1)
        {
            mBaseNTextView.setText(updateBaseN(mPyramid.getBaseN()));
            mBaseSideTextView.setText(String.format("%.1f", mPyramid.getBaseSide()));
            mHeightTextView.setText(String.format("%.1f", mPyramid.getHeight()));
            mBaseAreaTextView.setText(String.format("%.1f", mPyramid.getBaseArea()));
            mVolumeTextView.setText(String.format("%.1f", mPyramid.getVolume()));
        }
        else
        {
            mBaseNTextView.setText(updateBaseN(mPyramid.getBaseN()));
            mBaseSideTextView.setText(String.format("%.3f", mPyramid.getBaseSide()));
            mHeightTextView.setText(String.format("%.3f", mPyramid.getHeight()));
            mBaseAreaTextView.setText(String.format("%.3f", mPyramid.getBaseArea()));
            mVolumeTextView.setText(String.format("%.3f", mPyramid.getVolume()));
        }
    }

    public String updateBaseN(int baseN)
    {
        String strBaseN;
        String[] baseNArray = getResources().getStringArray(R.array.polygon_array);
        switch(baseN)
        {
            case 3: strBaseN = baseNArray[0];
                break;
            case 4: strBaseN = baseNArray[1];
                break;
            case 5: strBaseN = baseNArray[2];
                break;
            case 6: strBaseN = baseNArray[3];
                break;
            default:
                strBaseN = baseNArray[0];
        }
        return strBaseN;
    }

    public void back(View v)
    {
        this.finish();
    }
}
