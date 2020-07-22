/*
 * @(#)BNvHistoryDemo.java   25.04.2014
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo;

import com.neopsis.envas.BNvApplication;
import com.neopsis.envas.NvUI;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Demo Application provider
 *
 */
@NiagaraType
public class BEnvasDemo extends BNvApplication {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.BEnvasDemo(2979906276)1.0$ @*/
    /* Generated Mon Jul 06 14:38:09 CEST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BEnvasDemo.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public BEnvasDemo() {}

    public String getApplicationName() {
        return "Envas Demo";
    }

    public String getApplicationDescription() {
        return "Envas feature sampler";
    }

    public NvUI getDesktopUI() {
        return new NvDemo();
    }

    @Override
    public String getDesktopTheme() {
        return "envas";
    }
}
