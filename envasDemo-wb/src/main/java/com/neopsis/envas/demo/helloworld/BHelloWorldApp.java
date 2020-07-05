/*
 * @(#)BHelloWorldApp.java   12.01.2020
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.helloworld;

import com.neopsis.envas.BNvApplication;
import com.neopsis.envas.NvUI;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Envas hello world application
 *
 */
@NiagaraType
public class BHelloWorldApp extends BNvApplication {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.helloworld.BHelloWorldApp(2979906276)1.0$ @*/
    /* Generated Wed Jul 01 23:40:05 CEST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BHelloWorldApp.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    @Override
    public String getApplicationName() {
        return "Hello World";
    }

    @Override
    public String getApplicationDescription() {
        return "Envas hello world application";
    }

    @Override
    public NvUI getDesktopUI() {
        return new HelloWorldApp();
    }
}
