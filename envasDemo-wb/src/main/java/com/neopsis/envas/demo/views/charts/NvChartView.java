/*
 * @(#)NvChartView.java   01.09.2020
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.views.charts;

import com.neopsis.envas.amcharts.NvAmChart;
import com.neopsis.envas.amcharts.providers.history.NvAmChartHistoryConfigProvider;
import com.neopsis.envas.charts.enums.BNvChartTypeEnum;
import com.neopsis.envas.charts.utils.BNvHistoryChartInfo;
import com.neopsis.envas.demo.views.NvView;
import com.tridium.bql.util.BDynamicTimeRange;
import com.tridium.bql.util.BDynamicTimeRangeType;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import javax.baja.naming.BOrd;
import java.util.ArrayList;

/**
 * Simple demo chart
 *
 *
 */
public class NvChartView extends NvView {

    NvAmChartHistoryConfigProvider provider;

    public NvChartView() {
        addComponent(getHistoryChartLayout());
    }

    private VerticalLayout getHistoryChartLayout() {

        final VerticalLayout layout = new VerticalLayout();

        // demo - hard coded
        BOrd                historyOrd = BOrd.make("history:/EnvasDemo/demoHistory");

        BNvHistoryChartInfo info = BNvHistoryChartInfo.make(historyOrd, BNvChartTypeEnum.line);
        ArrayList<BNvHistoryChartInfo> infos = new ArrayList<>();

        infos.add(info);
        provider = new NvAmChartHistoryConfigProvider(infos, BDynamicTimeRange.make(BDynamicTimeRangeType.today));

        NvAmChart chart = new NvAmChart(provider);

        chart.setWidth(80.0f, Unit.PERCENTAGE);
        chart.setHeight(450.0f, Unit.PIXELS);

        Button refreshButton = new Button("Refresh");

        refreshButton.addClickListener(e -> provider.refreshChart());
        layout.addComponent(chart);
        layout.addComponent(refreshButton);
        layout.setMargin(true);
        layout.setSpacing(true);

        return layout;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {}
}
