package com.example.dkim.bp_app;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {


    public OverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity())
                .setActionBarTitle("Overview");

        //draw sample graph
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(0, 3),
                new DataPoint(1, 5),
                new DataPoint(1, 10),
                new DataPoint(2, 3),
                new DataPoint(2, 2),
                new DataPoint(3, 6),
                new DataPoint(3, 8),
        });
        GraphView graph = (GraphView) view.findViewById(R.id.graph);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-1);
        graph.getViewport().setMaxX(5);
        graph.getViewport().setMaxY(12);
        graph.getViewport().setMinY(-2);
        graph.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        series.setShape(PointsGraphSeries.Shape.RECTANGLE);
        series.setSize(10);
        series.setColor(Color.rgb(229,115,115));
        graph.addSeries(series);
        return view;


    }

}
