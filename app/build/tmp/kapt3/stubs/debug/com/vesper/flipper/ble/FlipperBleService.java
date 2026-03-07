package com.vesper.flipper.ble;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.*;
import android.bluetooth.le.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.hoho.android.usbserial.driver.CdcAcmSerialDriver;
import com.hoho.android.usbserial.driver.ProbeTable;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import com.vesper.flipper.MainActivity;
import com.vesper.flipper.R;
import com.vesper.flipper.VesperApplication;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.*;
import kotlinx.coroutines.flow.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;

/**
 * Foreground service managing BLE connection to Flipper Zero.
 * Handles scanning, connection, and GATT operations.
 */
@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00bc\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u008c\u00022\u00020\u0001:\u0004\u008c\u0002\u008d\u0002B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\u0019H\u0003J\u0018\u0010m\u001a\u00020\u00192\b\b\u0002\u0010n\u001a\u00020?H\u0086@\u00a2\u0006\u0002\u0010oJ\b\u0010p\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020i2\u0006\u0010s\u001a\u00020\u001dH\u0002J\u0017\u0010t\u001a\u0004\u0018\u00010.2\u0006\u0010u\u001a\u00020fH\u0002\u00a2\u0006\u0002\u0010vJ\u0010\u0010w\u001a\u00020i2\u0006\u0010x\u001a\u00020\u0005H\u0007J\u001a\u0010y\u001a\u0004\u0018\u00010\u00152\u0006\u0010x\u001a\u0002012\u0006\u0010z\u001a\u00020\u0019H\u0003J\u0006\u0010{\u001a\u00020iJ\u001a\u0010|\u001a\u00020\u00192\n\b\u0002\u0010}\u001a\u0004\u0018\u00010*H\u0082@\u00a2\u0006\u0002\u0010~J\b\u0010\u007f\u001a\u0004\u0018\u00010%J\n\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J\u0012\u0010\u0082\u0001\u001a\u00020%2\u0007\u0010\u0083\u0001\u001a\u00020.H\u0002J\u0018\u0010\u0084\u0001\u001a\u00020%2\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020*0\tH\u0002J\t\u0010\u0086\u0001\u001a\u00020iH\u0007J\t\u0010\u0087\u0001\u001a\u00020iH\u0003J\u001f\u0010\u0088\u0001\u001a\u00020i2\u0007\u0010\u0089\u0001\u001a\u00020\u00192\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010%H\u0002J\u001a\u0010\u008b\u0001\u001a\u00020i2\u0006\u0010u\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u00020?H\u0002J\t\u0010\u008d\u0001\u001a\u00020iH\u0003J!\u0010\u008e\u0001\u001a\u00020\u00192\u0007\u0010\u008f\u0001\u001a\u00020`2\u0006\u0010x\u001a\u00020*H\u0082@\u00a2\u0006\u0003\u0010\u0090\u0001J\u0012\u0010\u0091\u0001\u001a\u00020.2\u0007\u0010\u0092\u0001\u001a\u00020%H\u0002J\t\u0010\u0093\u0001\u001a\u00020iH\u0002J\u0011\u0010\u0094\u0001\u001a\u00020i2\u0006\u0010x\u001a\u00020\u0005H\u0002J\t\u0010\u0095\u0001\u001a\u00020%H\u0002J\u0013\u0010\u0096\u0001\u001a\u0004\u0018\u00010%2\u0006\u0010x\u001a\u000201H\u0002J\t\u0010\u0097\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010\u0098\u0001\u001a\u00020\u00192\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010%H\u0002J\u0011\u0010\u009a\u0001\u001a\u00020\u00192\u0006\u0010j\u001a\u00020kH\u0002J\u0011\u0010\u009b\u0001\u001a\u00020\u00192\u0006\u0010j\u001a\u00020kH\u0002J\t\u0010\u009c\u0001\u001a\u00020iH\u0002J\t\u0010\u009d\u0001\u001a\u00020iH\u0002J\t\u0010\u009e\u0001\u001a\u00020\u0019H\u0002J\u0007\u0010\u009f\u0001\u001a\u00020\u0019J\u0012\u0010\u00a0\u0001\u001a\u00020\u00192\u0007\u0010\u00a1\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010\u00a2\u0001\u001a\u00020\u00192\u0007\u0010\u00a3\u0001\u001a\u00020\u001cH\u0002J\u0014\u0010\u00a4\u0001\u001a\u00020\u00192\t\u0010\u00a5\u0001\u001a\u0004\u0018\u00010%H\u0002J\u0011\u0010\u00a6\u0001\u001a\u00020\u00192\u0006\u0010x\u001a\u00020*H\u0002J\u0012\u0010\u00a7\u0001\u001a\u00020\u00192\u0007\u0010\u00a5\u0001\u001a\u00020%H\u0002J\t\u0010\u00a8\u0001\u001a\u00020\u0019H\u0002J\t\u0010\u00a9\u0001\u001a\u00020iH\u0002J\t\u0010\u00aa\u0001\u001a\u00020iH\u0002J\u0016\u0010\u00ab\u0001\u001a\u0004\u0018\u00010%2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010%H\u0002J\u0016\u0010\u00ac\u0001\u001a\u00030\u00ad\u00012\n\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00af\u0001H\u0016J\t\u0010\u00b0\u0001\u001a\u00020iH\u0016J\t\u0010\u00b1\u0001\u001a\u00020iH\u0016J\'\u0010\u00b2\u0001\u001a\u00020.2\n\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00af\u00012\u0007\u0010\u00b3\u0001\u001a\u00020.2\u0007\u0010\u00b4\u0001\u001a\u00020.H\u0016J\u0012\u0010\u00b5\u0001\u001a\u00020i2\u0007\u0010\u0099\u0001\u001a\u00020%H\u0002J\u0018\u0010\u00b6\u0001\u001a\u00020i2\u0006\u0010u\u001a\u00020fH\u0082@\u00a2\u0006\u0003\u0010\u00b7\u0001J\u001b\u0010\u00b8\u0001\u001a\u00020 2\t\b\u0002\u0010\u00b9\u0001\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0003\u0010\u00ba\u0001J\u0012\u0010\u00bb\u0001\u001a\u00020i2\u0007\u0010\u00bc\u0001\u001a\u00020TH\u0003J\t\u0010\u00bd\u0001\u001a\u00020iH\u0002J\t\u0010\u00be\u0001\u001a\u00020iH\u0003J\u001b\u0010\u00bf\u0001\u001a\u00020?2\u0007\u0010\u00c0\u0001\u001a\u00020.2\u0007\u0010\u00c1\u0001\u001a\u00020\u0019H\u0002J\u001b\u0010\u00c2\u0001\u001a\u00020?2\u0007\u0010\u00c0\u0001\u001a\u00020.2\u0007\u0010\u00c1\u0001\u001a\u00020\u0019H\u0002J\u001b\u0010\u00c3\u0001\u001a\u00020.2\u0007\u0010\u00c0\u0001\u001a\u00020.2\u0007\u0010\u00c1\u0001\u001a\u00020\u0019H\u0002J\u001b\u0010\u00c4\u0001\u001a\u00020?2\u0007\u0010\u00c0\u0001\u001a\u00020.2\u0007\u0010\u00c1\u0001\u001a\u00020\u0019H\u0002J\u001d\u0010\u00c5\u0001\u001a\u00020%2\u0007\u0010\u0099\u0001\u001a\u00020%2\t\u0010\u00c6\u0001\u001a\u0004\u0018\u00010%H\u0002J \u0010\u00c7\u0001\u001a\u0004\u0018\u00010T2\b\u0010\u00c8\u0001\u001a\u00030\u00c9\u00012\t\u0010\u00ca\u0001\u001a\u0004\u0018\u00010TH\u0002J\u0011\u0010\u00cb\u0001\u001a\u00020%2\u0006\u0010j\u001a\u00020kH\u0002J\u0015\u0010\u00cc\u0001\u001a\u0005\u0018\u00010\u00c9\u00012\u0007\u0010\u00a1\u0001\u001a\u00020\u0015H\u0002J\u0011\u0010\u00cd\u0001\u001a\u00020%2\u0006\u0010x\u001a\u00020*H\u0002J \u0010\u00ce\u0001\u001a\u0004\u0018\u00010d2\u0007\u0010\u008f\u0001\u001a\u00020`2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010*H\u0002J\u0015\u0010\u00cf\u0001\u001a\u0004\u0018\u00010T2\b\u0010\u00c8\u0001\u001a\u00030\u00c9\u0001H\u0002J\u001b\u0010\u00d0\u0001\u001a\u00020?2\u0007\u0010\u00c0\u0001\u001a\u00020.2\u0007\u0010\u00c1\u0001\u001a\u00020\u0019H\u0002J#\u0010\u00d1\u0001\u001a\b\u0012\u0004\u0012\u00020.0\t2\u0007\u0010\u00d2\u0001\u001a\u00020T2\t\b\u0002\u0010\u00c1\u0001\u001a\u00020\u0019H\u0002J\u0010\u0010\u00d3\u0001\u001a\u00020\u0019H\u0087@\u00a2\u0006\u0003\u0010\u00d4\u0001J\u0011\u0010\u00d5\u0001\u001a\u00030\u00d6\u0001H\u0086@\u00a2\u0006\u0003\u0010\u00d4\u0001J\u0012\u0010\u00d7\u0001\u001a\u00020\u00192\u0007\u0010\u0083\u0001\u001a\u00020.H\u0003J\t\u0010\u00d8\u0001\u001a\u00020iH\u0003J\t\u0010\u00d9\u0001\u001a\u00020iH\u0003J\u0019\u0010\u00da\u0001\u001a\u00020\u00192\u0007\u0010\u00db\u0001\u001a\u00020%H\u0086@\u00a2\u0006\u0003\u0010\u00dc\u0001J)\u0010\u00dd\u0001\u001a\t\u0012\u0004\u0012\u00020%0\u00de\u00012\u0007\u0010\u00db\u0001\u001a\u00020%H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\b\u00df\u0001\u0010\u00dc\u0001J.\u0010\u00e0\u0001\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u001d2\t\b\u0002\u0010\u00c1\u0001\u001a\u00020\u00192\t\b\u0002\u0010\u00e1\u0001\u001a\u00020\u0019H\u0087@\u00a2\u0006\u0003\u0010\u00e2\u0001J*\u0010\u00e3\u0001\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u001d2\u0007\u0010\u00c1\u0001\u001a\u00020\u00192\u0007\u0010\u00e1\u0001\u001a\u00020\u0019H\u0083@\u00a2\u0006\u0003\u0010\u00e2\u0001J!\u0010\u00e4\u0001\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u001d2\u0007\u0010\u00c1\u0001\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0003\u0010\u00e5\u0001J\u0019\u0010\u00e6\u0001\u001a\u00020\u00192\u0007\u0010\u00db\u0001\u001a\u00020%H\u0086@\u00a2\u0006\u0003\u0010\u00dc\u0001J(\u0010\u00e7\u0001\u001a\t\u0012\u0004\u0012\u00020\u001d0\u00de\u00012\u0006\u0010s\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\b\u00e8\u0001\u0010\u00e9\u0001J\u0012\u0010\u00ea\u0001\u001a\u00020\u00192\u0007\u0010\u00d2\u0001\u001a\u00020TH\u0002J\u0012\u0010\u00eb\u0001\u001a\u00020\u00192\u0007\u0010\u00ec\u0001\u001a\u00020%H\u0002J\t\u0010\u00ed\u0001\u001a\u00020iH\u0002J\t\u0010\u00ee\u0001\u001a\u00020iH\u0003J\t\u0010\u00ef\u0001\u001a\u00020iH\u0002J\t\u0010\u00f0\u0001\u001a\u00020iH\u0007J\t\u0010\u00f1\u0001\u001a\u00020iH\u0002J\t\u0010\u00f2\u0001\u001a\u00020iH\u0002J\t\u0010\u00f3\u0001\u001a\u00020iH\u0007J\u0014\u0010\u00f4\u0001\u001a\u00020%2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010\u00f5\u0001\u001a\u00020\u00192\u0007\u0010\u00d2\u0001\u001a\u00020TH\u0002J\u0012\u0010\u00f6\u0001\u001a\u00020\u00192\u0007\u0010\u00d2\u0001\u001a\u00020TH\u0002J\u0012\u0010\u00f7\u0001\u001a\u00020\u00192\u0007\u0010\u00d2\u0001\u001a\u00020TH\u0002J\u0012\u0010\u00f8\u0001\u001a\u00020\u00192\u0007\u0010\u00d2\u0001\u001a\u00020TH\u0002J\t\u0010\u00f9\u0001\u001a\u00020iH\u0002J\t\u0010\u00fa\u0001\u001a\u00020iH\u0002J\u0012\u0010\u00fb\u0001\u001a\u00020i2\u0007\u0010\u00fc\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u00fd\u0001\u001a\u00020.H\u0002J\u0018\u0010\u00fe\u0001\u001a\u00020i2\u0006\u0010u\u001a\u00020fH\u0082@\u00a2\u0006\u0003\u0010\u00b7\u0001J\u0019\u0010\u00ff\u0001\u001a\u00020\u00192\u0007\u0010\u0080\u0002\u001a\u00020.H\u0082@\u00a2\u0006\u0003\u0010\u0081\u0002JO\u0010\u0082\u0002\u001a\u0005\u0018\u0001H\u0083\u0002\"\u0005\b\u0000\u0010\u0083\u00022\u0007\u0010\u0084\u0002\u001a\u00020?2\u0007\u0010\u0085\u0002\u001a\u00020%2!\u0010\u0086\u0002\u001a\u001c\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u0083\u00020\u0088\u0002\u0012\u0007\u0012\u0005\u0018\u00010\u0089\u00020\u0087\u0002H\u0082@\u00a2\u0006\u0003\u0010\u008a\u0002J\u0010\u0010\u008b\u0002\u001a\u0004\u0018\u00010**\u00030\u00af\u0001H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"RN\u0010#\u001aB\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0012\f\u0012\n &*\u0004\u0018\u00010\u00190\u0019 &* \u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0012\f\u0012\n &*\u0004\u0018\u00010\u00190\u0019\u0018\u00010$0$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0012\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010/R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002010\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020?X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010J\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0K0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010KX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010KX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010Q\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010/R\u000e\u0010R\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010TX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010TX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010TX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020ZX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020OX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u008e\u0002"}, d2 = {"Lcom/vesper/flipper/ble/FlipperBleService;", "Landroid/app/Service;", "()V", "_connectedDevice", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/ble/FlipperDevice;", "_connectionState", "Lcom/vesper/flipper/ble/ConnectionState;", "_discoveredDevices", "", "activeTransport", "Lcom/vesper/flipper/ble/CommandTransport;", "binder", "Lcom/vesper/flipper/ble/FlipperBleService$LocalBinder;", "bleKeepaliveJob", "Lkotlinx/coroutines/Job;", "bleScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "broadScanCallback", "Landroid/bluetooth/le/ScanCallback;", "broadScanStarted", "", "characteristicBuffer", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/UUID;", "", "cliCapabilityStatus", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/vesper/flipper/ble/CliCapabilityStatus;", "getCliCapabilityStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "confirmedFlipperAddresses", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "kotlin.jvm.PlatformType", "connectedDevice", "getConnectedDevice", "connectedUsbDevice", "Landroid/hardware/usb/UsbDevice;", "connectionState", "getConnectionState", "currentUsbBaudRate", "", "Ljava/lang/Integer;", "discoveredBluetoothDevices", "Landroid/bluetooth/BluetoothDevice;", "discoveredDeviceNames", "discoveredDevices", "getDiscoveredDevices", "flipperProtocol", "Lcom/vesper/flipper/ble/FlipperProtocol;", "getFlipperProtocol", "()Lcom/vesper/flipper/ble/FlipperProtocol;", "setFlipperProtocol", "(Lcom/vesper/flipper/ble/FlipperProtocol;)V", "gattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "gattLinkConnected", "lastBleActivityAtMs", "", "lastBlePriorityRequestAtMs", "lastRequestedBluetoothDevice", "lastRequestedDeviceAddress", "lastRequestedDeviceName", "lastWriteFailureReason", "negotiatedMtu", "notificationsReady", "pendingConnectedDevice", "pendingConnectionName", "pendingOperationId", "pendingOperations", "Lkotlinx/coroutines/CompletableDeferred;", "pendingUsbPermissionRequest", "pendingWriteAck", "rawOperationMutex", "Lkotlinx/coroutines/sync/Mutex;", "reconnectAttemptCount", "remainingSerialBufferBytes", "scanCallback", "serialCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "serialOverflowCharacteristic", "serialResetCharacteristic", "serialRxCharacteristic", "serialServiceUuid", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "usbBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "usbDeviceConnection", "Landroid/hardware/usb/UsbDeviceConnection;", "usbManager", "Landroid/hardware/usb/UsbManager;", "usbReadJob", "usbReceiverRegistered", "usbSerialDriver", "Lcom/hoho/android/usbserial/driver/UsbSerialDriver;", "usbSerialPort", "Lcom/hoho/android/usbserial/driver/UsbSerialPort;", "writeMutex", "addDiscoveredDevice", "", "result", "Landroid/bluetooth/le/ScanResult;", "isConfirmedFlipper", "awaitCommandTransportReady", "timeoutMs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildCustomUsbProber", "Lcom/hoho/android/usbserial/driver/UsbSerialProber;", "completePendingOperation", "data", "configureUsbPort", "port", "(Lcom/hoho/android/usbserial/driver/UsbSerialPort;)Ljava/lang/Integer;", "connect", "device", "connectGattCompat", "autoConnect", "connectUsbIfAvailable", "connectUsbInternal", "preferredDevice", "(Landroid/hardware/usb/UsbDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeLastWriteFailureReason", "createNotification", "Landroid/app/Notification;", "describeGattStatus", "status", "describeUsbDeviceList", "devices", "disconnect", "disconnectBleTransport", "disconnectUsbTransport", "setState", "errorMessage", "drainUsbInput", "durationMs", "enableOverflowControl", "ensureUsbPermission", "manager", "(Landroid/hardware/usb/UsbManager;Landroid/hardware/usb/UsbDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "estimateCliListingEntries", "rawOutput", "failPendingWriteAck", "finalizeConnectedState", "getConnectionText", "getDeviceNameSafely", "hasBluetoothPermissions", "hasKnownFlipperAddressPrefix", "address", "hasKnownFlipperService", "hasLikelyFlipperManufacturerData", "initializeBluetooth", "initializeUsb", "isBleCommandTransportConnected", "isCommandTransportConnected", "isCurrentGatt", "gatt", "isFlipperFamilyService", "uuid", "isLikelyFlipperName", "name", "isLikelyFlipperUsbDevice", "isPlaceholderName", "isUsbCommandTransportConnected", "loadPersistedConfirmedFlippers", "markBleActivity", "normalizeBleAddress", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "persistConfirmedFlipperAddress", "primeUsbRpcSession", "(Lcom/hoho/android/usbserial/driver/UsbSerialPort;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "probeCliCapability", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshOverflowCapacity", "overflowCharacteristic", "registerUsbReceivers", "requestHighPriorityConnectionIfNeeded", "resolveBleAckTimeoutMs", "payloadSize", "preferNoResponse", "resolveBleNoResponseDelayMs", "resolveBleWriteAttempts", "resolveBleWriteRetryDelayMs", "resolveConnectedDeviceName", "deviceName", "resolveNotifyCharacteristic", "service", "Landroid/bluetooth/BluetoothGattService;", "writeCharacteristic", "resolveScanDeviceName", "resolveSerialService", "resolveUsbDeviceName", "resolveUsbSerialDriver", "resolveWriteCharacteristic", "resolveWriteLockTimeoutMs", "resolveWriteTypeCandidates", "characteristic", "restartSerialRpc", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runConnectionDiagnostics", "Lcom/vesper/flipper/ble/ConnectionDiagnosticsReport;", "scheduleAutoReconnectIfEligible", "seedBondedFlippersIntoDiscoveredList", "sendBleKeepaliveProbe", "sendCommand", "command", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCommandWithOutput", "Lkotlin/Result;", "sendCommandWithOutput-gIAlu-s", "sendData", "ignoreOverflowBudget", "([BZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendDataOverBle", "sendDataOverUsb", "([BZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRawCliCommand", "sendRawData", "sendRawData-gIAlu-s", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldHandleIncomingCharacteristic", "shouldUseCliDiagnosticFallback", "message", "startBleKeepalive", "startBroadScan", "startForegroundService", "startScan", "startUsbReadLoop", "stopBleKeepalive", "stopScan", "summarizeCliLine", "supportsIndication", "supportsNotification", "supportsNotifyOrIndicate", "supportsWrite", "unregisterUsbReceivers", "updateNotification", "updateOverflowCapacityFromBytes", "bytes", "usbPermissionPendingIntentFlags", "validateUsbBaudWithRpcProbe", "waitForOverflowBudget", "requiredBytes", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withWriteMutexOrFail", "T", "lockTimeoutMs", "timeoutReason", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(JLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractUsbDeviceExtra", "Companion", "LocalBinder", "app_debug"})
public final class FlipperBleService extends android.app.Service {
    @org.jetbrains.annotations.NotNull
    private final com.vesper.flipper.ble.FlipperBleService.LocalBinder binder = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothAdapter bluetoothAdapter;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothGatt bluetoothGatt;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.le.BluetoothLeScanner bleScanner;
    @org.jetbrains.annotations.Nullable
    private android.hardware.usb.UsbManager usbManager;
    @org.jetbrains.annotations.Nullable
    private com.hoho.android.usbserial.driver.UsbSerialDriver usbSerialDriver;
    @org.jetbrains.annotations.Nullable
    private com.hoho.android.usbserial.driver.UsbSerialPort usbSerialPort;
    @org.jetbrains.annotations.Nullable
    private android.hardware.usb.UsbDeviceConnection usbDeviceConnection;
    @org.jetbrains.annotations.Nullable
    private android.hardware.usb.UsbDevice connectedUsbDevice;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job usbReadJob;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job bleKeepaliveJob;
    private boolean usbReceiverRegistered = false;
    private boolean broadScanStarted = false;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.ConnectionState> _connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.ConnectionState> connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.vesper.flipper.ble.FlipperDevice>> _discoveredDevices = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ble.FlipperDevice>> discoveredDevices = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.FlipperDevice> _connectedDevice = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FlipperDevice> connectedDevice = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, kotlinx.coroutines.CompletableDeferred<byte[]>> pendingOperations = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.sync.Mutex rawOperationMutex = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile java.lang.String pendingOperationId;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.ConcurrentHashMap<java.util.UUID, byte[]> characteristicBuffer = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> discoveredDeviceNames = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, android.bluetooth.BluetoothDevice> discoveredBluetoothDevices = null;
    private final java.util.concurrent.ConcurrentHashMap.KeySetView<java.lang.String, java.lang.Boolean> confirmedFlipperAddresses = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.sync.Mutex writeMutex = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile kotlinx.coroutines.CompletableDeferred<java.lang.Boolean> pendingWriteAck;
    @kotlin.jvm.Volatile
    private volatile boolean notificationsReady = false;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile com.vesper.flipper.ble.FlipperDevice pendingConnectedDevice;
    @kotlin.jvm.Volatile
    private volatile int negotiatedMtu = 23;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile java.lang.Integer currentUsbBaudRate;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile java.lang.String lastWriteFailureReason;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothGattCharacteristic serialCharacteristic;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothGattCharacteristic serialRxCharacteristic;
    @org.jetbrains.annotations.Nullable
    private java.util.UUID serialServiceUuid;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothGattCharacteristic serialOverflowCharacteristic;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothGattCharacteristic serialResetCharacteristic;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile java.lang.Integer remainingSerialBufferBytes;
    @org.jetbrains.annotations.Nullable
    private java.lang.String pendingConnectionName;
    @org.jetbrains.annotations.Nullable
    private java.lang.String lastRequestedDeviceAddress;
    @org.jetbrains.annotations.Nullable
    private java.lang.String lastRequestedDeviceName;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothDevice lastRequestedBluetoothDevice;
    @kotlin.jvm.Volatile
    private volatile int reconnectAttemptCount = 0;
    @kotlin.jvm.Volatile
    private volatile boolean gattLinkConnected = false;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.NotNull
    private volatile com.vesper.flipper.ble.CommandTransport activeTransport = com.vesper.flipper.ble.CommandTransport.NONE;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile kotlinx.coroutines.CompletableDeferred<java.lang.Boolean> pendingUsbPermissionRequest;
    @kotlin.jvm.Volatile
    private volatile long lastBleActivityAtMs = 0L;
    @kotlin.jvm.Volatile
    private volatile long lastBlePriorityRequestAtMs = 0L;
    @org.jetbrains.annotations.NotNull
    private final android.content.BroadcastReceiver usbBroadcastReceiver = null;
    @javax.inject.Inject
    public com.vesper.flipper.ble.FlipperProtocol flipperProtocol;
    @org.jetbrains.annotations.NotNull
    private final android.bluetooth.le.ScanCallback scanCallback = null;
    @org.jetbrains.annotations.NotNull
    private final android.bluetooth.le.ScanCallback broadScanCallback = null;
    @org.jetbrains.annotations.NotNull
    private final android.bluetooth.BluetoothGattCallback gattCallback = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "FlipperBleService";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_START_FOREGROUND = "com.vesper.flipper.START_FOREGROUND";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_STOP = "com.vesper.flipper.STOP";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_USB_PERMISSION = "com.vesper.flipper.USB_PERMISSION";
    public static final int NOTIFICATION_ID = 1;
    public static final long SCAN_TIMEOUT_MS = 30000L;
    private static final long BROAD_SCAN_FALLBACK_DELAY_MS = 4000L;
    private static final int MAX_DISCOVERED_DEVICES = 60;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID FLIPPER_SERVICE_UUID = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID FLIPPER_SERVICE_UUID_BLACK = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID FLIPPER_SERVICE_UUID_TRANSPARENT = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID FLIPPER_SERIAL_SERVICE_UUID = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID FLIPPER_SERIAL_TX_UUID = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID FLIPPER_SERIAL_RX_UUID = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID FLIPPER_SERIAL_OVERFLOW_UUID = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID FLIPPER_SERIAL_RESET_UUID = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.util.UUID> FLIPPER_SCAN_SERVICE_UUIDS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.UUID CLIENT_CHARACTERISTIC_CONFIG = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String UNKNOWN_DEVICE_NAME = "Unknown Device";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BLE_DEVICE_PREFIX = "BLE Device";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String DEFAULT_FLIPPER_NAME = "Flipper";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FLIPPER_NAME_PREFIX = "Flipper";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FLIPPER_MAC_PREFIX = "80:E1:26:";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FLIPPER_SERVICE_PREFIX = "0000308";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BLUETOOTH_BASE_UUID_SUFFIX = "-0000-1000-8000-00805f9b34fb";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREFS_BLE = "flipper_ble_prefs";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CONFIRMED_FLIPPER_ADDRESSES = "confirmed_flipper_addresses";
    private static final int CONTROL_PACKET_MAX_BYTES = 96;
    private static final long WRITE_ACK_TIMEOUT_MS = 1500L;
    private static final long WRITE_ACK_TIMEOUT_CONTROL_MS = 450L;
    private static final long WRITE_NO_RESPONSE_CHUNK_DELAY_MS = 8L;
    private static final long WRITE_NO_RESPONSE_CHUNK_DELAY_CONTROL_MS = 3L;
    private static final int MAX_WRITE_START_ATTEMPTS = 3;
    private static final int MAX_WRITE_START_ATTEMPTS_CONTROL = 2;
    private static final long WRITE_START_RETRY_DELAY_MS = 40L;
    private static final long WRITE_START_RETRY_DELAY_CONTROL_MS = 18L;
    private static final long WRITE_MUTEX_STANDARD_WAIT_TIMEOUT_MS = 6000L;
    private static final long WRITE_MUTEX_CONTROL_WAIT_TIMEOUT_MS = 350L;
    private static final int NOTIFICATION_READY_WAIT_ATTEMPTS = 6;
    private static final long NOTIFICATION_READY_POLL_MS = 50L;
    private static final long COMMAND_TRANSPORT_READY_TIMEOUT_MS = 2500L;
    private static final long COMMAND_TRANSPORT_READY_POLL_MS = 50L;
    private static final long BLE_KEEPALIVE_INTERVAL_MS = 3000L;
    private static final long BLE_KEEPALIVE_IDLE_THRESHOLD_MS = 3500L;
    private static final long BLE_PRIORITY_REFRESH_INTERVAL_MS = 45000L;
    private static final long OVERFLOW_WAIT_TIMEOUT_MS = 1200L;
    private static final long OVERFLOW_WAIT_POLL_MS = 15L;
    private static final int OVERFLOW_VALUE_SIZE_BYTES = 4;
    private static final int DEFAULT_ATT_MTU = 23;
    private static final int REQUESTED_ATT_MTU = 517;
    private static final int ATT_WRITE_OVERHEAD_BYTES = 3;
    private static final int MIN_BLE_CHUNK_BYTES = 20;
    private static final int MAX_SERIAL_CHAR_VALUE_BYTES = 243;
    private static final long TIMEOUT_RECONNECT_DELAY_MS = 1000L;
    private static final long TIMEOUT_RECONNECT_BACKOFF_STEP_MS = 500L;
    private static final int MAX_TIMEOUT_RECONNECT_ATTEMPTS = 3;
    private static final int GATT_STATUS_CONN_TIMEOUT = 8;
    private static final int GATT_STATUS_CONN_TERMINATE_PEER_USER = 19;
    private static final int GATT_STATUS_CONN_TERMINATE_LOCAL_HOST = 22;
    private static final int GATT_STATUS_GENERIC_ERROR = 133;
    private static final int GATT_STATUS_FAILURE = 257;
    private static final long USB_PERMISSION_TIMEOUT_MS = 4000L;
    private static final long USB_READ_TIMEOUT_MS = 120L;
    private static final long USB_WRITE_TIMEOUT_MS = 1500L;
    private static final int USB_READ_BUFFER_SIZE_BYTES = 4096;
    private static final int USB_WRITE_CHUNK_SIZE_BYTES = 256;
    private static final long USB_WRITE_INTER_CHUNK_DELAY_MS = 2L;
    private static final int USB_DATA_BITS = 8;
    private static final long USB_RPC_PRIME_DRAIN_WINDOW_MS = 220L;
    private static final long USB_RPC_BAUD_RETRY_DRAIN_WINDOW_MS = 160L;
    private static final long USB_RPC_PRIME_COMMAND_DELAY_MS = 80L;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> USB_RPC_PRIME_COMMANDS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.Integer> USB_BAUD_RATE_CANDIDATES = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.Set<java.lang.Integer> KNOWN_FLIPPER_BLE_MANUFACTURER_IDS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.Set<java.lang.Integer> KNOWN_FLIPPER_USB_VENDOR_IDS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.Set<java.lang.Integer> KNOWN_FLIPPER_USB_PRODUCT_IDS = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ble.FlipperBleService.Companion Companion = null;
    
