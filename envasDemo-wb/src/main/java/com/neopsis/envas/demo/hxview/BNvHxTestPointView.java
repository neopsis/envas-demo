/*
 * @(#)BNvHxTest.java   28.07.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.hxview;

import com.neopsis.envas.NvUI;
import com.neopsis.envas.ui.hx.BNvHxView;
import com.neopsis.envas.ui.hx.INvHxView;
import com.neopsis.envas.ui.hx.NvHxComponentView;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

import javax.baja.hx.HxOp;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponentEvent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Envas HxView on the TestPointComponent
 */
@NiagaraType(agent = @AgentOn(types = { "envasDemo:WbTestPointView" }))
@NiagaraSingleton
public class BNvHxTestPointView extends BNvHxView {

    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.neopsis.envas.demo.hxview.BNvHxTestPointView(3541516958)1.0$ @*/
/* Generated Sun Jul 05 17:45:27 CEST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  public static final BNvHxTestPointView INSTANCE = new BNvHxTestPointView();

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNvHxTestPointView.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    /**
     * Returns the object responsible for widget management in the Envas
     *
     * @return Envas view
     */
    @Override
    public INvHxView getNvHxView() {
        return new NvHxTestPointView();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Implementation
    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Instances of this class are responsible for web widget creating a
     * handle the point value change events
     *
     */
    public static class NvHxTestPointView extends NvHxComponentView {

        @Override
        public Component createWidgetContent(NvUI ui, HxOp hxOp) {

            GridLayout layout = new GridLayout(2, 2);
            Label      lblName;

            try {

                BNvTestPoint point = (BNvTestPoint) hxOp.get();

                lblName = new Label(point.getName());
                lblValue.setValue(point.getOutStatusValue().valueToString(null));
                layout.addComponent(new Label("<b>Name</b>&nbsp;", ContentMode.HTML));
                layout.addComponent(lblName);
                layout.addComponent(new Label("<b>Value</b>&nbsp;", ContentMode.HTML));
                layout.addComponent(lblValue);
                layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return layout;
        }

        public void handleComponentEvent(BComponentEvent event) {

            if ((event.getId() == BComponentEvent.PROPERTY_CHANGED) && event.getSlotName().equals("out")) {

                BNvTestPoint point = (BNvTestPoint) event.getSourceComponent();

                NvUI.getCurrent().access(new Runnable() {

                                             @Override
                                             public void run() {
                                                 lblValue.setValue(point.getOutStatusValue().valueToString(null));
                                             }

                                         });
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////
        // Fields
        ///////////////////////////////////////////////////////////////////////////////////////////
        Label lblValue = new Label();
    }
}
