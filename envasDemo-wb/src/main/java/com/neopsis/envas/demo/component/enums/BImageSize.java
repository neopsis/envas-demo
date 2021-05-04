/*
 * @(#)BPointShapeSize.java   07.12.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.enums;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * All images are designed in five sizes - S, M, L, XL, XXL
 */
@NiagaraType
@NiagaraEnum(range = {
    @Range("s") , @Range("m") , @Range("l") , @Range("xl") , @Range("xxl")
}, defaultValue = "m")
public final class BImageSize extends BFrozenEnum {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.component.enums.BImageSize(1821590741)1.0$ @*/
    /* Generated Mon May 03 20:47:18 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    /** Ordinal value for s. */
    public static final int S = 0;

    /** Ordinal value for m. */
    public static final int M = 1;

    /** Ordinal value for l. */
    public static final int L = 2;

    /** Ordinal value for xl. */
    public static final int XL = 3;

    /** Ordinal value for xxl. */
    public static final int XXL = 4;

    /** BImageSize constant for s. */
    public static final BImageSize s = new BImageSize(S);

    /** BImageSize constant for m. */
    public static final BImageSize m = new BImageSize(M);

    /** BImageSize constant for l. */
    public static final BImageSize l = new BImageSize(L);

    /** BImageSize constant for xl. */
    public static final BImageSize xl = new BImageSize(XL);

    /** BImageSize constant for xxl. */
    public static final BImageSize xxl = new BImageSize(XXL);

    /** Factory method with ordinal. */
    public static BImageSize make(int ordinal) {
        return (BImageSize) s.getRange().get(ordinal, false);
    }

    /** Factory method with tag. */
    public static BImageSize make(String tag) {
        return (BImageSize) s.getRange().get(tag);
    }

    /** Private constructor. */
    private BImageSize(int ordinal) {
        super(ordinal);
    }

    public static final BImageSize DEFAULT = m;

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BImageSize.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    /**
     * Make tags a bit human friendly
     *
     * @param context
     * @return tag string
     */
    @Override
    public String getDisplayTag(Context context) {

        if (this.getOrdinal() == S) {
            return "S";
        } else if (this.getOrdinal() == M) {
            return "M";
        } else if (this.getOrdinal() == L) {
            return "L";
        } else if (this.getOrdinal() == XL) {
            return "XL";
        } else if (this.getOrdinal() == XXL) {
            return "XXL";
        }

        return "default";
    }
}
