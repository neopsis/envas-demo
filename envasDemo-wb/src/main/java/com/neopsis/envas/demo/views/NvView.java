/*
 * @(#)NvView.java   06.07.2020
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

/**
 * Master class for Envas demo views
 */
public class NvView extends VerticalLayout implements View {

    public NvView() {

        setSpacing(true);
        setMargin(true);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        //
    }
}
