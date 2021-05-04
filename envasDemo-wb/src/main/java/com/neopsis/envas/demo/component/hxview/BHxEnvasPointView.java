/*
 * @(#)BNvHxTest.java   28.07.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.hxview;

import com.neopsis.envas.NvUI;
import com.neopsis.envas.demo.component.BAnalogSensor;
import com.neopsis.envas.demo.component.wbview.BWbAnalogSensorView;
import com.neopsis.envas.ui.hx.BNvHxPxWidget;
import com.neopsis.envas.ui.hx.BNvHxView;
import com.neopsis.envas.ui.hx.INvHxView;
import com.neopsis.envas.ui.hx.NvHxPxComponentView;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

import javax.baja.hx.BHxView;
import javax.baja.hx.HxOp;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BComponentEvent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * {@link BNvHxView} is the alternative and direct replacement for Niagara's
 * {@link BHxView}.The content, in this example {@link NvHxEnvasPointView},
 * is written using Envas syntax without having to deal with HTML tags.
 * <br/>
 * The {@link BNvHxView} implementation must override the method
 * {@link BNvHxView#getNvHxView()} which returns an Envas {@link com.vaadin.ui.Component}
 * object.
 *
 */
@NiagaraSingleton
@NiagaraType(agent = @AgentOn(types = { "envasDemo:WbAnalogSensorViewX" }))
public class BHxEnvasPointView extends BNvHxPxWidget {

    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.neopsis.envas.demo.component.hxview.BHxEnvasPointView(4030846573)1.0$ @*/
/* Generated Mon May 03 17:04:35 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  public static final BHxEnvasPointView INSTANCE = new BHxEnvasPointView();

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHxEnvasPointView.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    /**
     * Returns the presentation widget
     *
     * @return Envas view
     */
    @Override
    public INvHxView getNvHxView() {
        return new NvHxEnvasPointView();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Content
    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Envas component responsible for creation of a web widget layout.
     * Handles the point value change events.
     */
    public static class NvHxEnvasPointView extends NvHxPxComponentView {

        /**
         * Creates the content of the widget using Envas {@link Label}. It's like the
         * {@link BHxView#write(HxOp)} method.
         *
         * @param ui     envas user interface reference
         * @param hxOp   Niagara HxOp object originally passed to the {@link javax.baja.hx.BHxView}
         *
         * @return envas {@link Component} that will be presented in the Niagara user interface
         */
        @Override
        public Component createWidgetContent(NvUI ui, HxOp hxOp) {

            GridLayout layout = new GridLayout(2, 2);
            Label      lblName;

            try {

                BWbAnalogSensorView sensorView = (BWbAnalogSensorView) hxOp.get();
                BAnalogSensor point = sensorView.getSensor();

                lblName = new Label(point.getName());
                lblValue.setValue(point.getOutStatusValue().valueToString(null));
                layout.addComponent(new Label("<b>Hx Envas View</b>", ContentMode.HTML));
                layout.addComponent(new Label(""));
                layout.addComponent(new Label("<b>Hx Name</b>", ContentMode.HTML));
                layout.addComponent(lblName);
                layout.addComponent(new Label("<b>Hx Value</b>", ContentMode.HTML));
                layout.addComponent(lblValue);
                layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
                layout.setSpacing(false);
                layout.setMargin(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return layout;
        }


        @Override
        protected BComponent getRegisteredComponent(HxOp op) {
            BWbAnalogSensorView sensorView = (BWbAnalogSensorView) op.get();
            return sensorView.getSensor();
        }

        /**
       * Handles all events fired on the component's slots. It's like the
       * {@link BHxView#update(HxOp)} method.
       *
       * @param event component event
       */
        @Override
        public void handleComponentEvent(BComponentEvent event) {

            if ((event.getId() == BComponentEvent.PROPERTY_CHANGED) && event.getSlotName().equals("out")) {

                BAnalogSensor point = (BAnalogSensor) event.getSourceComponent();

                NvUI.getCurrent().access(() -> lblValue.setValue(point.getOutStatusValue().valueToString(null)));
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////
        // Fields
        ///////////////////////////////////////////////////////////////////////////////////////////
        Label lblValue = new Label();
    }
}
