/*
 * @(#)BEnvasTestPoint.java   30.09.2017
 *
 * Copyright (c) 2007 Neopsis GmbH
 *
 *
 */



package com.neopsis.envas.demo.component;

import com.neopsis.envas.amcharts.enums.BNvChartTypeEnum;
import com.neopsis.envas.amcharts.providers.history.BNvHistoryChartInfo;
import com.tridium.history.db.BLocalDbHistory;

import javax.baja.alarm.ext.BAlarmSourceExt;
import javax.baja.alarm.ext.BOffnormalAlgorithm;
import javax.baja.alarm.ext.offnormal.BOutOfRangeAlgorithm;
import javax.baja.control.BNumericWritable;
import javax.baja.history.BHistoryConfig;
import javax.baja.history.BHistoryId;
import javax.baja.history.BHistoryService;
import javax.baja.history.BNumericTrendRecord;
import javax.baja.history.db.HistoryDatabaseConnection;
import javax.baja.history.ext.BHistoryExt;
import javax.baja.history.ext.BNumericIntervalHistoryExt;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.BTypeSpec;
import java.util.ArrayList;

/**
 * This is the analog sensor component we are going to use in our
 * component example.
 */
@NiagaraType
@NiagaraProperty(
    name         = "serialNumber",
    type         = "String",
    defaultValue = ""
)
@NiagaraProperty(
    name         = "historyExt",
    type         = "BNumericIntervalHistoryExt",
    defaultValue = "new BNumericIntervalHistoryExt()",
    flags        = Flags.SUMMARY
)
@NiagaraProperty(
    name         = "alarmExt",
    type         = "BAlarmSourceExt",
    defaultValue = "new BAlarmSourceExt()",
    flags        = Flags.SUMMARY
)
public class BAnalogSensor extends BNumericWritable {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.neopsis.envas.demo.component.BAnalogSensor(789910366)1.0$ @*/
    /* Generated Sun May 02 22:06:38 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Property "serialNumber"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code serialNumber} property.
     * @see #getSerialNumber
     * @see #setSerialNumber
     */
    public static final Property serialNumber = newProperty(0, "", null);

    /**
     * Get the {@code serialNumber} property.
     * @see #serialNumber
     */
    public String getSerialNumber() {
        return getString(serialNumber);
    }

    /**
     * Set the {@code serialNumber} property.
     * @see #serialNumber
     */
    public void setSerialNumber(String v) {
        setString(serialNumber, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Property "historyExt"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code historyExt} property.
     * @see #getHistoryExt
     * @see #setHistoryExt
     */
    public static final Property historyExt = newProperty(Flags.SUMMARY, new BNumericIntervalHistoryExt(), null);

    /**
     * Get the {@code historyExt} property.
     * @see #historyExt
     */
    public BNumericIntervalHistoryExt getHistoryExt() {
        return (BNumericIntervalHistoryExt) get(historyExt);
    }

    /**
     * Set the {@code historyExt} property.
     * @see #historyExt
     */
    public void setHistoryExt(BNumericIntervalHistoryExt v) {
        set(historyExt, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Property "alarmExt"
    ////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code alarmExt} property.
     * @see #getAlarmExt
     * @see #setAlarmExt
     */
    public static final Property alarmExt = newProperty(Flags.SUMMARY, new BAlarmSourceExt(), null);

    /**
     * Get the {@code alarmExt} property.
     * @see #alarmExt
     */
    public BAlarmSourceExt getAlarmExt() {
        return (BAlarmSourceExt) get(alarmExt);
    }

    /**
     * Set the {@code alarmExt} property.
     * @see #alarmExt
     */
    public void setAlarmExt(BAlarmSourceExt v) {
        set(alarmExt, v, null);
    }

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BAnalogSensor.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    /**
     *  Parameterless constructor for reflection
     *
     */
    public BAnalogSensor() {

        super();

        BAlarmSourceExt     ext       = getAlarmExt();
        BOffnormalAlgorithm algorithm = ext.getOffnormalAlgorithm();

        if (!(algorithm instanceof BOutOfRangeAlgorithm)) {
            ext.setOffnormalAlgorithm(new BOutOfRangeAlgorithm());
        }
    }

    /**
     * Returns list of metadata about all component histories. There is one
     * frozen history, we can add another histories by hand.
     * <br/>
     * Metadata are saved in the structure {@link BNvHistoryChartInfo}. Each chart info
     * contains
     * <ul>
     *     <li>history ORD</li>
     *     <li>chart type (line or bar)</li>
     * </ul>
     *
     * @return list with metadata of all history extensions
     */
    public ArrayList<BNvHistoryChartInfo> getChartInfos() {

        ArrayList<BNvHistoryChartInfo> chartInfos = new ArrayList<>();
        BHistoryExt[]         extensions = getChildren(BHistoryExt.class);

        for (int j = 0; j < extensions.length; j++) {

            if (extensions[j].getEnabled()) {

                BHistoryService           service   = (BHistoryService) Sys.getService(BHistoryService.TYPE);
                HistoryDatabaseConnection conn      = service.getDatabase().getDbConnection(null);
                BHistoryId                historyId = extensions[j].getHistoryConfig().getId();
                BLocalDbHistory           hist      = (BLocalDbHistory) conn.getHistory(historyId);

                if (hist != null) {

                    if (hist != null) {

                        BHistoryConfig conf      = hist.getConfig();
                        BTypeSpec      typeSpec  = conf.getRecordType();
                        BNvHistoryChartInfo     chartInfo = new BNvHistoryChartInfo();

                        chartInfo.setOrd(hist.getOrdInSpace());

                        if (typeSpec.equals(BNumericTrendRecord.TYPE.getTypeSpec())) {
                            chartInfo.setChartType(BNvChartTypeEnum.line);
                        } else {
                            chartInfo.setChartType(BNvChartTypeEnum.bar);
                        }

                        chartInfos.add(chartInfo);
                    }
                }
            }
        }

        chartInfos.trimToSize();

        return chartInfos;
    }
}