    public FlipperBleService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.ConnectionState> getConnectionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.vesper.flipper.ble.FlipperDevice>> getDiscoveredDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FlipperDevice> getConnectedDevice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CliCapabilityStatus> getCliCapabilityStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ble.FlipperProtocol getFlipperProtocol() {
        return null;
    }
    
    public final void setFlipperProtocol(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperProtocol p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final void initializeBluetooth() {
    }
    
    private final void initializeUsb() {
    }
    
    private final void registerUsbReceivers() {
    }
    
    private final void unregisterUsbReceivers() {
    }
    
    private final void startForegroundService() {
    }
    
    private final android.app.Notification createNotification() {
        return null;
    }
    
    private final java.lang.String getConnectionText() {
        return null;
    }
    
    private final void updateNotification() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void startScan() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void startBroadScan() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void stopScan() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void addDiscoveredDevice(android.bluetooth.le.ScanResult result, boolean isConfirmedFlipper) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void connect(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperDevice device) {
    }
    
    public final void connectUsbIfAvailable() {
    }
    
    private final java.lang.Object connectUsbInternal(android.hardware.usb.UsbDevice preferredDevice, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object primeUsbRpcSession(com.hoho.android.usbserial.driver.UsbSerialPort port, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object validateUsbBaudWithRpcProbe(com.hoho.android.usbserial.driver.UsbSerialPort port, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void drainUsbInput(com.hoho.android.usbserial.driver.UsbSerialPort port, long durationMs) {
    }
    
    private final com.hoho.android.usbserial.driver.UsbSerialDriver resolveUsbSerialDriver(android.hardware.usb.UsbManager manager, android.hardware.usb.UsbDevice preferredDevice) {
        return null;
    }
    
    private final java.lang.Object ensureUsbPermission(android.hardware.usb.UsbManager manager, android.hardware.usb.UsbDevice device, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final int usbPermissionPendingIntentFlags() {
        return 0;
    }
    
    private final com.hoho.android.usbserial.driver.UsbSerialProber buildCustomUsbProber() {
        return null;
    }
    
    private final java.lang.Integer configureUsbPort(com.hoho.android.usbserial.driver.UsbSerialPort port) {
        return null;
    }
    
    private final long resolveWriteLockTimeoutMs(int payloadSize, boolean preferNoResponse) {
        return 0L;
    }
    
    private final long resolveBleAckTimeoutMs(int payloadSize, boolean preferNoResponse) {
        return 0L;
    }
    
    private final int resolveBleWriteAttempts(int payloadSize, boolean preferNoResponse) {
        return 0;
    }
    
    private final long resolveBleWriteRetryDelayMs(int payloadSize, boolean preferNoResponse) {
        return 0L;
    }
    
    private final long resolveBleNoResponseDelayMs(int payloadSize, boolean preferNoResponse) {
        return 0L;
    }
    
    private final void startUsbReadLoop() {
    }
    
    private final void markBleActivity() {
    }
    
    private final void startBleKeepalive() {
    }
    
    private final void stopBleKeepalive() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void sendBleKeepaliveProbe() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void requestHighPriorityConnectionIfNeeded() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void disconnect() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void disconnectBleTransport() {
    }
    
    private final void disconnectUsbTransport(boolean setState, java.lang.String errorMessage) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendData(@org.jetbrains.annotations.NotNull
    byte[] data, boolean preferNoResponse, boolean ignoreOverflowBudget, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object sendDataOverUsb(byte[] data, boolean preferNoResponse, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final java.lang.Object sendDataOverBle(byte[] data, boolean preferNoResponse, boolean ignoreOverflowBudget, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final <T extends java.lang.Object>java.lang.Object withWriteMutexOrFail(long lockTimeoutMs, java.lang.String timeoutReason, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> block, kotlin.coroutines.Continuation<? super T> $completion) {
        return null;
    }
    
    private final void failPendingWriteAck() {
    }
    
    private final void updateOverflowCapacityFromBytes(byte[] bytes) {
    }
    
    private final java.lang.Object waitForOverflowBudget(int requiredBytes, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final void completePendingOperation(byte[] data) {
    }
    
    private final boolean isCurrentGatt(android.bluetooth.BluetoothGatt gatt) {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final boolean scheduleAutoReconnectIfEligible(int status) {
        return false;
    }
    
    private final java.lang.String describeGattStatus(int status) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final android.bluetooth.BluetoothGatt connectGattCompat(android.bluetooth.BluetoothDevice device, boolean autoConnect) {
        return null;
    }
    
    private final android.bluetooth.BluetoothGattService resolveSerialService(android.bluetooth.BluetoothGatt gatt) {
        return null;
    }
    
    private final android.bluetooth.BluetoothGattCharacteristic resolveWriteCharacteristic(android.bluetooth.BluetoothGattService service) {
        return null;
    }
    
    private final android.bluetooth.BluetoothGattCharacteristic resolveNotifyCharacteristic(android.bluetooth.BluetoothGattService service, android.bluetooth.BluetoothGattCharacteristic writeCharacteristic) {
        return null;
    }
    
    private final boolean supportsWrite(android.bluetooth.BluetoothGattCharacteristic characteristic) {
        return false;
    }
    
    private final java.util.List<java.lang.Integer> resolveWriteTypeCandidates(android.bluetooth.BluetoothGattCharacteristic characteristic, boolean preferNoResponse) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String consumeLastWriteFailureReason() {
        return null;
    }
    
    private final boolean supportsNotifyOrIndicate(android.bluetooth.BluetoothGattCharacteristic characteristic) {
        return false;
    }
    
    private final boolean supportsNotification(android.bluetooth.BluetoothGattCharacteristic characteristic) {
        return false;
    }
    
    private final boolean supportsIndication(android.bluetooth.BluetoothGattCharacteristic characteristic) {
        return false;
    }
    
    private final boolean shouldHandleIncomingCharacteristic(android.bluetooth.BluetoothGattCharacteristic characteristic) {
        return false;
    }
    
    private final void finalizeConnectedState(com.vesper.flipper.ble.FlipperDevice device) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void enableOverflowControl() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void refreshOverflowCapacity(android.bluetooth.BluetoothGattCharacteristic overflowCharacteristic) {
    }
    
    /**
     * Send a CLI command string to the Flipper.
     * Uses the protocol layer for CLI transport and compatibility mapping.
     * Supports Flipper CLI commands like: subghz, ir, nfc, ble_spam, etc.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendCommand(@org.jetbrains.annotations.NotNull
    java.lang.String command, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Send a raw CLI command without protocol framing.
     * Use this for direct serial console interaction.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendRawCliCommand(@org.jetbrains.annotations.NotNull
    java.lang.String command, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object probeCliCapability(boolean force, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.CliCapabilityStatus> $completion) {
        return null;
    }
    
    public final boolean isCommandTransportConnected() {
        return false;
    }
    
    private final boolean isBleCommandTransportConnected() {
        return false;
    }
    
    private final boolean isUsbCommandTransportConnected() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object awaitCommandTransportReady(long timeoutMs, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object runConnectionDiagnostics(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ConnectionDiagnosticsReport> $completion) {
        return null;
    }
    
    private final boolean shouldUseCliDiagnosticFallback(java.lang.String message) {
        return false;
    }
    
    private final java.lang.String summarizeCliLine(java.lang.String rawOutput) {
        return null;
    }
    
    private final int estimateCliListingEntries(java.lang.String rawOutput) {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object restartSerialRpc(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final boolean hasBluetoothPermissions() {
        return false;
    }
    
    private final java.lang.String resolveScanDeviceName(android.bluetooth.le.ScanResult result) {
        return null;
    }
    
    private final java.lang.String getDeviceNameSafely(android.bluetooth.BluetoothDevice device) {
        return null;
    }
    
    private final java.lang.String resolveConnectedDeviceName(java.lang.String address, java.lang.String deviceName) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void seedBondedFlippersIntoDiscoveredList() {
    }
    
    private final boolean hasKnownFlipperService(android.bluetooth.le.ScanResult result) {
        return false;
    }
    
    private final boolean hasLikelyFlipperManufacturerData(android.bluetooth.le.ScanResult result) {
        return false;
    }
    
    private final boolean isFlipperFamilyService(java.util.UUID uuid) {
        return false;
    }
    
    private final boolean hasKnownFlipperAddressPrefix(java.lang.String address) {
        return false;
    }
    
    private final boolean isLikelyFlipperName(java.lang.String name) {
        return false;
    }
    
    private final boolean isPlaceholderName(java.lang.String name) {
        return false;
    }
    
    private final boolean isLikelyFlipperUsbDevice(android.hardware.usb.UsbDevice device) {
        return false;
    }
    
    private final java.lang.String resolveUsbDeviceName(android.hardware.usb.UsbDevice device) {
        return null;
    }
    
    private final java.lang.String describeUsbDeviceList(java.util.List<? extends android.hardware.usb.UsbDevice> devices) {
        return null;
    }
    
    private final java.lang.String normalizeBleAddress(java.lang.String address) {
        return null;
    }
    
    private final void loadPersistedConfirmedFlippers() {
    }
    
    private final void persistConfirmedFlipperAddress(java.lang.String address) {
    }
    
    private final android.hardware.usb.UsbDevice extractUsbDeviceExtra(android.content.Intent $this$extractUsbDeviceExtra) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\"\n\u0002\b*\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bJ\u000e\u0010c\u001a\u00020`2\u0006\u0010a\u001a\u00020bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u001f\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010!\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013R\u0011\u0010#\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u0011\u0010%\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013R\u000e\u0010\'\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0013R\u0011\u0010*\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0013R\u0011\u0010,\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0013R\u000e\u0010.\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\b05X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\b05X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\b05X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006d"}, d2 = {"Lcom/vesper/flipper/ble/FlipperBleService$Companion;", "", "()V", "ACTION_START_FOREGROUND", "", "ACTION_STOP", "ACTION_USB_PERMISSION", "ATT_WRITE_OVERHEAD_BYTES", "", "BLE_DEVICE_PREFIX", "BLE_KEEPALIVE_IDLE_THRESHOLD_MS", "", "BLE_KEEPALIVE_INTERVAL_MS", "BLE_PRIORITY_REFRESH_INTERVAL_MS", "BLUETOOTH_BASE_UUID_SUFFIX", "BROAD_SCAN_FALLBACK_DELAY_MS", "CLIENT_CHARACTERISTIC_CONFIG", "Ljava/util/UUID;", "getCLIENT_CHARACTERISTIC_CONFIG", "()Ljava/util/UUID;", "COMMAND_TRANSPORT_READY_POLL_MS", "COMMAND_TRANSPORT_READY_TIMEOUT_MS", "CONTROL_PACKET_MAX_BYTES", "DEFAULT_ATT_MTU", "DEFAULT_FLIPPER_NAME", "FLIPPER_MAC_PREFIX", "FLIPPER_NAME_PREFIX", "FLIPPER_SCAN_SERVICE_UUIDS", "", "FLIPPER_SERIAL_OVERFLOW_UUID", "getFLIPPER_SERIAL_OVERFLOW_UUID", "FLIPPER_SERIAL_RESET_UUID", "getFLIPPER_SERIAL_RESET_UUID", "FLIPPER_SERIAL_RX_UUID", "getFLIPPER_SERIAL_RX_UUID", "FLIPPER_SERIAL_SERVICE_UUID", "getFLIPPER_SERIAL_SERVICE_UUID", "FLIPPER_SERIAL_TX_UUID", "getFLIPPER_SERIAL_TX_UUID", "FLIPPER_SERVICE_PREFIX", "FLIPPER_SERVICE_UUID", "getFLIPPER_SERVICE_UUID", "FLIPPER_SERVICE_UUID_BLACK", "getFLIPPER_SERVICE_UUID_BLACK", "FLIPPER_SERVICE_UUID_TRANSPARENT", "getFLIPPER_SERVICE_UUID_TRANSPARENT", "GATT_STATUS_CONN_TERMINATE_LOCAL_HOST", "GATT_STATUS_CONN_TERMINATE_PEER_USER", "GATT_STATUS_CONN_TIMEOUT", "GATT_STATUS_FAILURE", "GATT_STATUS_GENERIC_ERROR", "KEY_CONFIRMED_FLIPPER_ADDRESSES", "KNOWN_FLIPPER_BLE_MANUFACTURER_IDS", "", "KNOWN_FLIPPER_USB_PRODUCT_IDS", "KNOWN_FLIPPER_USB_VENDOR_IDS", "MAX_DISCOVERED_DEVICES", "MAX_SERIAL_CHAR_VALUE_BYTES", "MAX_TIMEOUT_RECONNECT_ATTEMPTS", "MAX_WRITE_START_ATTEMPTS", "MAX_WRITE_START_ATTEMPTS_CONTROL", "MIN_BLE_CHUNK_BYTES", "NOTIFICATION_ID", "NOTIFICATION_READY_POLL_MS", "NOTIFICATION_READY_WAIT_ATTEMPTS", "OVERFLOW_VALUE_SIZE_BYTES", "OVERFLOW_WAIT_POLL_MS", "OVERFLOW_WAIT_TIMEOUT_MS", "PREFS_BLE", "REQUESTED_ATT_MTU", "SCAN_TIMEOUT_MS", "TAG", "TIMEOUT_RECONNECT_BACKOFF_STEP_MS", "TIMEOUT_RECONNECT_DELAY_MS", "UNKNOWN_DEVICE_NAME", "USB_BAUD_RATE_CANDIDATES", "USB_DATA_BITS", "USB_PERMISSION_TIMEOUT_MS", "USB_READ_BUFFER_SIZE_BYTES", "USB_READ_TIMEOUT_MS", "USB_RPC_BAUD_RETRY_DRAIN_WINDOW_MS", "USB_RPC_PRIME_COMMANDS", "USB_RPC_PRIME_COMMAND_DELAY_MS", "USB_RPC_PRIME_DRAIN_WINDOW_MS", "USB_WRITE_CHUNK_SIZE_BYTES", "USB_WRITE_INTER_CHUNK_DELAY_MS", "USB_WRITE_TIMEOUT_MS", "WRITE_ACK_TIMEOUT_CONTROL_MS", "WRITE_ACK_TIMEOUT_MS", "WRITE_MUTEX_CONTROL_WAIT_TIMEOUT_MS", "WRITE_MUTEX_STANDARD_WAIT_TIMEOUT_MS", "WRITE_NO_RESPONSE_CHUNK_DELAY_CONTROL_MS", "WRITE_NO_RESPONSE_CHUNK_DELAY_MS", "WRITE_START_RETRY_DELAY_CONTROL_MS", "WRITE_START_RETRY_DELAY_MS", "startService", "", "context", "Landroid/content/Context;", "stopService", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getFLIPPER_SERVICE_UUID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getFLIPPER_SERVICE_UUID_BLACK() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getFLIPPER_SERVICE_UUID_TRANSPARENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getFLIPPER_SERIAL_SERVICE_UUID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getFLIPPER_SERIAL_TX_UUID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getFLIPPER_SERIAL_RX_UUID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getFLIPPER_SERIAL_OVERFLOW_UUID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getFLIPPER_SERIAL_RESET_UUID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.UUID getCLIENT_CHARACTERISTIC_CONFIG() {
            return null;
        }
        
        public final void startService(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        public final void stopService(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/vesper/flipper/ble/FlipperBleService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/vesper/flipper/ble/FlipperBleService;)V", "getService", "Lcom/vesper/flipper/ble/FlipperBleService;", "app_debug"})
    public final class LocalBinder extends android.os.Binder {
        
        public LocalBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.FlipperBleService getService() {
            return null;
        }
    }
}