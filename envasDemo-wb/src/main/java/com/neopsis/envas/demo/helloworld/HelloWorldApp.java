/*
 * @(#)HelloWorldApp.java   12.01.2020
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.helloworld;

import com.neopsis.envas.NvDesktopUI;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.baja.sys.Sys;

/**
 * My first Envas application
 *
 */
@Theme("envas")
public class HelloWorldApp extends NvDesktopUI {

    @Override
    protected void init(VaadinRequest request) {

        super.init(request);

        VerticalLayout layout     = new VerticalLayout();
        Label          lblTitle   = new Label("<h2>Welcome to your first Envas application!</h2", ContentMode.HTML);
        Label          lblStation = new Label("Your Niagara station name is " + Sys.getStation().getStationName() + ", your host name is " + Sys.getHostName());
        TextField      fldEntry   = new TextField("Please enter your name:");
        Button         btnClick   = new Button("Click me, please!");

        btnClick.addClickListener(new Button.ClickListener() {

                                      @Override
                                      public void buttonClick(Button.ClickEvent clickEvent) {

                                          String s = "Thank you, ";

                                          layout.addComponent(new Label(s + fldEntry.getValue()));
                                      }

                                  });
        layout.addComponent(lblTitle);
        layout.addComponent(lblStation);
        layout.addComponent(fldEntry);
        layout.addComponent(btnClick);
        layout.setSpacing(true);
        layout.setMargin(true);
        setContent(layout);
    }
}
