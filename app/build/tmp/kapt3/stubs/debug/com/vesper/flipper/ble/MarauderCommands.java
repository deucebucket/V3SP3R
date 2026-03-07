package com.vesper.flipper.ble;

import android.annotation.SuppressLint;
import android.bluetooth.*;
import android.content.Context;
import kotlinx.coroutines.flow.*;
import java.util.UUID;

/**
 * Marauder Command Reference
 *
 * Scanning:
 * - scanap: Scan for access points
 * - scansta: Scan for stations
 * - stopscan: Stop scanning
 *
 * Attacks:
 * - attack -t deauth: Deauthentication attack
 * - attack -t beacon: Beacon spam
 * - attack -t probe: Probe request flood
 * - attack -t rickroll: Rickroll beacon spam
 *
 * SSID Management:
 * - ssid -a -n "name": Add SSID
 * - ssid -r -i index: Remove SSID
 * - ssid -c: Clear SSIDs
 *
 * Evil Portal:
 * - evilportal -c start: Start portal
 * - evilportal -c stop: Stop portal
 * - evilportal -c setap -s "ssid": Set AP name
 *
 * Sniffing:
 * - sniff -c channel: Start sniffing
 * - sniff -s: Stop sniffing
 *
 * General:
 * - info: Device info
 * - help: Command help
 * - reboot: Reboot device
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/vesper/flipper/ble/MarauderCommands;", "", "()V", "BEACON_SPAM", "", "getBEACON_SPAM", "()Ljava/lang/String;", "DEAUTH", "getDEAUTH", "HELP", "getHELP", "INFO", "getINFO", "PROBE_FLOOD", "getPROBE_FLOOD", "REBOOT", "getREBOOT", "RICKROLL", "getRICKROLL", "SCAN_AP", "getSCAN_AP", "SCAN_STATIONS", "getSCAN_STATIONS", "STOP_SCAN", "getSTOP_SCAN", "app_debug"})
public final class MarauderCommands {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SCAN_AP = "scanap";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SCAN_STATIONS = "scansta";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String STOP_SCAN = "stopscan";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DEAUTH = "attack -t deauth";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BEACON_SPAM = "attack -t beacon";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PROBE_FLOOD = "attack -t probe";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String RICKROLL = "attack -t rickroll";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String INFO = "info";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String HELP = "help";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String REBOOT = "reboot";
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ble.MarauderCommands INSTANCE = null;
    
    private MarauderCommands() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSCAN_AP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSCAN_STATIONS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSTOP_SCAN() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDEAUTH() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBEACON_SPAM() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPROBE_FLOOD() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRICKROLL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getINFO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHELP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getREBOOT() {
        return null;
    }
}