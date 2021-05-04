/*
 * @(#)BWbAnalogSensorView.java   30.09.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component.wbview;

import com.neopsis.envas.demo.component.BAnalogSensor;
import com.neopsis.envas.demo.component.converter.BAnalogSensorToImage;
import com.neopsis.envas.demo.component.enums.BImageSize;
import com.neopsis.envas.util.NvLog;

import com.tridium.kitpx.BBoundLabel;
import com.tridium.kitpx.BBoundLabelBinding;
import com.tridium.kitpx.BPopupBinding;
import com.tridium.kitpx.enums.BStatusEffect;

import javax.baja.converters.BObjectToString;
import javax.baja.gx.BFont;
import javax.baja.gx.BImage;
import javax.baja.gx.BSize;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.ui.BPicture;
import javax.baja.ui.BValueBinding;
import javax.baja.ui.BWidget;
import javax.baja.ui.MouseCursor;
import javax.baja.ui.enums.BHalign;
import javax.baja.ui.pane.BEdgePane;
import javax.baja.util.BFormat;
import javax.baja.workbench.view.BWbView;

/**
 * Analog sensor Px view.
 *
 */
@NiagaraType(agent = @AgentOn(types = { "envasDemo:AnalogSensor" }))
@NiagaraProperty(
    name         = "imageSize",
    type         = "BImageSize",
    defaultValue = "BImageSize.DEFAULT"
)
@NiagaraProperty(
    name         = "valueFont",
    type         = "BFont",
    defaultValue = "BFont.make(\"Arial\", 12.0D, BFont.BOLD)"
)
@NiagaraProperty(
    name         = "popupSize",
    type         = "BSize",
    defaultValue = "BSize.make(400.0d, 250.0d)"
)
@NiagaraProperty(
    name         = "popupTitle",
    type         = "String",
    defaultValue = "Analog sensor"
)
@NiagaraProperty(
    name         = "popupModal",
    type         = "boolean",
    defaultValue = "false"
)
public class BWbAnalogSensorView extends BWbView {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.component.wbview.BWbAnalogSensorView(1233109369)1.0$ @*/
    /* Generated Sun May 02 23:11:18 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Property "imageSize"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code imageSize} property.
     * @see #getImageSize
     * @see #setImageSize
     */
    public static final Property imageSize = newProperty(0, BImageSize.DEFAULT, null);

    /**
     * Get the {@code imageSize} property.
     * @see #imageSize
     */
    public BImageSize getImageSize() {
        return (BImageSize) get(imageSize);
    }

