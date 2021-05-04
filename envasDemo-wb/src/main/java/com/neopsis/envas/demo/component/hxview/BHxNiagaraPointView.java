/*
 * @(#)BNvHxTest.java   28.07.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.hxview;

import com.neopsis.envas.demo.component.BAnalogSensor;

import javax.baja.hx.BHxView;
import javax.baja.hx.HxOp;
import javax.baja.io.HtmlWriter;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BObject;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.workbench.view.BWbComponentView;

/**
 * 'Classic' Hx view as the HTML replacement for the Px view. The view
 * is defined as an agent on the Px view
 */
@NiagaraSingleton
@NiagaraType(agent = @AgentOn(types = { "envasDemo:WbPointView" }))
public class BHxNiagaraPointView extends BHxView {

    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.neopsis.envas.demo.pxhxview.hxview.BHxNiagaraPointView(926629058)1.0$ @*/
/* Generated Sun May 02 13:10:07 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  public static final BHxNiagaraPointView INSTANCE = new BHxNiagaraPointView();

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHxNiagaraPointView.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public BHxNiagaraPointView() {
        super();
    }

    /**
     * Write is like {@link BWbComponentView#loadValue(BObject, Context)}
     * and writes the HTML content out.
     *
     * @param op   HxOp object encapsulating the context
     * @throws Exception
     */
    @Override
    public void write(HxOp op) throws Exception {

        op.setDynamic();

        BAnalogSensor pnt = (BAnalogSensor) op.get();
        HtmlWriter      out = op.getHtmlWriter();

        out.w("<div><b>Hx Niagara View</b>&nbsp;").w("<br/>");
        out.w("<div><b>Hx Name</b>&nbsp;").w(pnt.getName()).w("<br/>");
        out.w("<b>Hx Value</b>&nbsp;<span id=a8765>")
                .w(pnt.getOutStatusValue().valueToString(null))
                .w("</span><br/></div>");
    }

    /**
     * Updated is periodically called (polled) to update the view content.
     * In our case we find the value element by ID and replace the inner HTML.
     *
     * @param op HxOp object encapsulating the context
     * @throws Exception
     */
    @Override
    public void update(HxOp op) throws Exception {

        BAnalogSensor pnt = (BAnalogSensor) op.get();
        HtmlWriter      out = op.getHtmlWriter();

        out.w("var elem = document.getElementById('a8765');");
        out.w("elem.innerHTML = '")
                .w(pnt.getOutStatusValue().valueToString(null))
                .w("';");
    }
}
