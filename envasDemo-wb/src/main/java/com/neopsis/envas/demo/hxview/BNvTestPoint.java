/*
 * @(#)BNvTestPoint.java   30.09.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.hxview;

import javax.baja.control.BNumericWritable;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Numeric writable point for Px/Hx View testing
 */
@NiagaraType
public class BNvTestPoint extends BNumericWritable {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.ui.hx.test.BNvTestPoint(2979906276)1.0$ @*/
    /* Generated Sat Sep 30 18:23:11 CEST 2017 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BNvTestPoint.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public BNvTestPoint() {
        super();
    }
}
