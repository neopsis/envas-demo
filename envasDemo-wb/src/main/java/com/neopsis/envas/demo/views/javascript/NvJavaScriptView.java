/*
 * @(#)NvElementsView.java   06.07.2020
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.views.javascript;

import com.neopsis.envas.demo.javascript.PdfThumbnail;
import com.neopsis.envas.demo.views.NvView;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import java.io.IOException;

import java.net.URL;

/**
 * Class description
 *
 *
 * @version        1.0.0, 06.07.2020
 * @author         Robert Carnecky
 */
public class NvJavaScriptView extends NvView {

    private final PdfThumbnail pdfThumbnail = new PdfThumbnail();
    private final String       exampleUrl   = "./VAADIN/pdf/example.pdf";

    public NvJavaScriptView() {

        final VerticalLayout layout = new VerticalLayout();

        layout.setMargin(true);
        layout.setSpacing(true);
        addComponent(layout);
        pdfThumbnail.setUrl(exampleUrl);
        pdfThumbnail.setPreviewWidth(400);
        pdfThumbnail.setWidth("300px");
        pdfThumbnail.setHeight("300px");
        layout.addComponent(pdfThumbnail);
        layout.addComponent(new Button("DownloadResource",
            e -> {
                pdfThumbnail.setPreviewWidth(0);
                pdfThumbnail.setPreviewHeight(500);
                pdfThumbnail.setLink(true);
                Notification.show("Resource now with Link");
                pdfThumbnail.setResource(new DownloadStreamResource("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
            }));
        layout.addComponent(new Button("Example embedded",
            e -> {
                pdfThumbnail.setPreviewWidth(400);
                pdfThumbnail.setPreviewHeight(0);
                pdfThumbnail.setUrl(exampleUrl);
                pdfThumbnail.setLink(true);
            }));
    }

    /**
     * Class description
     *
     *
     * @version        1.0.0, 22.07.2020
     * @author         Robert Carnecky
     */
    public static class DownloadStreamResource extends StreamResource {

        private String url;

        public DownloadStreamResource(String url) {

            super((StreamSource) () -> {
                                     try {
                                         return new URL(url).openStream();
                                     } catch (IOException e) {

                                         e.printStackTrace();

                                         return null;
                                     }
                                 }, "download.pdf");
        }
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {}
}
