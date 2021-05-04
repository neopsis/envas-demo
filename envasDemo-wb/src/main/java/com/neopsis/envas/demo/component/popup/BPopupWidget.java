/*
 * @(#)BPopupWidget.java   06.11.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.popup;

import com.neopsis.envas.ux.BNvWidgetMax;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Popup View widget as agent on BAnalogSensor component is
 * a WebWidget launcher.
 *
 */
@NiagaraType(agent = @AgentOn(types = { "envasDemo:AnalogSensor" }))
public class BPopupWidget extends BNvWidgetMax {

    public static final BPopupWidget INSTANCE = new BPopupWidget();

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.component.popup.BPopupWidget(2272635904)1.0$ @*/
    /* Generated Mon May 03 17:06:16 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BPopupWidget.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