    /**
     * Set the {@code imageSize} property.
     * @see #imageSize
     */
    public void setImageSize(BImageSize v) {
        set(imageSize, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Property "valueFont"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code valueFont} property.
     * @see #getValueFont
     * @see #setValueFont
     */
    public static final Property valueFont = newProperty(0, BFont.make("Arial", 12.0D, BFont.BOLD), null);

    /**
     * Get the {@code valueFont} property.
     * @see #valueFont
     */
    public BFont getValueFont() {
        return (BFont) get(valueFont);
    }

    /**
     * Set the {@code valueFont} property.
     * @see #valueFont
     */
    public void setValueFont(BFont v) {
        set(valueFont, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Property "popupSize"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code popupSize} property.
     * @see #getPopupSize
     * @see #setPopupSize
     */
    public static final Property popupSize = newProperty(0, BSize.make(400.0d, 250.0d), null);

    /**
     * Get the {@code popupSize} property.
     * @see #popupSize
     */
    public BSize getPopupSize() {
        return (BSize) get(popupSize);
    }

    /**
     * Set the {@code popupSize} property.
     * @see #popupSize
     */
    public void setPopupSize(BSize v) {
        set(popupSize, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Property "popupTitle"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code popupTitle} property.
     * @see #getPopupTitle
     * @see #setPopupTitle
     */
    public static final Property popupTitle = newProperty(0, "Analog sensor", null);

    /**
     * Get the {@code popupTitle} property.
     * @see #popupTitle
     */
    public String getPopupTitle() {
        return getString(popupTitle);
    }

    /**
     * Set the {@code popupTitle} property.
     * @see #popupTitle
     */
    public void setPopupTitle(String v) {
        setString(popupTitle, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Property "popupModal"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code popupModal} property.
     * @see #getPopupModal
     * @see #setPopupModal
     */
    public static final Property popupModal = newProperty(0, false, null);

    /**
     * Get the {@code popupModal} property.
     * @see #popupModal
     */
    public boolean getPopupModal() {
        return getBoolean(popupModal);
    }

    /**
     * Set the {@code popupModal} property.
     * @see #popupModal
     */
    public void setPopupModal(boolean v) {
        setBoolean(popupModal, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BWbAnalogSensorView.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    /**
     * Loads the Px analog sensor view
     *
     * @param object      analog sensor
     * @param context     context
     * @throws Exception
     */
    @Override
    protected void doLoadValue(BObject object, Context context) throws Exception {

        if (object instanceof BAnalogSensor) {

            sensor = (BAnalogSensor) object;

            BPicture  image  = createImageWidget(context);
            BWidget   value  = createValueLabel(context);
            BEdgePane pane   = new BEdgePane();
            BPicture  spacer = new BPicture();

            spacer.setImage(BImage.make("module://envasDemo/VAADIN/images/SpacerAlphaM.png"));
            pane.setRight(value);
            pane.setLeft(image);
            pane.setCenter(spacer);
            setContent(pane);
        }
    }

    /**
     * Picture/Image as a visual representation of the component value.
     * {@link BValueBinding} animated by {@link BAnalogSensorToImage} converter
     * delivers the image. Another binding, {@link BPopupBinding} from
     * the <b>kitPx</b> module opens a popup window on a mouse click.
     * <br/>
     * Returned widget is of type {@link BComponentPicture}, which is a subtype
     * of {@link BPicture} with overridden method {@link BPicture#computePreferredSize()}
     *
     * @param ctx context
     * @return image widget as {@link BComponentPicture}
     */
    protected BPicture createImageWidget(Context ctx) {

        BComponentPicture    imageWidget    = new BComponentPicture();
        BAnalogSensorToImage imageConverter = new BAnalogSensorToImage(getImageSize());
        BValueBinding        imageBinding   = new BValueBinding();
        BPopupBinding        popupBinding   = new BPopupBinding();
        BOrd                 sensorOrd      = sensor.getNavOrd();
        BImage               img;

        try {
            img = (BImage) imageConverter.convert(sensor, null, ctx);
        } catch (Exception e) {

            NvLog.error("Cannot set image for the view " + e.getClass().getSimpleName());
            img = BImage.DEFAULT;
        }

        img.syncDimensions();
        popupBinding.setSize(getPopupSize());
        popupBinding.setTitle(getPopupTitle());
        popupBinding.setModal((getPopupModal()));
        popupBinding.setOrd(BOrd.make(sensorOrd.toString() + "|view:envasDemo:PopupWidget"));
        imageBinding.setOrd(sensorOrd);
        imageBinding.add("image", imageConverter);
        imageWidget.add("popup", popupBinding);
        imageWidget.add("i", imageBinding);
        imageWidget.setMouseCursor(MouseCursor.hand);

        return imageWidget;
    }

    /**
     * Create the value label including binding
     *
     * @return value text
     */
    protected BWidget createValueLabel(Context ctx) {

        BBoundLabel        valueLabel = new BBoundLabel();
        BBoundLabelBinding binding    = new BBoundLabelBinding();
        BObjectToString    converter  = new BObjectToString();

        converter.setFormat(BFormat.make("%out.value%"));
        binding.setOrd(sensor.getNavOrd());
        binding.setStatusEffect(BStatusEffect.none);
        binding.add("text", converter);
        valueLabel.add("v", binding);
        valueLabel.setText(converter.convert(sensor, null).toString(ctx));
        valueLabel.setHalign(BHalign.left);
        valueLabel.setFont(getValueFont());

        return valueLabel;
    }

    public BAnalogSensor getSensor() {
        return sensor;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Fields
    ///////////////////////////////////////////////////////////////////////////////////////////
    BAnalogSensor sensor = null;
}
