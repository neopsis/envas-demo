/*
 * @(#)BAnalogSensorToImage.java   25.10.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.converter;

import com.neopsis.envas.demo.component.BAnalogSensor;
import com.neopsis.envas.demo.component.enums.BImageSize;

import javax.baja.alarm.ext.BAlarmState;
import javax.baja.gx.BImage;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BObject;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.BConverter;

import static javax.baja.alarm.ext.BAlarmState.offnormal;

/** Converts AnalogSensor component to image */
@NiagaraType
public class BAnalogSensorToImage extends BConverter {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.component.converter.BAnalogSensorToImage(2979906276)1.0$ @*/
    /* Generated Mon May 03 20:47:18 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BAnalogSensorToImage.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    /** Default image size */
    public BAnalogSensorToImage() {
        imageSize = BImageSize.m;
    }

    /**
     * Image size as parameter
     *
     * @param size
     */
    public BAnalogSensorToImage(BImageSize size) {
        imageSize = size;
    }

    @Override
    public BObject convert(BObject from, BObject to, Context context) {

        BAnalogSensor analogSensor = (BAnalogSensor) from;
        BAlarmState   alarmState   = analogSensor.getAlarmExt().getAlarmState();
        String        sensor       = "Temp";
        String        state;
        String        image;

        if ((alarmState.equals(offnormal))
                || (alarmState.equals(BAlarmState.fault))
                || (alarmState.equals(BAlarmState.highLimit))
                || (alarmState.equals(BAlarmState.lowLimit))) {
            state = "Fault";
        } else {
            state = "Ok";
        }

        image = sensor + state + imageSize.getDisplayTag(null) + ".png";

        return BImage.make("module://envasDemo/VAADIN/images/" + image);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Fields
    ///////////////////////////////////////////////////////////////////////////////////////////
    protected BImageSize imageSize = null;
}
