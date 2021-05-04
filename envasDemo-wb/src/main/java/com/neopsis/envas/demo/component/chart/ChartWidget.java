/*
 * @(#)PopupButtonLayout.java   10.08.2016
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.chart;

import com.neopsis.envas.amcharts.NvAmChart;
import com.neopsis.envas.amcharts.providers.history.BNvHistoryChartInfo;
import com.neopsis.envas.amcharts.providers.history.NvHistoryAmChartConfigProvider;
import com.neopsis.envas.demo.component.BAnalogSensor;
import com.neopsis.envas.ui.fieldeditors.NvAbsTimeFE;
import com.neopsis.envas.ui.fieldeditors.NvFrozenEnumFE;
import com.tridium.bql.util.BDynamicTimeRange;
import com.tridium.bql.util.BDynamicTimeRangeType;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.baja.sys.BAbsTime;
import javax.baja.sys.BRelTime;
import java.util.ArrayList;

/**
 * Envas chart widget for {@link BAnalogSensor}
 *
 */
public class ChartWidget extends VerticalLayout {

    public ChartWidget(BAnalogSensor comp) {

        super();

        VerticalLayout chartLayout       = new VerticalLayout();
        VerticalLayout rangeEditorLayout = new VerticalLayout();
        GridLayout     buttonLayout      = new GridLayout(3, 1);
        Button         refreshButton     = new Button("Refresh");
        BAbsTime       timeFrom          = BAbsTime.now().subtract(BRelTime.makeHours(8));
        BAbsTime       timeTo            = BAbsTime.now();

        /*
         * Developers: log chart JavaScript into the browser console
         * chart.setJsLoggingEnabled(true);
         */

        /*
         * Chart component initialization
         */
        ArrayList<BNvHistoryChartInfo> chartInfo = comp.getChartInfos();

        chart = new NvAmChart();
        chart.setSizeFull();
        configProvider = new NvHistoryAmChartConfigProvider(chartInfo, BDynamicTimeRange.TODAY);
        chart.setConfigProvider(configProvider);

        /*
         * Refresh button
         */
        refreshButton.addClickListener(
            clickEvent -> {
                BDynamicTimeRangeType newRangeType = timeRangeFE.getValue();
                BDynamicTimeRange     newRange;

                if (newRangeType == BDynamicTimeRangeType.timeRange) {
                    newRange = BDynamicTimeRange.make(timeFromFE.getValue(), timeToFE.getValue());
                } else {
                    newRange = BDynamicTimeRange.make(newRangeType);
                }

                try {
                    configProvider.updateChart(newRange);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        refreshButton.setStyleName(ValoTheme.BUTTON_SMALL);

        /*
         * Time selector
         */
        timeFromFE.setValue(timeFrom);
        timeToFE.setValue(timeTo);
        timeFromFE.setVisible(false);
        timeToFE.setVisible(false);
        timeFromFE.setBuffered(false);
        timeToFE.setBuffered(false);
        timeRange   = BDynamicTimeRange.TODAY;
        timeRangeFE = new NvFrozenEnumFE<>(BDynamicTimeRangeType.class);
        timeRangeFE.setValue(timeRange.getRangeType());
        timeRangeFE.setBuffered(false);
        timeRangeFE.setImmediate(true);
        timeRangeFE.addValueChangeListener(
            event -> {
                BDynamicTimeRangeType newRangeType = timeRangeFE.getValue();
                BDynamicTimeRange     newRange;

                if (newRangeType == BDynamicTimeRangeType.timeRange) {

                    timeFromFE.setVisible(true);
                    timeToFE.setVisible(true);
                    newRange = BDynamicTimeRange.make(timeFromFE.getValue(), timeToFE.getValue());

                } else {

                    timeFromFE.setVisible(false);
                    timeToFE.setVisible(false);
                    newRange = BDynamicTimeRange.make(newRangeType);
                }

                try {
                    configProvider.updateChart(newRange);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        /*
         * Button layout with refresh button and time range selector
         */
        rangeEditorLayout.addComponent(timeFromFE);
        rangeEditorLayout.addComponent(timeToFE);
        rangeEditorLayout.setSpacing(true);
        buttonLayout.setMargin(true);
        buttonLayout.setSpacing(true);
        buttonLayout.setHeightUndefined();
        buttonLayout.addComponent(refreshButton);
        buttonLayout.addComponent(timeRangeFE);
        buttonLayout.addComponent(rangeEditorLayout);
        buttonLayout.setComponentAlignment(refreshButton, Alignment.MIDDLE_CENTER);
        buttonLayout.setComponentAlignment(timeRangeFE, Alignment.MIDDLE_CENTER);
        buttonLayout.setComponentAlignment(rangeEditorLayout, Alignment.MIDDLE_CENTER);

        /*
         * Chart layout
         */
        chartLayout.addComponent(chart);
        chartLayout.setSizeFull();

        /*
         * Place all on main layout
         */
        addComponent(buttonLayout);
        addComponent(chartLayout);
        setExpandRatio(chartLayout, 1.0f);
        setSizeFull();
        setMargin(true);
        setSpacing(true);
    }

    /**
     * Returns chart reference
     *
     * @return
     */
    public Component getChart() {
        return chart;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Fields
    ////////////////////////////////////////////////////////////////////////////////
    private NvAmChart                      chart;
    private NvHistoryAmChartConfigProvider configProvider;
    private BDynamicTimeRange              timeRange;
    NvFrozenEnumFE<BDynamicTimeRangeType>  timeRangeFE;
    NvAbsTimeFE                            timeFromFE = new NvAbsTimeFE();
    NvAbsTimeFE                            timeToFE   = new NvAbsTimeFE();
}
