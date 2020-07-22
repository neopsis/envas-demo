package com.neopsis.envas.demo.javascript;

import com.neopsis.envas.demo.javascript.client.PdfThumbnailState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.server.Resource;
import com.vaadin.ui.AbstractJavaScriptComponent;

import java.util.Date;

/**
 * Vaadin wrapper for the pdfThumbnails(https://github.com/scandel/pdfThumbnails)<br>
 *
 * @author Marten Prieß (http://www.rocketbase.io)
 * @version 1.0
 */
@JavaScript({"vaadin://pdfThumbnails/pdf.js", "vaadin://pdfThumbnails/PdfThumbnail.js"})
public class PdfThumbnail extends AbstractJavaScriptComponent {

    public PdfThumbnail() {
        setPrimaryStyleName("pdf-thumbnail");
    }

    public void setUrl(final String url) {
        getState().url = url;
        setResource("pdf", null);
        triggerRepaint();
    }

    /**
     * will initialize a RequestHandler and set the pdf url to the handler
     *
     * @param resource
     */
    public void setResource(final Resource resource) {
        setResource("pdf", resource);
        triggerRepaint();
    }

    public void setPreviewWidth(int width) {
        getState().previewWidth = width;
        triggerRepaint();
    }

    public void setPreviewHeight(int height) {
        getState().previewHeight = height;
        triggerRepaint();
    }

    public void setLink(boolean enabled) {
        getState().link = enabled;
        triggerRepaint();
    }

    /**
     * explicitly map the custom state object to the server implementation
     *
     * @return
     */
    @Override
    protected PdfThumbnailState getState() {
        return (PdfThumbnailState) super.getState();
    }

    /**
     * used only to reinitialize the jCrop component when needed
     */
    private void triggerRepaint() {
        this.getState().triggerRepaint = String.valueOf(new Date().getTime());
    }

}
