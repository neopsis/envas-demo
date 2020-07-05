/*
 * @(#)BNvHxTest.java   28.07.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.hxview;

import javax.baja.hx.BHxView;
import javax.baja.hx.HxOp;
import javax.baja.io.HtmlWriter;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * 'Classic' HxView on the TestPoint component
 */
@NiagaraType(agent = @AgentOn(types = { "envasDemo:WbTestPointView" }))
@NiagaraSingleton
public class BHxTestPointView extends BHxView {

    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.neopsis.envas.demo.hxview.BHxTestPointView(3541516958)1.0$ @*/
/* Generated Sun Jul 05 17:45:27 CEST 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  public static final BHxTestPointView INSTANCE = new BHxTestPointView();

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHxTestPointView.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public BHxTestPointView() {
        super();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Fields
    ///////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void write(HxOp op) throws Exception {

        op.setDynamic();

        BNvTestPoint pnt = (BNvTestPoint) op.get();
        HtmlWriter   out = op.getHtmlWriter();

        out.w("<div><b>Name</b>&nbsp;").w(pnt.getName()).w("<br/>");
        out.w("<b>Value</b>&nbsp;<span id=a4711>").w(pnt.getOutStatusValue().valueToString(null)).w("</span><br/></div>");
    }

    @Override
    public void update(HxOp op) throws Exception {

        BNvTestPoint pnt = (BNvTestPoint) op.get();
        HtmlWriter   out = op.getHtmlWriter();

        out.w("var elem = document.getElementById('a4711');");
        out.w("elem.innerHTML = '").w(pnt.getOutStatusValue().valueToString(null)).w("';");
    }
}
