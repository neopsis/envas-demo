/*
 * @(#)BNvAnalogSensorPopupView.java   27.03.2021
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.popup;

import com.neopsis.envas.NvBinding;
import com.neopsis.envas.NvIComponentEventListener;
import com.neopsis.envas.NvUI;
import com.neopsis.envas.demo.component.BAnalogSensor;
import com.neopsis.envas.demo.component.chart.ChartWidget;
import com.neopsis.envas.ui.widget.BINvWidget;
import com.neopsis.envas.ui.widget.NvWidgetProperties;

import com.vaadin.server.Page;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.baja.agent.BIAgent;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BComponentEvent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Envas widget view is like the Niagara Ux view - it works in both Px and Hx/HTML
 * environments.
 *
 */
@NiagaraType(agent = @AgentOn(types = { "envasDemo:AnalogSensor" }))
public class BNvAnalogSensorPopupView extends BComponent implements BINvWidget, NvIComponentEventListener, BIAgent {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.component.popup.BNvAnalogSensorPopupView(2272635904)1.0$ @*/
    /* Generated Mon May 03 19:33:31 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BNvAnalogSensorPopupView.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    @Override
    public Component createWidgetContent(NvUI nvUI, NvWidgetProperties nvWidgetProperties) throws Exception {

        VerticalLayout layout = new VerticalLayout();

        ui     = nvUI;
        sensor = (BAnalogSensor) nvWidgetProperties.getOrd().resolve().get();

        ChartWidget chartLayout = new ChartWidget(sensor);

        layout.addComponent(chartLayout);
        layout.setSizeFull();

        return layout;
    }

    /**
     * When the popup is attached a component binding is created and registered for component events
     *
     * @param nvUI User Interface where the popup is attached
     */
    @Override
    public void attach(NvUI nvUI) {

        if (sensor != null) {

            binding = ui.registerForComponentEvents(sensor, this);
            Page.getCurrent().setTitle("Analog sensor " + sensor.getSerialNumber());
        }
    }

    /**
     * When the popup is detached the component is unregistered for events
     * @param nvUI
     */
    @Override
    public void detach(NvUI nvUI) {

        if (binding != null) {

            ui.unregisterForComponentEvents(binding);
            binding = null;
        }
    }

    public void handleComponentEvent(BComponentEvent event) {

        if ((event.getId() == BComponentEvent.PROPERTY_CHANGED) && event.getSlotName().equals("out")) {

            BAnalogSensor sensor = (BAnalogSensor) event.getSourceComponent();

            NvUI.getCurrent().access(() -> lblValue.setValue(sensor.getOutStatusValue().valueToString(null)));
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Fields
    ///////////////////////////////////////////////////////////////////////////////////////////
    private Label         lblName  = new Label();
    private Label         lblValue = new Label();
    private BAnalogSensor sensor   = null;
    private NvBinding     binding  = null;
    protected NvUI        ui       = null;
}
