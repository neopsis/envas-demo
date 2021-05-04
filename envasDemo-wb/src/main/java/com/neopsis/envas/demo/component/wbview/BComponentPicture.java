/*
 * @(#)BComponentPicture.java   13.04.2018
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.wbview;

import javax.baja.gx.BImage;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.ui.BPicture;
import javax.baja.ui.BValueBinding;
import javax.baja.util.BConverter;

/**
 * Niagara {@link BPicture} extension with overloaded preferred size computation.
 */
@NiagaraType
public class BComponentPicture extends BPicture {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.component.wbview.BComponentPicture(2979906276)1.0$ @*/
    /* Generated Mon May 03 20:47:18 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BComponentPicture.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    /**
     * Parameterless constructor
     */
    public BComponentPicture() {

        //
    }

    /**
     * Preferred size calculation
     */
    @Override
    public void computePreferredSize() {

        BValueBinding bnd    = (BValueBinding) get("i");
        BConverter    conv   = (BConverter) bnd.get("image");
        BOrd          source = bnd.getOrd();
        BComponent    comp   = (BComponent) source.resolve().get();
        BImage        image  = (BImage) conv.convert(comp, null, new BasicContext(null, (BFacets) comp.get("facets")));

        try {
            image.syncDimensions();
        } catch (Exception e) {}

        this.setPreferredSize(image.getWidth() + 0.0, image.getHeight() + 0.0);
    }
}
