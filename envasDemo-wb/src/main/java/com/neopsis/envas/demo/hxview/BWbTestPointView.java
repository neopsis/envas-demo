/*
 * @(#)BWbTestPointView.java   30.09.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.hxview;

import javax.baja.gx.BFont;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.ui.BLabel;
import javax.baja.ui.pane.BGridPane;
import javax.baja.workbench.view.BWbComponentView;

/**
 * Px Workbench component view on the test point
 */
@NiagaraType(agent = @AgentOn(types = { "envasDemo:NvTestPoint" }))
@NiagaraProperty(
    name         = "property",
    type         = "String",
    defaultValue = ""
)
public class BWbTestPointView extends BWbComponentView {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.hxview.BWbTestPointView(3365518648)1.0$ @*/
    /* Generated Sun Jul 05 17:45:27 CEST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Property "property"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code property} property.
     * @see #getProperty
     * @see #setProperty
     */
    public static final Property property = newProperty(0, "", null);

    /**
     * Get the {@code property} property.
     * @see #property
     */
    public String getProperty() {
        return getString(property);
    }

    /**
     * Set the {@code property} property.
     * @see #property
     */
    public void setProperty(String v) {
        setString(property, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BWbTestPointView.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public BWbTestPointView() {

        BGridPane pane          = new BGridPane();
        BFont     titleFont     = BFont.make(BFont.DEFAULT, BFont.BOLD);
        BLabel    lblNameTitle  = new BLabel("Name", titleFont);
        BLabel    lblValueTitle = new BLabel("Value", titleFont);

        pane.add(null, lblNameTitle);
        pane.add(null, lblName);
        pane.add(null, lblValueTitle);
        pane.add(null, lblValue);
        setContent(pane);
    }

    @Override
    protected void doLoadValue(BObject object, Context context) throws Exception {

        if (object instanceof BNvTestPoint) {

            BNvTestPoint point = (BNvTestPoint) object;

            lblName.setText(point.getName());
            lblValue.setText(point.getOutStatusValue().valueToString(null));
        }
    }

    @Override
    public void handleComponentEvent(BComponentEvent event) {

        if ((event.getId() == BComponentEvent.PROPERTY_CHANGED) && event.getSlotName().equals("out")) {

            BComponent point = event.getSourceComponent();

            if (point instanceof BNvTestPoint) {

                lblValue.setText(((BNvTestPoint) point).getOutStatusValue().valueToString(null));
                lblName.setText(point.getName());
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Fields
    ///////////////////////////////////////////////////////////////////////////////////////////
    BLabel lblName  = new BLabel("");
    BLabel lblValue = new BLabel("");
}
