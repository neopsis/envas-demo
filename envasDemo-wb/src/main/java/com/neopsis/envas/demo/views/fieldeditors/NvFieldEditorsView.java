/*
 * @(#)NvFieldEditorsView.java   06.07.2020
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.views.fieldeditors;

import com.neopsis.envas.demo.views.NvView;
import com.neopsis.envas.ui.fieldeditors.NvAbsTimeFE;
import com.neopsis.envas.ui.fieldeditors.NvBooleanBoxFE;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

import javax.baja.sys.BFacets;
import javax.baja.sys.Sys;
import javax.baja.user.BUser;
import javax.baja.user.BUserService;

/**
 * Class description
 *
 *
 * @version        1.0.0, 06.07.2020
 * @author         Robert Carnecky
 */
public class NvFieldEditorsView extends NvView {

    public NvFieldEditorsView() {

        HorizontalLayout selectorLayout = new HorizontalLayout();
        BUserService     userService    = (BUserService) Sys.getService(BUserService.TYPE);
        BUser[]          users          = userService.getChildren(BUser.class);
        Label            lblSelector    = new Label("<h3><b>User</b></h3>", ContentMode.HTML);

        userSelector = new ComboBox();
        userSelector.setNullSelectionAllowed(false);
        userSelector.setNewItemsAllowed(false);

        for (BUser user : users) {

            Object itemId = userSelector.addItem(user);

            userSelector.setItemCaption(itemId, user.getUsername());
        }

        userSelector.addValueChangeListener(new Property.ValueChangeListener() {

                    @Override
                    public void valueChange(Property.ValueChangeEvent event) {

                        selectedUser = (BUser) event.getProperty().getValue();
                        fieldGroup.setItemDataSource(selectedUser);
                    }

                });
        userSelector.setValue(users[0]);
        selectedUser = users[0];
        selectorLayout.addComponents(lblSelector, userSelector);
        selectorLayout.setComponentAlignment(lblSelector, Alignment.MIDDLE_RIGHT);
        selectorLayout.setComponentAlignment(userSelector, Alignment.MIDDLE_LEFT);
        selectorLayout.setSpacing(true);
        selectorLayout.setMargin(true);
        addComponent(selectorLayout);

        FormLayout details = new FormLayout();

        details.setWidth("100%");
        addComponent(details);
        setExpandRatio(details, 1);
        fullName   = new TextField("Full Name");
        enabled    = new NvBooleanBoxFE("Enabled");
        lockOut    = new NvBooleanBoxFE("Lock Out");
        expiration = new NvAbsTimeFE("Expiration");
        expiration.setFacets(BFacets.make(BFacets.SHOW_TIME, false));
        expiration.setFacets(BFacets.make("timeFormat", "DD.MM.YYYY"));
        details.addComponents(fullName, enabled, lockOut, expiration);
        emailField      = new TextField("Email");
        cellPhoneNumber = new TextField("Phone");
        language        = new TextField("Language");
        emailField.setNullRepresentation("");
        cellPhoneNumber.setNullRepresentation("");
        language.setNullRepresentation("");
        details.addComponents(emailField, cellPhoneNumber, language);
        fieldGroup.bindMemberFields(this);
        fieldGroup.setItemDataSource(selectedUser);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {}

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Fields
    ///////////////////////////////////////////////////////////////////////////////////////////
    private final BeanFieldGroup<BUser> fieldGroup = new BeanFieldGroup<BUser>(BUser.class);

    /*
     * Fields for editing the User object are defined here as class members.
     * They are later bound to a FieldGroup by calling
     * fieldGroup.bindMemberFields(this). The Fields' values don't need to be
     * explicitly set, calling fieldGroup.setItemDataSource(user) synchronizes
     * the fields with the user object.
     */
    @PropertyId("fullName")
    private TextField      fullName;
    @PropertyId("enabled")
    private NvBooleanBoxFE enabled;
    @PropertyId("lockOut")
    private NvBooleanBoxFE lockOut;
    @PropertyId("expiration")
    private NvAbsTimeFE    expiration;
    @PropertyId("cellPhoneNumber")
    private TextField      cellPhoneNumber;
    @PropertyId("email")
    private TextField      emailField;
    @PropertyId("language")
    private TextField      language;
    Panel                  panel;
    BUser                  selectedUser;
    ComboBox               userSelector;
    TextField              feFullName = new TextField("Full Name");
    TextField              feEmail    = new TextField("Email");
}
