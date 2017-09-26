package toong.vn.mpandroidchartdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = (LineChart) findViewById(R.id.chart);

        YourData[] dataObjects = new YourData[4];
        dataObjects[0] = new YourData(-10, -10);
        dataObjects[1] = new YourData(11, 11);
        dataObjects[2] = new YourData(12, 12);
        dataObjects[3] = new YourData(15, 15);

        List<Entry> entries = new ArrayList<Entry>();

        for (YourData data : dataObjects) {

            // turn your data into Entry objects
            entries.add(new Entry(data.getX(), data.getY()));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        //        dataSet.setColor(...);
        //        dataSet.setValueTextColor(...); // styling, ...

        LineData lineData = new LineData(dataSet);

        chart.setData(lineData);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setLabelCount(25);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setGranularity(1);

        leftAxis.setDrawZeroLine(true);
        leftAxis.setZeroLineWidth(5);
        leftAxis.setZeroLineColor(Color.RED);

        chart.invalidate(); // refresh
    }
}
