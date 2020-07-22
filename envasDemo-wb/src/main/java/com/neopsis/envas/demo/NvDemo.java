/*
 * @(#)NvDemoUI.java   08.06.2016
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo;

import com.neopsis.envas.NvDesktopUI;
import com.neopsis.envas.demo.views.binding.NvBindingView;
import com.neopsis.envas.demo.views.dashboard.NvDashboardView;
import com.neopsis.envas.demo.views.elements.NvElementsView;
import com.neopsis.envas.demo.views.fieldeditors.NvFieldEditorsView;
import com.neopsis.envas.demo.views.javascript.NvJavaScriptView;
import com.neopsis.envas.demo.views.widget.NvWidgetsView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Demonstrates some Envas features. You can clone this code and
 * use it without any restriction
 *
 *
 * @version        1.0.0, 03.10.2016
 * @author         Robert Carnecky
 */
@Title("Envas Demo")
@Theme("demo")
public class NvDemo extends NvDesktopUI implements Button.ClickListener {

    public static final String DASHBOARD_VIEW     = "dashboard";
    public static final String ELEMENTS_VIEW      = "elements";
    public static final String FIELD_EDITORS_VIEW = "fieldeditors";
    public static final String BINDING_VIEW       = "binding";
    public static final String WIDGETS_VIEW       = "widgets";
    public static final String JAVASCRIPT_VIEW    = "javascript";
    private static final long  serialVersionUID   = 1L;
    private Navigator          navigator;
    private Button             elements;
    private Button             dashboard;
    private Button             fieldEditors;
    private Button             binding;
    private Button             widgets;
    private Button             javascript;

    @Override
    public void init(VaadinRequest request) {

        super.init(request);

        HorizontalLayout rootLayout = new HorizontalLayout();
        Panel            panel      = new Panel();

        // create navigator with panel as container
        // and register all views
        createNavigator(panel);
        registerViews();

        // create navigation bar on the left side
        createNavigationBar(rootLayout);
        panel.setSizeFull();
        rootLayout.addComponent(panel);
        rootLayout.setExpandRatio(panel, 1);
        rootLayout.setSizeFull();
        setContent(rootLayout);

        // navigate to Dashboard
        navigateToDefaultView();
    }

    private void navigateToDefaultView() {

        if ("".equals(navigator.getState())) {
            navigator.navigateTo(DASHBOARD_VIEW);
        }
    }

    private void registerViews() {

        navigator.addView(DASHBOARD_VIEW, NvDashboardView.class);
        navigator.addView(ELEMENTS_VIEW, NvElementsView.class);
        navigator.addView(FIELD_EDITORS_VIEW, NvFieldEditorsView.class);
        navigator.addView(BINDING_VIEW, NvBindingView.class);
        navigator.addView(WIDGETS_VIEW, NvWidgetsView.class);
        navigator.addView(JAVASCRIPT_VIEW, NvJavaScriptView.class);
    }

    private void createNavigator(Panel panel) {
        navigator = new Navigator(this, panel);
    }

    private void createNavigationBar(HorizontalLayout rootLayout) {

        VerticalLayout sideNavigation = new VerticalLayout();

        sideNavigation.setWidth("150px");
        sideNavigation.setMargin(true);
        sideNavigation.setSpacing(true);
        dashboard    = new Button("Dashboard", this);
        elements     = new Button("Elements", this);
        fieldEditors = new Button("Field Editors", this);
        binding      = new Button("Binding", this);
        widgets      = new Button("Widgets", this);
        javascript   = new Button("JavaScript", this);
        elements.setWidth("120px");
        dashboard.setWidth("120px");
        fieldEditors.setWidth("120px");
        binding.setWidth("120px");
        widgets.setWidth("120px");
        javascript.setWidth("120px");
        sideNavigation.addComponent(dashboard);
        sideNavigation.addComponent(elements);
        sideNavigation.addComponent(fieldEditors);
        sideNavigation.addComponent(binding);
        sideNavigation.addComponent(widgets);
        sideNavigation.addComponent(javascript);
        rootLayout.addComponent(sideNavigation);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {

        if (dashboard.equals(event.getButton())) {
            navigator.navigateTo(DASHBOARD_VIEW);
        } else if (elements.equals(event.getButton())) {
            navigator.navigateTo(ELEMENTS_VIEW);
        } else if (fieldEditors.equals(event.getButton())) {
            navigator.navigateTo(FIELD_EDITORS_VIEW);
        } else if (binding.equals(event.getButton())) {
            navigator.navigateTo(BINDING_VIEW);
        } else if (widgets.equals(event.getButton())) {
            navigator.navigateTo(WIDGETS_VIEW);
        } else if (javascript.equals(event.getButton())) {
            navigator.navigateTo(JAVASCRIPT_VIEW);
        }
    }
}
