package com.vesper.flipper.ble;

import com.flipperdevices.protobuf.Flipper;
import com.flipperdevices.protobuf.app.Application;
import com.flipperdevices.protobuf.desktop.Desktop;
import com.flipperdevices.protobuf.screen.Gui;
import com.google.protobuf.ByteString;
import com.vesper.flipper.domain.model.*;
import kotlinx.coroutines.*;
import kotlinx.coroutines.flow.*;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.flipperdevices.protobuf.storage.Storage;
import com.flipperdevices.protobuf.system.System;

/**
 * Protocol handler for Flipper Zero serial communication.
 * Implements the Protobuf-based RPC protocol used by Flipper.
 */
@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00c8\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00bf\u00022\u00020\u0001:\u0012\u00be\u0002\u00bf\u0002\u00c0\u0002\u00c1\u0002\u00c2\u0002\u00c3\u0002\u00c4\u0002\u00c5\u0002\u00c6\u0002B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u0002060>2\u0006\u0010?\u001a\u000206H\u0002J\u0018\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020<H\u0002J&\u0010D\u001a\b\u0012\u0004\u0012\u0002060>2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002060>2\b\u0010F\u001a\u0004\u0018\u000106H\u0002J\u001a\u0010G\u001a\u0004\u0018\u0001062\u000e\u0010H\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010>H\u0002J\u0012\u0010I\u001a\u0004\u0018\u0001062\u0006\u0010J\u001a\u00020KH\u0002J\u001c\u0010L\u001a\u0004\u0018\u0001062\u0006\u0010J\u001a\u00020K2\b\u0010M\u001a\u0004\u0018\u000106H\u0002J)\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020P2\u0017\u0010Q\u001a\u0013\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T0R\u00a2\u0006\u0002\bUH\u0002J\u001e\u0010V\u001a\u00020<2\u0006\u0010C\u001a\u00020<2\u0006\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010XJ\u0016\u0010Y\u001a\u00020<2\u0006\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010ZJ\u001e\u0010[\u001a\u0002062\u0006\u0010\\\u001a\u0002062\u0006\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010]J\u001e\u0010^\u001a\u0002062\u0006\u0010C\u001a\u00020<2\u0006\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010XJ,\u0010_\u001a\b\u0012\u0004\u0012\u00020`0>2\u0006\u0010a\u001a\u00020<2\u0006\u0010O\u001a\u00020P2\u0006\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010bJ\u0010\u0010c\u001a\u00020T2\u0006\u0010d\u001a\u00020\nH\u0002J\u0010\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020<H\u0002J\u0016\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ \u0010k\u001a\u00020\n2\u0006\u0010i\u001a\u0002062\b\b\u0002\u0010l\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010mJ\u0018\u0010n\u001a\u00020T2\u0006\u0010g\u001a\u00020<2\u0006\u0010o\u001a\u00020PH\u0002J\u0016\u0010p\u001a\u00020\u00172\u0006\u0010q\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ\u0016\u0010r\u001a\u00020\u00172\u0006\u0010s\u001a\u00020\fH\u0082@\u00a2\u0006\u0002\u0010tJ\u0010\u0010u\u001a\u00020P2\u0006\u0010v\u001a\u00020PH\u0002J\u0016\u0010w\u001a\u00020\n2\u0006\u0010?\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ*\u0010x\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000106\u0012\n\u0012\b\u0012\u0004\u0012\u0002060>0y2\f\u0010z\u001a\b\u0012\u0004\u0012\u0002060>H\u0002J\u0012\u0010{\u001a\u0004\u0018\u0001062\u0006\u0010|\u001a\u000206H\u0002J\u0010\u0010}\u001a\u0002062\u0006\u0010d\u001a\u00020\nH\u0002J\u0010\u0010~\u001a\u00020T2\u0006\u0010\u007f\u001a\u000206H\u0002J!\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020`0>2\u0007\u0010\u0081\u0001\u001a\u00020<2\u0007\u0010\u0082\u0001\u001a\u00020PH\u0002J=\u0010\u0083\u0001\u001a\u0004\u0018\u0001062\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060\u0085\u00012\u0014\u0010\u0086\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u0002060\u0087\u0001\"\u000206H\u0002\u00a2\u0006\u0003\u0010\u0088\u0001J\u0015\u0010\u0089\u0001\u001a\u0002062\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J\u0010\u0010\u008c\u0001\u001a\u00020\nH\u0086@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0010\u0010\u008e\u0001\u001a\u00020\nH\u0086@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0018\u0010\u008f\u0001\u001a\u00020T2\u0006\u0010g\u001a\u00020<H\u0082@\u00a2\u0006\u0003\u0010\u0090\u0001J\u000f\u0010\u0091\u0001\u001a\u00020\u00172\u0006\u0010?\u001a\u000206J\u0013\u0010\u0092\u0001\u001a\u00020\u00172\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002J\u0011\u0010\u0093\u0001\u001a\u00020\u00172\u0006\u0010|\u001a\u000206H\u0002J\u0011\u0010\u0094\u0001\u001a\u00020\u00172\u0006\u0010?\u001a\u000206H\u0002J\t\u0010\u0095\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010\u0096\u0001\u001a\u00020\u00172\u0007\u0010\u0097\u0001\u001a\u00020\"H\u0002J\u0013\u0010\u0098\u0001\u001a\u00020\u00172\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\u0013\u0010\u009b\u0001\u001a\u00020\u00172\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\u0011\u0010\u009c\u0001\u001a\u00020T2\u0006\u0010d\u001a\u00020\nH\u0002J\u0017\u0010\u009d\u0001\u001a\u00020\n2\u0006\u0010i\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ\u0012\u0010\u009e\u0001\u001a\u00020\u00052\u0007\u0010\u009f\u0001\u001a\u000206H\u0002J\u0012\u0010\u00a0\u0001\u001a\u00020\u00052\u0007\u0010\u00a1\u0001\u001a\u000206H\u0002J\u0012\u0010\u00a2\u0001\u001a\u00020\u00052\u0007\u0010\u00a1\u0001\u001a\u000206H\u0002J\u0011\u0010\u00a3\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u000206H\u0002J(\u0010\u00a4\u0001\u001a\u0004\u0018\u0001062\t\b\u0002\u0010\u00a5\u0001\u001a\u00020\"2\t\b\u0002\u0010\u00a6\u0001\u001a\u00020\"H\u0082@\u00a2\u0006\u0003\u0010\u00a7\u0001J\"\u0010\u00a8\u0001\u001a\u00020\n2\u0007\u0010\u00a9\u0001\u001a\u0002062\u0007\u0010\u00aa\u0001\u001a\u000206H\u0086@\u00a2\u0006\u0003\u0010\u00ab\u0001J\t\u0010\u00ac\u0001\u001a\u00020PH\u0002J\t\u0010\u00ad\u0001\u001a\u00020PH\u0002J\u0011\u0010\u00ae\u0001\u001a\u0002062\u0006\u0010?\u001a\u000206H\u0002J\u0019\u0010\u00af\u0001\u001a\u00020\n2\u0006\u0010?\u001a\u0002062\u0006\u0010d\u001a\u00020\nH\u0002J\u0012\u0010\u00b0\u0001\u001a\u0002062\u0007\u0010\u00b1\u0001\u001a\u000206H\u0002J\u001b\u0010\u00b2\u0001\u001a\u0002062\u0007\u0010\u00b3\u0001\u001a\u0002062\u0007\u0010\u00b4\u0001\u001a\u000206H\u0002J\u0007\u0010\u00b5\u0001\u001a\u00020TJ\u0007\u0010\u00b6\u0001\u001a\u00020TJ\u0010\u0010\u00b7\u0001\u001a\u00020T2\u0007\u0010\u0099\u0001\u001a\u00020PJ\'\u0010\u00b8\u0001\u001a\u0004\u0018\u00010P2\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060\u0085\u0001H\u0002\u00a2\u0006\u0003\u0010\u00b9\u0001J\'\u0010\u00ba\u0001\u001a\u0004\u0018\u00010P2\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060\u0085\u0001H\u0002\u00a2\u0006\u0003\u0010\u00b9\u0001J\u001c\u0010\u00bb\u0001\u001a\u0004\u0018\u00010P2\t\u0010\u00bc\u0001\u001a\u0004\u0018\u000106H\u0002\u00a2\u0006\u0003\u0010\u00bd\u0001J=\u0010\u00be\u0001\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060\u0085\u00012\u0014\u0010\u0086\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u0002060\u0087\u0001\"\u000206H\u0002\u00a2\u0006\u0003\u0010\u00bf\u0001J\u001a\u0010\u00c0\u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010\u00c1\u0001\u001a\u000206H\u0002\u00a2\u0006\u0003\u0010\u00c2\u0001J\u0018\u0010\u00c3\u0001\u001a\b\u0012\u0004\u0012\u0002060>2\u0007\u0010\u00c4\u0001\u001a\u000206H\u0002J\u0012\u0010\u00c5\u0001\u001a\u00020\n2\u0007\u0010\u00c6\u0001\u001a\u00020<H\u0002J\u0012\u0010\u00c7\u0001\u001a\u00020\n2\u0007\u0010\u00c6\u0001\u001a\u00020<H\u0002J\u001a\u0010\u00c8\u0001\u001a\u0004\u0018\u00010P2\u0007\u0010\u00c1\u0001\u001a\u000206H\u0002\u00a2\u0006\u0003\u0010\u00bd\u0001J\u0012\u0010\u00c9\u0001\u001a\u00020\n2\u0007\u0010\u00c6\u0001\u001a\u00020<H\u0002J\u0012\u0010\u00ca\u0001\u001a\u00020\n2\u0007\u0010\u00c6\u0001\u001a\u00020<H\u0002J\u0012\u0010\u00cb\u0001\u001a\u00020\n2\u0007\u0010\u00c6\u0001\u001a\u00020<H\u0002J\u0012\u0010\u00cc\u0001\u001a\u00020\n2\u0007\u0010\u00c6\u0001\u001a\u00020<H\u0002J=\u0010\u00cd\u0001\u001a\u0004\u0018\u00010P2\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060\u0085\u00012\u0014\u0010\u0086\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u0002060\u0087\u0001\"\u000206H\u0002\u00a2\u0006\u0003\u0010\u00ce\u0001J\u0010\u0010\u00cf\u0001\u001a\u00020TH\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0013\u0010\u00d0\u0001\u001a\u0004\u0018\u00010K2\u0006\u0010?\u001a\u000206H\u0002J\u001a\u0010\u00d1\u0001\u001a\u0004\u0018\u00010P2\u0007\u0010\u00d2\u0001\u001a\u000206H\u0002\u00a2\u0006\u0003\u0010\u00bd\u0001J\u001b\u0010\u00d3\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u00d4\u0001\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0003\u0010\u00d5\u0001J\u0010\u0010\u00d6\u0001\u001a\u000206H\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0019\u0010\u00d7\u0001\u001a\u00020\u00052\b\b\u0002\u0010q\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ\u001b\u0010\u00d8\u0001\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010q\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ\u0010\u0010\u00d9\u0001\u001a\u00020T2\u0007\u0010\u00c6\u0001\u001a\u00020<J\u0010\u0010\u00da\u0001\u001a\u00020TH\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0017\u0010\u00db\u0001\u001a\u00020\n2\u0006\u0010i\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ\u0017\u0010\u00dc\u0001\u001a\u00020\n2\u0006\u0010i\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ\u0013\u0010\u00dd\u0001\u001a\u0005\u0018\u00010\u00de\u0001H\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u001e\u0010\u00df\u0001\u001a\u0005\u0018\u00010\u00e0\u00012\u0007\u0010\u0081\u0001\u001a\u00020<2\u0007\u0010\u00e1\u0001\u001a\u00020PH\u0002J\u0010\u0010\u00e2\u0001\u001a\u00020\u0005H\u0086@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0010\u0010\u00e3\u0001\u001a\u00020\u0005H\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\t\u0010\u00e4\u0001\u001a\u00020TH\u0002J>\u0010\u00e5\u0001\u001a\b\u0012\u0004\u0012\u0002060>2\r\u0010\u00e6\u0001\u001a\b\u0012\u0004\u0012\u0002060>2\t\u0010\u00e7\u0001\u001a\u0004\u0018\u0001062\u0013\u0010\u00e8\u0001\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020605H\u0002J\u001c\u0010\u00e9\u0001\u001a\u0005\u0018\u00010\u008b\u00012\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010ZJ\u001b\u0010\u00ea\u0001\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010ZJ\u001b\u0010\u00eb\u0001\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010ZJ\u001d\u0010\u00ec\u0001\u001a\u000f\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060\u0085\u0001H\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u001d\u0010\u00ed\u0001\u001a\u000f\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060\u0085\u0001H\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u001a\u0010\u00ee\u0001\u001a\u0005\u0018\u00010\u00ef\u00012\u0006\u0010i\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ\u0015\u0010\u00f0\u0001\u001a\u00030\u00f1\u00012\t\u0010\u00f2\u0001\u001a\u0004\u0018\u000106H\u0002J\u0012\u0010\u00f3\u0001\u001a\u00020\"2\u0007\u0010\u00f4\u0001\u001a\u00020PH\u0002J\u0012\u0010\u00f5\u0001\u001a\u00020\"2\u0007\u0010\u00f4\u0001\u001a\u00020PH\u0002J\t\u0010\u00f6\u0001\u001a\u00020TH\u0002J7\u0010\u00f7\u0001\u001a\u00030\u009a\u00012\r\u0010\u00f8\u0001\u001a\b\u0012\u0004\u0012\u0002060>2\u000b\b\u0002\u0010\u00e7\u0001\u001a\u0004\u0018\u0001062\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0003\u0010\u00f9\u0001J7\u0010\u00fa\u0001\u001a\u00030\u009a\u00012\r\u0010\u00f8\u0001\u001a\b\u0012\u0004\u0012\u0002060>2\u000b\b\u0002\u0010\u00e7\u0001\u001a\u0004\u0018\u0001062\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0003\u0010\u00f9\u0001J#\u0010\u00fb\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u00fc\u0001\u001a\u0002062\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010]J#\u0010\u00fd\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u00fc\u0001\u001a\u0002062\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010]J\u001a\u0010\u00fe\u0001\u001a\u00030\u009a\u00012\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010ZJ\"\u0010\u00ff\u0001\u001a\u00030\u009a\u00012\u0006\u0010i\u001a\u0002062\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010]J@\u0010\u0080\u0002\u001a\u00030\u009a\u00012\r\u0010\u00e6\u0001\u001a\b\u0012\u0004\u0012\u0002060>2\u0007\u0010\u00fc\u0001\u001a\u0002062\u000b\b\u0002\u0010\u00e7\u0001\u001a\u0004\u0018\u0001062\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0003\u0010\u0081\u0002J\u0017\u0010\u0082\u0002\u001a\u00020\n2\u0006\u0010?\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ\u0018\u0010\u0083\u0002\u001a\u00020\n2\u0006\u0010?\u001a\u00020<H\u0082@\u00a2\u0006\u0003\u0010\u0090\u0001J!\u0010\u0084\u0002\u001a\u00020\n2\u0006\u0010?\u001a\u00020<2\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010XJ\u001a\u0010\u0085\u0002\u001a\u00030\u009a\u00012\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010ZJ&\u0010\u0086\u0002\u001a\u00020\n2\b\u0010\u00b1\u0001\u001a\u00030\u0087\u00022\n\b\u0002\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0086@\u00a2\u0006\u0003\u0010\u008a\u0002J$\u0010\u008b\u0002\u001a\u00020\u00172\b\u0010\u00b1\u0001\u001a\u00030\u0087\u00022\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0082@\u00a2\u0006\u0003\u0010\u008a\u0002J&\u0010\u008c\u0002\u001a\u00020\n2\b\u0010\u00b1\u0001\u001a\u00030\u0087\u00022\n\b\u0002\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0086@\u00a2\u0006\u0003\u0010\u008a\u0002J,\u0010\u008d\u0002\u001a\u00020\u00172\u0006\u0010s\u001a\u00020\f2\b\u0010\u00b1\u0001\u001a\u00030\u0087\u00022\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0082@\u00a2\u0006\u0003\u0010\u008e\u0002J1\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u009a\u00012\b\u0010\u00b1\u0001\u001a\u00030\u0087\u00022\b\u0010\u0088\u0002\u001a\u00030\u0089\u00022\b\b\u0002\u0010W\u001a\u00020\"H\u0082@\u00a2\u0006\u0003\u0010\u0090\u0002J\u0017\u0010\u0091\u0002\u001a\u00020\n2\u0006\u0010i\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ\u001f\u0010\u0092\u0002\u001a\u00020\n2\u0006\u0010i\u001a\u0002062\u0006\u0010l\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u0010mJ\u0010\u0010\u0093\u0002\u001a\u00020\nH\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0017\u0010\u0094\u0002\u001a\u00020\n2\u0006\u0010i\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ\"\u0010\u0095\u0002\u001a\u00020\n2\u0007\u0010\u00a9\u0001\u001a\u0002062\u0007\u0010\u00aa\u0001\u001a\u000206H\u0082@\u00a2\u0006\u0003\u0010\u00ab\u0001J\u0017\u0010\u0096\u0002\u001a\u00020\n2\u0006\u0010i\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ\u0010\u0010\u0097\u0002\u001a\u00020\nH\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J!\u0010\u0098\u0002\u001a\u00020\n2\u0006\u0010i\u001a\u0002062\u0007\u0010\u0099\u0002\u001a\u00020<H\u0082@\u00a2\u0006\u0003\u0010\u009a\u0002J\u0018\u0010\u009b\u0002\u001a\u00020\u00172\u0007\u0010\u009c\u0002\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ\u0017\u0010\u009d\u0002\u001a\u00020\n2\u0006\u0010?\u001a\u000206H\u0086@\u00a2\u0006\u0002\u0010jJ\u0019\u0010\u009e\u0002\u001a\u0004\u0018\u00010\n2\u0006\u0010i\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ!\u0010\u009f\u0002\u001a\u0004\u0018\u00010\n2\u0006\u0010i\u001a\u0002062\u0006\u0010l\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u0010mJ\u0012\u0010\u00a0\u0002\u001a\u0004\u0018\u00010\nH\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0019\u0010\u00a1\u0002\u001a\u0004\u0018\u00010\n2\u0006\u0010i\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ5\u0010\u00a2\u0002\u001a\u0004\u0018\u00010`2\b\b\u0002\u0010W\u001a\u00020\"2\u0017\u0010Q\u001a\u0013\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T0R\u00a2\u0006\u0002\bUH\u0082@\u00a2\u0006\u0003\u0010\u00a3\u0002J9\u0010\u00a4\u0002\u001a\b\u0012\u0004\u0012\u00020`0>2\b\b\u0002\u0010W\u001a\u00020\"2\u0017\u0010Q\u001a\u0013\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T0R\u00a2\u0006\u0002\bUH\u0082@\u00a2\u0006\u0003\u0010\u00a3\u0002J$\u0010\u00a5\u0002\u001a\u0004\u0018\u00010\n2\u0007\u0010\u00a9\u0001\u001a\u0002062\u0007\u0010\u00aa\u0001\u001a\u000206H\u0082@\u00a2\u0006\u0003\u0010\u00ab\u0001J\u0019\u0010\u00a6\u0002\u001a\u0004\u0018\u00010\n2\u0006\u0010i\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ\u0012\u0010\u00a7\u0002\u001a\u0004\u0018\u00010\nH\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J#\u0010\u00a8\u0002\u001a\u0004\u0018\u00010\n2\u0006\u0010i\u001a\u0002062\u0007\u0010\u0099\u0002\u001a\u00020<H\u0082@\u00a2\u0006\u0003\u0010\u009a\u0002J\u0017\u0010\u00a9\u0002\u001a\u00020\n2\u0006\u0010?\u001a\u000206H\u0082@\u00a2\u0006\u0002\u0010jJ\u000f\u0010\u00aa\u0002\u001a\u00020T2\u0006\u0010s\u001a\u00020\fJ\u0013\u0010\u00ab\u0002\u001a\u00020\u00172\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\u0012\u0010\u00ac\u0002\u001a\u00020\u00172\u0007\u0010\u0097\u0001\u001a\u00020\"H\u0002J\u0019\u0010\u00ad\u0002\u001a\u00020\u00172\u0006\u0010?\u001a\u0002062\u0006\u0010d\u001a\u00020\nH\u0002J\u0011\u0010\u00ae\u0002\u001a\u0002062\u0006\u0010d\u001a\u00020\nH\u0002J.\u0010\u00af\u0002\u001a\u0004\u0018\u00010\n2\u0006\u0010s\u001a\u00020\f2\b\u0010\u00b1\u0001\u001a\u00030\u0087\u00022\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0082@\u00a2\u0006\u0003\u0010\u008e\u0002J\u0010\u0010\u00b0\u0002\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0010\u0010\u00b1\u0002\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0003\u0010\u008d\u0001J\u0012\u0010\u00b2\u0002\u001a\u00020\"2\u0007\u0010\u00c1\u0001\u001a\u00020PH\u0002J]\u0010\u00b3\u0002\u001a\u0003H\u00b4\u0002\"\u0005\b\u0000\u0010\u00b4\u00022\u0007\u0010\u00b5\u0002\u001a\u0002062\b\b\u0002\u0010W\u001a\u00020\"2\u000f\u0010\u00b6\u0002\u001a\n\u0012\u0005\u0012\u0003H\u00b4\u00020\u00b7\u00022\u001f\u0010\u00b8\u0002\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00b4\u00020\u00b9\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010RH\u0082@\u00a2\u0006\u0003\u0010\u00ba\u0002J!\u0010\u00bb\u0002\u001a\u00020\n2\u0006\u0010i\u001a\u0002062\u0007\u0010\u0099\u0002\u001a\u00020<H\u0086@\u00a2\u0006\u0003\u0010\u009a\u0002J\u001b\u0010\u00bc\u0002\u001a\u00020T2\u0007\u0010\u00bd\u0002\u001a\u00020/2\u0007\u0010\u00c1\u0001\u001a\u00020\"H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\n01\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020605X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020605X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u00c7\u0002"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol;", "", "()V", "_cliStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/vesper/flipper/ble/CliCapabilityStatus;", "_firmwareCompatibility", "Lcom/vesper/flipper/ble/FirmwareCompatibilityProfile;", "_responseFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/vesper/flipper/ble/ProtocolResponse;", "bleService", "Lcom/vesper/flipper/ble/FlipperBleService;", "cliStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getCliStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "commandMutex", "Lkotlinx/coroutines/sync/Mutex;", "currentRequestId", "Lkotlin/UInt;", "I", "desktopLockProbeSupported", "", "Ljava/lang/Boolean;", "firmwareCompatibility", "getFirmwareCompatibility", "firmwareProfile", "Lcom/vesper/flipper/ble/FlipperProtocol$FirmwareProfile;", "immediateRpcCommandId", "Ljava/util/concurrent/atomic/AtomicInteger;", "isWriting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastCliProbeAtMs", "", "lastDesktopLockProbeAtMs", "lastRpcActivityAtMs", "lastRpcExecutionSnapshot", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcExecutionSnapshot;", "pendingRequest", "Lcom/vesper/flipper/ble/PendingRequest;", "rawBinaryCollector", "Lcom/vesper/flipper/ble/FlipperProtocol$RawBinaryCollector;", "rawCliCollector", "Lcom/vesper/flipper/ble/FlipperProtocol$RawCliCollector;", "remoteHealthRefreshInFlight", "responseBuffer", "Ljava/io/ByteArrayOutputStream;", "responseFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getResponseFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "rpcButtonArgCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "rpcStartCandidateCache", "scope", "Lkotlinx/coroutines/CoroutineScope;", "writeQueue", "Lkotlinx/coroutines/channels/Channel;", "", "buildCliCommandVariants", "", "command", "buildCommand", "commandType", "", "payload", "buildRpcAppCandidates", "baseCandidates", "customOverride", "buildRpcAppStartCacheKey", "appCandidates", "buildRpcButtonCacheKey", "plan", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcCommandPlan;", "buildRpcExecutionCacheKey", "appStartKey", "buildRpcMainPacket", "commandId", "", "build", "Lkotlin/Function1;", "Lcom/flipperdevices/protobuf/Flipper$Main$Builder;", "", "Lkotlin/ExtensionFunctionType;", "collectRawBinaryResponseAttempt", "timeoutMs", "([BJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectRawBinaryTailResponse", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectRawCliResponse", "commandText", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectRawCliResponseAttempt", "collectRpcMainResponsesOnce", "Lcom/flipperdevices/protobuf/Flipper$Main;", "request", "([BIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completePendingRequest", "response", "consumeLeadingRpcFrames", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult;", "buffer", "createDirectory", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "recursive", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discardBufferedPrefix", "prefixSize", "ensureRpcAvailableLocked", "detail", "ensureTransportConnected", "service", "(Lcom/vesper/flipper/ble/FlipperBleService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "estimateBatteryPercentFromMillivolts", "mv", "executeRpcAppCommand", "extractAppOverrideAndArgs", "Lkotlin/Pair;", "tokens", "extractFirmwareHint", "output", "extractResponseText", "failPendingRequest", "message", "findRpcMainMessages", "bytes", "expectedCommandId", "firstNonBlank", "values", "", "keys", "", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/lang/String;", "formatAppErrorSuffix", "errorInfo", "Lcom/vesper/flipper/ble/FlipperProtocol$AppErrorInfo;", "getDeviceInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStorageInfo", "handleNonProtocolResponse", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasRpcAppCommandMapping", "isFatalAppError", "isLikelyCliText", "isLikelyNoOutputCommand", "isRawCollectorActive", "isRemoteFastPathReady", "nowMs", "isRetryableAppCommandStatus", "status", "Lcom/flipperdevices/protobuf/Flipper$CommandStatus;", "isRetryableStorageWriteStatus", "learnFirmwareProfile", "listDirectory", "markCliReady", "rawOutput", "markCliUnavailable", "reason", "markProbeDeferred", "markRpcReady", "maybeUnlockDesktopIfNeededLocked", "lockProbeTimeoutMs", "unlockTimeoutMs", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "move", "sourcePath", "destPath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextImmediateRpcCommandId", "nextRpcProbeCommandId", "normalizeCliCommand", "normalizeCliResponse", "normalizeInfoKey", "key", "normalizeStoragePath", "basePath", "childName", "onConnectionReset", "onWriteComplete", "onWriteError", "parseBatteryLevelFromCapacity", "(Ljava/util/Map;)Ljava/lang/Integer;", "parseBatteryLevelFromVoltage", "parseBatteryPercentFromBatteryKey", "rawValue", "(Ljava/lang/String;)Ljava/lang/Integer;", "parseBoolean", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/lang/Boolean;", "parseBooleanText", "value", "(Ljava/lang/String;)Ljava/lang/Boolean;", "parseCommandArguments", "argumentTail", "parseDataResponse", "data", "parseErrorResponse", "parseFirstInt", "parseFrame", "parseInfoResponse", "parseListResponse", "parseOkResponse", "parsePercent", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/lang/Integer;", "parseResponses", "parseRpcCommandPlan", "parseVoltageMillivolts", "raw", "probeCliAvailability", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "probeRawCliOutput", "probeRpcAvailability", "probeRpcTransportAvailability", "processIncomingData", "processWriteQueue", "readFile", "readFileBinary", "readStorageInfoFromRpcLocked", "Lcom/vesper/flipper/domain/model/StorageInfo;", "readVarint", "Lcom/vesper/flipper/ble/FlipperProtocol$VarintReadResult;", "startOffset", "recoverCliFromRpcSession", "recoverCliFromRpcSessionLocked", "refreshFirmwareCompatibility", "reorderCandidatesWithCache", "candidates", "cacheKey", "cache", "requestAppErrorInfoLocked", "requestAppLockStatusLocked", "requestDesktopLockStatusLocked", "requestDeviceInfoMapLocked", "requestPowerInfoMapLocked", "requestStorageInfoForPathLocked", "Lcom/flipperdevices/protobuf/storage/Storage$InfoResponse;", "resolveFirmwareFamily", "Lcom/vesper/flipper/ble/FirmwareFamily;", "firmwareHint", "resolveLegacyWriteTimeoutMs", "contentSize", "resolveRpcStorageWriteTimeoutMs", "scheduleRemoteInputHealthRefresh", "sendAppButtonConfirmEventAttemptLocked", "buttonArgsCandidates", "(Ljava/util/List;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendAppButtonConfirmEventLocked", "sendAppButtonPressReleaseStatusLocked", "args", "sendAppButtonPressStatusLocked", "sendAppButtonReleaseStatusLocked", "sendAppLoadFileWithRetry", "sendAppStartWithCandidates", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCliCommand", "sendCommand", "sendCommandLocked", "sendDesktopUnlockStatusLocked", "sendGuiInputEvent", "Lcom/flipperdevices/protobuf/screen/Gui$InputKey;", "inputType", "Lcom/flipperdevices/protobuf/screen/Gui$InputType;", "(Lcom/flipperdevices/protobuf/screen/Gui$InputKey;Lcom/flipperdevices/protobuf/screen/Gui$InputType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGuiInputEventFireAndForgetLocked", "sendGuiInputEventImmediate", "sendGuiInputEventPacketImmediate", "(Lcom/vesper/flipper/ble/FlipperBleService;Lcom/flipperdevices/protobuf/screen/Gui$InputKey;Lcom/flipperdevices/protobuf/screen/Gui$InputType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGuiInputEventStatusLocked", "(Lcom/flipperdevices/protobuf/screen/Gui$InputKey;Lcom/flipperdevices/protobuf/screen/Gui$InputType;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLegacyCreateDirectoryLocked", "sendLegacyDeleteLocked", "sendLegacyDeviceInfoLocked", "sendLegacyListDirectoryLocked", "sendLegacyMoveLocked", "sendLegacyReadFileLocked", "sendLegacyStorageInfoLocked", "sendLegacyWriteFileLocked", "content", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRawCli", "text", "sendRawCliCommand", "sendRpcCreateDirectoryLocked", "sendRpcDeleteLocked", "sendRpcDeviceInfoLocked", "sendRpcListDirectoryLocked", "sendRpcMainAndAwaitResponse", "(JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRpcMainAndCollectResponses", "sendRpcMoveLocked", "sendRpcReadFileLocked", "sendRpcStorageInfoLocked", "sendRpcWriteFileLocked", "sendSingleCliCommand", "setBleService", "shouldFallbackToLegacy", "shouldProbeDesktopLockForRemoteInput", "shouldRetryWithNextVariant", "summarizeResponse", "trySendGuiInputViaRpcBootstrapLocked", "tryStartRpcSession", "tryStopRpcSession", "unsignedIntToLong", "withCommandLock", "T", "operation", "onTimeout", "Lkotlin/Function0;", "block", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFile", "writeVarint", "stream", "AppErrorInfo", "Companion", "FirmwareProfile", "RawBinaryCollector", "RawCliCollector", "RpcCommandPlan", "RpcExecutionSnapshot", "RpcFrameConsumeResult", "VarintReadResult", "app_debug"})
public final class FlipperProtocol {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.Nullable
    private com.vesper.flipper.ble.FlipperBleService bleService;
    @org.jetbrains.annotations.NotNull
    private final java.io.ByteArrayOutputStream responseBuffer = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile com.vesper.flipper.ble.PendingRequest pendingRequest;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.channels.Channel<byte[]> writeQueue = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.atomic.AtomicBoolean isWriting = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.sync.Mutex commandMutex = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile com.vesper.flipper.ble.FlipperProtocol.RawCliCollector rawCliCollector;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile com.vesper.flipper.ble.FlipperProtocol.RawBinaryCollector rawBinaryCollector;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.NotNull
    private volatile com.vesper.flipper.ble.FlipperProtocol.FirmwareProfile firmwareProfile = com.vesper.flipper.ble.FlipperProtocol.FirmwareProfile.UNKNOWN;
    @kotlin.jvm.Volatile
    private volatile long lastCliProbeAtMs = 0L;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile java.lang.Boolean desktopLockProbeSupported;
    @kotlin.jvm.Volatile
    private volatile long lastDesktopLockProbeAtMs = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> rpcStartCandidateCache = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> rpcButtonArgCache = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private volatile com.vesper.flipper.ble.FlipperProtocol.RpcExecutionSnapshot lastRpcExecutionSnapshot;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.atomic.AtomicBoolean remoteHealthRefreshInFlight = null;
    @kotlin.jvm.Volatile
    private volatile long lastRpcActivityAtMs = 0L;
    private int currentRequestId = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.atomic.AtomicInteger immediateRpcCommandId = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.vesper.flipper.ble.ProtocolResponse> _responseFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<com.vesper.flipper.ble.ProtocolResponse> responseFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.CliCapabilityStatus> _cliStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CliCapabilityStatus> cliStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.vesper.flipper.ble.FirmwareCompatibilityProfile> _firmwareCompatibility = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FirmwareCompatibilityProfile> firmwareCompatibility = null;
    public static final long COMMAND_TIMEOUT_MS = 5000L;
    private static final int MAX_FRAME_SIZE = 262144;
    private static final long RAW_CLI_TIMEOUT_MS = 3000L;
    private static final long RAW_CLI_PROBE_TIMEOUT_MS = 900L;
    private static final long RAW_CLI_QUIET_PERIOD_MS = 220L;
    private static final long RAW_BINARY_QUIET_PERIOD_MS = 120L;
    private static final double CLI_TEXT_PRINTABLE_RATIO_MIN = 0.7;
    private static final long CLI_PROBE_CACHE_MS = 10000L;
    private static final long COMMAND_MUTEX_LOCK_TIMEOUT_MS = 8000L;
    private static final long COMMAND_MUTEX_LOCK_RPC_APP_TIMEOUT_MS = 30000L;
    private static final long RPC_RESET_RETRY_DELAY_MS = 250L;
    private static final long RPC_SESSION_START_DELAY_MS = 250L;
    private static final long RPC_SESSION_STOP_DELAY_MS = 250L;
    private static final long RPC_SESSION_STOP_GUARD_WINDOW_MS = 5000L;
    private static final long RPC_RETRY_COMMAND_TIMEOUT_MS = 4000L;
    private static final long RPC_COMMAND_TIMEOUT_MS = 1500L;
    private static final long RPC_APP_COMMAND_TIMEOUT_MS = 1800L;
    private static final long RPC_APP_START_TIMEOUT_MS = 1300L;
    private static final long RPC_APP_LOAD_TIMEOUT_MS = 1900L;
    private static final long RPC_APP_BUTTON_TIMEOUT_MS = 1100L;
    private static final long RPC_APP_LOCK_TIMEOUT_MS = 650L;
    private static final long RPC_APP_ERROR_TIMEOUT_MS = 650L;
    private static final long RPC_APP_FALLBACK_GUI_TIMEOUT_MS = 900L;
    private static final long RPC_APP_START_SETTLE_DELAY_MS = 90L;
    private static final long RPC_APP_START_ALT_TIMEOUT_MS = 650L;
    private static final long RPC_APP_BUTTON_ALT_TIMEOUT_MS = 700L;
    private static final long RPC_APP_COMMAND_RETRY_DELAY_MS = 120L;
    private static final int RPC_APP_COMMAND_MAX_RETRIES = 2;
    private static final long RPC_APP_FAST_REPEAT_WINDOW_MS = 15000L;
    private static final long RPC_STORAGE_COMMAND_TIMEOUT_MS = 4000L;
    private static final long RPC_STORAGE_WRITE_BASE_TIMEOUT_MS = 8000L;
    private static final long RPC_STORAGE_WRITE_PER_KIB_TIMEOUT_MS = 450L;
    private static final long RPC_STORAGE_WRITE_TIMEOUT_MS = 120000L;
    private static final int RPC_STORAGE_WRITE_MAX_ATTEMPTS = 3;
    private static final long RPC_STORAGE_WRITE_RETRY_DELAY_MS = 300L;
    private static final long RPC_CONTINUATION_COLLECT_WINDOW_MS = 900L;
    private static final long RPC_REMOTE_INPUT_ACK_TIMEOUT_MS = 900L;
    private static final long RPC_REMOTE_RELEASE_TIMEOUT_MS = 1100L;
    private static final long RPC_REMOTE_LOCK_TIMEOUT_MS = 450L;
    private static final long RPC_REMOTE_UNLOCK_TIMEOUT_MS = 700L;
    private static final long RPC_REMOTE_LOCK_CHECK_CACHE_MS = 3000L;
    private static final long RPC_REMOTE_FAST_RPC_STATUS_MAX_AGE_MS = 7500L;
    private static final int RPC_REMOTE_IMMEDIATE_WRITE_ATTEMPTS = 2;
    private static final long RPC_REMOTE_IMMEDIATE_RETRY_DELAY_MS = 12L;
    private static final long RPC_REMOTE_BOOTSTRAP_DELAY_MS = 90L;
    private static final long RPC_REMOTE_BOOTSTRAP_LOCK_TIMEOUT_MS = 450L;
    private static final long DESKTOP_LOCK_PROBE_RETRY_MS = 30000L;
    private static final long LEGACY_WRITE_BASE_TIMEOUT_MS = 7500L;
    private static final long LEGACY_WRITE_PER_KIB_TIMEOUT_MS = 350L;
    private static final long LEGACY_WRITE_TIMEOUT_MS = 90000L;
    private static final int BATTERY_MIN_MV = 3300;
    private static final int BATTERY_MAX_MV = 4200;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String RPC_APP_START_ARGUMENT = "RPC";
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> CLI_PROBE_COMMANDS = null;
    public static final byte CMD_LIST = (byte)1;
    public static final byte CMD_READ = (byte)2;
    public static final byte CMD_WRITE = (byte)3;
    public static final byte CMD_MKDIR = (byte)4;
    public static final byte CMD_DELETE = (byte)5;
    public static final byte CMD_MOVE = (byte)6;
    public static final byte CMD_INFO = (byte)7;
    public static final byte CMD_STORAGE_INFO = (byte)8;
    public static final byte CMD_CLI = (byte)16;
    public static final int RESP_OK = 0;
    public static final int RESP_ERROR = 1;
    public static final int RESP_LIST = 2;
    public static final int RESP_DATA = 3;
    public static final int RESP_INFO = 4;
    public static final int RESP_CLI = 16;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> COMPATIBILITY_MISS_MARKERS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> CLI_FAILURE_MARKERS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> FATAL_RPC_APP_ERROR_MARKERS = null;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ble.FlipperProtocol.Companion Companion = null;
    
    @javax.inject.Inject
    public FlipperProtocol() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<com.vesper.flipper.ble.ProtocolResponse> getResponseFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.CliCapabilityStatus> getCliStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.vesper.flipper.ble.FirmwareCompatibilityProfile> getFirmwareCompatibility() {
        return null;
    }
    
    public final void setBleService(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FlipperBleService service) {
    }
    
    public final void onConnectionReset() {
    }
    
    private final java.lang.Object processWriteQueue(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void processIncomingData(@org.jetbrains.annotations.NotNull
    byte[] data) {
    }
    
    private final java.lang.Object parseResponses(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Some paths send protobuf RPC frames without raw collectors.
     * Consume those frames here so they don't poison legacy frame parsing.
     */
    private final com.vesper.flipper.ble.FlipperProtocol.RpcFrameConsumeResult consumeLeadingRpcFrames(byte[] buffer) {
        return null;
    }
    
    private final void discardBufferedPrefix(byte[] buffer, int prefixSize) {
    }
    
    private final java.lang.Object handleNonProtocolResponse(byte[] buffer, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.vesper.flipper.ble.ProtocolResponse parseFrame(byte[] data) {
        return null;
    }
    
    private final com.vesper.flipper.ble.ProtocolResponse parseOkResponse(byte[] data) {
        return null;
    }
    
    private final com.vesper.flipper.ble.ProtocolResponse parseErrorResponse(byte[] data) {
        return null;
    }
    
    private final com.vesper.flipper.ble.ProtocolResponse parseListResponse(byte[] data) {
        return null;
    }
    
    private final com.vesper.flipper.ble.ProtocolResponse parseDataResponse(byte[] data) {
        return null;
    }
    
    private final com.vesper.flipper.ble.ProtocolResponse parseInfoResponse(byte[] data) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object listDirectory(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object readFile(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object readFileBinary(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object writeFile(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    byte[] content, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createDirectory(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull
    java.lang.String path, boolean recursive, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object move(@org.jetbrains.annotations.NotNull
    java.lang.String sourcePath, @org.jetbrains.annotations.NotNull
    java.lang.String destPath, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDeviceInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getStorageInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendLegacyListDirectoryLocked(java.lang.String path, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendLegacyReadFileLocked(java.lang.String path, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendLegacyWriteFileLocked(java.lang.String path, byte[] content, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendLegacyCreateDirectoryLocked(java.lang.String path, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendLegacyDeleteLocked(java.lang.String path, boolean recursive, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendLegacyMoveLocked(java.lang.String sourcePath, java.lang.String destPath, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendLegacyDeviceInfoLocked(kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendLegacyStorageInfoLocked(kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final byte[] buildCommand(byte commandType, byte[] payload) {
        return null;
    }
    
    private final java.lang.Object sendCommand(byte[] command, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendCommandLocked(byte[] command, long timeoutMs, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object ensureTransportConnected(com.vesper.flipper.ble.FlipperBleService service, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcListDirectoryLocked(java.lang.String path, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcReadFileLocked(java.lang.String path, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcWriteFileLocked(java.lang.String path, byte[] content, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcCreateDirectoryLocked(java.lang.String path, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcDeleteLocked(java.lang.String path, boolean recursive, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcMoveLocked(java.lang.String sourcePath, java.lang.String destPath, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcDeviceInfoLocked(kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcStorageInfoLocked(kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object readStorageInfoFromRpcLocked(kotlin.coroutines.Continuation<? super com.vesper.flipper.domain.model.StorageInfo> $completion) {
        return null;
    }
    
    private final java.lang.Object requestStorageInfoForPathLocked(java.lang.String path, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.storage.Storage.InfoResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object requestDeviceInfoMapLocked(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> $completion) {
        return null;
    }
    
    private final java.lang.Object requestPowerInfoMapLocked(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> $completion) {
        return null;
    }
    
    private final java.lang.Object ensureRpcAvailableLocked(java.lang.String detail, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final boolean shouldFallbackToLegacy(com.flipperdevices.protobuf.Flipper.CommandStatus status) {
        return false;
    }
    
    private final boolean isRetryableStorageWriteStatus(com.flipperdevices.protobuf.Flipper.CommandStatus status) {
        return false;
    }
    
    private final long resolveRpcStorageWriteTimeoutMs(int contentSize) {
        return 0L;
    }
    
    private final long resolveLegacyWriteTimeoutMs(int contentSize) {
        return 0L;
    }
    
    private final java.lang.String normalizeStoragePath(java.lang.String basePath, java.lang.String childName) {
        return null;
    }
    
    private final long unsignedIntToLong(int value) {
        return 0L;
    }
    
    private final java.lang.String normalizeInfoKey(java.lang.String key) {
        return null;
    }
    
    private final java.lang.String firstNonBlank(java.util.Map<java.lang.String, java.lang.String> values, java.lang.String... keys) {
        return null;
    }
    
    private final java.lang.Integer parsePercent(java.util.Map<java.lang.String, java.lang.String> values, java.lang.String... keys) {
        return null;
    }
    
    private final java.lang.Integer parseBatteryLevelFromCapacity(java.util.Map<java.lang.String, java.lang.String> values) {
        return null;
    }
    
    private final java.lang.Integer parseBatteryLevelFromVoltage(java.util.Map<java.lang.String, java.lang.String> values) {
        return null;
    }
    
    private final java.lang.Integer parseBatteryPercentFromBatteryKey(java.lang.String rawValue) {
        return null;
    }
    
    private final java.lang.Integer parseVoltageMillivolts(java.lang.String raw) {
        return null;
    }
    
    private final int estimateBatteryPercentFromMillivolts(int mv) {
        return 0;
    }
    
    private final java.lang.Boolean parseBoolean(java.util.Map<java.lang.String, java.lang.String> values, java.lang.String... keys) {
        return null;
    }
    
    private final java.lang.Boolean parseBooleanText(java.lang.String value) {
        return null;
    }
    
    private final java.lang.Integer parseFirstInt(java.lang.String value) {
        return null;
    }
    
    private final <T extends java.lang.Object>java.lang.Object withCommandLock(java.lang.String operation, long timeoutMs, kotlin.jvm.functions.Function0<? extends T> onTimeout, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> block, kotlin.coroutines.Continuation<? super T> $completion) {
        return null;
    }
    
    private final boolean isRawCollectorActive() {
        return false;
    }
    
    private final boolean isLikelyCliText(java.lang.String output) {
        return false;
    }
    
    private final void completePendingRequest(com.vesper.flipper.ble.ProtocolResponse response) {
    }
    
    private final void failPendingRequest(java.lang.String message) {
    }
    
    public final void onWriteComplete() {
    }
    
    public final void onWriteError(int status) {
    }
    
    /**
     * Send a CLI command to the Flipper.
     * This sends commands in a format the Flipper CLI understands.
     * Note: Requires Flipper firmware that supports CLI on the active transport.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendCliCommand(@org.jetbrains.annotations.NotNull
    java.lang.String command, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    public final boolean hasRpcAppCommandMapping(@org.jetbrains.annotations.NotNull
    java.lang.String command) {
        return false;
    }
    
    private final java.lang.Object sendSingleCliCommand(java.lang.String command, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.String normalizeCliCommand(java.lang.String command) {
        return null;
    }
    
    private final java.util.List<java.lang.String> buildCliCommandVariants(java.lang.String command) {
        return null;
    }
    
    private final boolean shouldRetryWithNextVariant(java.lang.String command, com.vesper.flipper.ble.ProtocolResponse response) {
        return false;
    }
    
    /**
     * Send raw CLI text directly (for simple CLI interaction)
     * This bypasses the protocol framing for direct serial passthrough
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendRawCli(@org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object probeCliAvailability(boolean force, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.CliCapabilityStatus> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object probeRpcAvailability(@org.jetbrains.annotations.NotNull
    java.lang.String detail, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.CliCapabilityStatus> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object recoverCliFromRpcSession(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.CliCapabilityStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object recoverCliFromRpcSessionLocked(kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.CliCapabilityStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object probeRawCliOutput(kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object executeRpcAppCommand(@org.jetbrains.annotations.NotNull
    java.lang.String command, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    /**
     * Send a direct GUI button/input event via RPC.
     * Mirrors official remote-control style input (UP/DOWN/LEFT/RIGHT/OK/BACK).
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendGuiInputEvent(@org.jetbrains.annotations.NotNull
    com.flipperdevices.protobuf.screen.Gui.InputKey key, @org.jetbrains.annotations.NotNull
    com.flipperdevices.protobuf.screen.Gui.InputType inputType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    /**
     * Low-latency remote input path.
     * Sends GUI input immediately without waiting for protocol mutex/acks, then
     * falls back to the strict RPC path when immediate delivery fails.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendGuiInputEventImmediate(@org.jetbrains.annotations.NotNull
    com.flipperdevices.protobuf.screen.Gui.InputKey key, @org.jetbrains.annotations.NotNull
    com.flipperdevices.protobuf.screen.Gui.InputType inputType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final void scheduleRemoteInputHealthRefresh() {
    }
    
    private final java.lang.Object trySendGuiInputViaRpcBootstrapLocked(com.vesper.flipper.ble.FlipperBleService service, com.flipperdevices.protobuf.screen.Gui.InputKey key, com.flipperdevices.protobuf.screen.Gui.InputType inputType, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object sendGuiInputEventStatusLocked(com.flipperdevices.protobuf.screen.Gui.InputKey key, com.flipperdevices.protobuf.screen.Gui.InputType inputType, long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object sendGuiInputEventFireAndForgetLocked(com.flipperdevices.protobuf.screen.Gui.InputKey key, com.flipperdevices.protobuf.screen.Gui.InputType inputType, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object sendGuiInputEventPacketImmediate(com.vesper.flipper.ble.FlipperBleService service, com.flipperdevices.protobuf.screen.Gui.InputKey key, com.flipperdevices.protobuf.screen.Gui.InputType inputType, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final boolean isRemoteFastPathReady(long nowMs) {
        return false;
    }
    
    private final boolean shouldProbeDesktopLockForRemoteInput(long nowMs) {
        return false;
    }
    
    private final java.lang.Object maybeUnlockDesktopIfNeededLocked(long lockProbeTimeoutMs, long unlockTimeoutMs, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final java.lang.Object requestDesktopLockStatusLocked(long timeoutMs, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object sendDesktopUnlockStatusLocked(long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object sendAppStartWithCandidates(java.util.List<java.lang.String> candidates, java.lang.String args, java.lang.String cacheKey, long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object sendAppLoadFileWithRetry(java.lang.String path, long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object sendAppButtonConfirmEventLocked(java.util.List<java.lang.String> buttonArgsCandidates, java.lang.String cacheKey, long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object sendAppButtonConfirmEventAttemptLocked(java.util.List<java.lang.String> buttonArgsCandidates, java.lang.String cacheKey, long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final boolean isRetryableAppCommandStatus(com.flipperdevices.protobuf.Flipper.CommandStatus status) {
        return false;
    }
    
    private final java.lang.Object sendAppButtonPressReleaseStatusLocked(java.lang.String args, long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object sendAppButtonPressStatusLocked(java.lang.String args, long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object sendAppButtonReleaseStatusLocked(long timeoutMs, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.CommandStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object requestAppLockStatusLocked(long timeoutMs, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object requestAppErrorInfoLocked(long timeoutMs, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.FlipperProtocol.AppErrorInfo> $completion) {
        return null;
    }
    
    private final java.lang.String formatAppErrorSuffix(com.vesper.flipper.ble.FlipperProtocol.AppErrorInfo errorInfo) {
        return null;
    }
    
    private final boolean isFatalAppError(com.vesper.flipper.ble.FlipperProtocol.AppErrorInfo errorInfo) {
        return false;
    }
    
    private final java.lang.String buildRpcAppStartCacheKey(java.util.List<java.lang.String> appCandidates) {
        return null;
    }
    
    private final java.lang.String buildRpcButtonCacheKey(com.vesper.flipper.ble.FlipperProtocol.RpcCommandPlan plan) {
        return null;
    }
    
    private final java.lang.String buildRpcExecutionCacheKey(com.vesper.flipper.ble.FlipperProtocol.RpcCommandPlan plan, java.lang.String appStartKey) {
        return null;
    }
    
    private final java.util.List<java.lang.String> reorderCandidatesWithCache(java.util.List<java.lang.String> candidates, java.lang.String cacheKey, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> cache) {
        return null;
    }
    
    private final com.vesper.flipper.ble.FlipperProtocol.RpcCommandPlan parseRpcCommandPlan(java.lang.String command) {
        return null;
    }
    
    private final kotlin.Pair<java.lang.String, java.util.List<java.lang.String>> extractAppOverrideAndArgs(java.util.List<java.lang.String> tokens) {
        return null;
    }
    
    private final java.util.List<java.lang.String> buildRpcAppCandidates(java.util.List<java.lang.String> baseCandidates, java.lang.String customOverride) {
        return null;
    }
    
    private final java.util.List<java.lang.String> parseCommandArguments(java.lang.String argumentTail) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendRawCliCommand(@org.jetbrains.annotations.NotNull
    java.lang.String command, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.ProtocolResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object collectRawCliResponse(java.lang.String commandText, long timeoutMs, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final java.lang.Object collectRawCliResponseAttempt(byte[] payload, long timeoutMs, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final java.lang.Object collectRawBinaryResponseAttempt(byte[] payload, long timeoutMs, kotlin.coroutines.Continuation<? super byte[]> $completion) {
        return null;
    }
    
    private final java.lang.Object collectRawBinaryTailResponse(long timeoutMs, kotlin.coroutines.Continuation<? super byte[]> $completion) {
        return null;
    }
    
    private final java.lang.Object probeRpcTransportAvailability(java.lang.String detail, kotlin.coroutines.Continuation<? super com.vesper.flipper.ble.CliCapabilityStatus> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcMainAndAwaitResponse(long timeoutMs, kotlin.jvm.functions.Function1<? super com.flipperdevices.protobuf.Flipper.Main.Builder, kotlin.Unit> build, kotlin.coroutines.Continuation<? super com.flipperdevices.protobuf.Flipper.Main> $completion) {
        return null;
    }
    
    private final java.lang.Object sendRpcMainAndCollectResponses(long timeoutMs, kotlin.jvm.functions.Function1<? super com.flipperdevices.protobuf.Flipper.Main.Builder, kotlin.Unit> build, kotlin.coroutines.Continuation<? super java.util.List<com.flipperdevices.protobuf.Flipper.Main>> $completion) {
        return null;
    }
    
    private final java.lang.Object collectRpcMainResponsesOnce(byte[] request, int commandId, long timeoutMs, kotlin.coroutines.Continuation<? super java.util.List<com.flipperdevices.protobuf.Flipper.Main>> $completion) {
        return null;
    }
    
    private final java.lang.Object tryStartRpcSession(kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object tryStopRpcSession(kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final int nextRpcProbeCommandId() {
        return 0;
    }
    
    private final int nextImmediateRpcCommandId() {
        return 0;
    }
    
    private final byte[] buildRpcMainPacket(int commandId, kotlin.jvm.functions.Function1<? super com.flipperdevices.protobuf.Flipper.Main.Builder, kotlin.Unit> build) {
        return null;
    }
    
    private final void writeVarint(java.io.ByteArrayOutputStream stream, long value) {
    }
    
    private final java.util.List<com.flipperdevices.protobuf.Flipper.Main> findRpcMainMessages(byte[] bytes, int expectedCommandId) {
        return null;
    }
    
    private final com.vesper.flipper.ble.FlipperProtocol.VarintReadResult readVarint(byte[] bytes, int startOffset) {
        return null;
    }
    
    private final boolean isLikelyNoOutputCommand(java.lang.String command) {
        return false;
    }
    
    private final com.vesper.flipper.ble.CliCapabilityStatus markCliReady(java.lang.String rawOutput) {
        return null;
    }
    
    private final com.vesper.flipper.ble.CliCapabilityStatus markRpcReady(java.lang.String detail) {
        return null;
    }
    
    private final com.vesper.flipper.ble.CliCapabilityStatus markCliUnavailable(java.lang.String reason) {
        return null;
    }
    
    private final com.vesper.flipper.ble.CliCapabilityStatus markProbeDeferred(java.lang.String reason) {
        return null;
    }
    
    private final java.lang.String extractFirmwareHint(java.lang.String output) {
        return null;
    }
    
    private final com.vesper.flipper.ble.ProtocolResponse normalizeCliResponse(java.lang.String command, com.vesper.flipper.ble.ProtocolResponse response) {
        return null;
    }
    
    private final java.lang.String summarizeResponse(com.vesper.flipper.ble.ProtocolResponse response) {
        return null;
    }
    
    private final java.lang.String extractResponseText(com.vesper.flipper.ble.ProtocolResponse response) {
        return null;
    }
    
    private final void learnFirmwareProfile(com.vesper.flipper.ble.ProtocolResponse response) {
    }
    
    private final void refreshFirmwareCompatibility() {
    }
    
    private final com.vesper.flipper.ble.FirmwareFamily resolveFirmwareFamily(java.lang.String firmwareHint) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$AppErrorInfo;", "", "code", "", "text", "", "(ILjava/lang/String;)V", "getCode", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    static final class AppErrorInfo {
        private final int code = 0;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String text = null;
        
        public AppErrorInfo(int code, @org.jetbrains.annotations.NotNull
        java.lang.String text) {
            super();
        }
        
        public final int getCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getText() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.FlipperProtocol.AppErrorInfo copy(int code, @org.jetbrains.annotations.NotNull
        java.lang.String text) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0005\n\u0002\bB\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$Companion;", "", "()V", "BATTERY_MAX_MV", "", "BATTERY_MIN_MV", "CLI_FAILURE_MARKERS", "", "", "CLI_PROBE_CACHE_MS", "", "CLI_PROBE_COMMANDS", "CLI_TEXT_PRINTABLE_RATIO_MIN", "", "CMD_CLI", "", "CMD_DELETE", "CMD_INFO", "CMD_LIST", "CMD_MKDIR", "CMD_MOVE", "CMD_READ", "CMD_STORAGE_INFO", "CMD_WRITE", "COMMAND_MUTEX_LOCK_RPC_APP_TIMEOUT_MS", "COMMAND_MUTEX_LOCK_TIMEOUT_MS", "COMMAND_TIMEOUT_MS", "COMPATIBILITY_MISS_MARKERS", "DESKTOP_LOCK_PROBE_RETRY_MS", "FATAL_RPC_APP_ERROR_MARKERS", "LEGACY_WRITE_BASE_TIMEOUT_MS", "LEGACY_WRITE_PER_KIB_TIMEOUT_MS", "LEGACY_WRITE_TIMEOUT_MS", "MAX_FRAME_SIZE", "RAW_BINARY_QUIET_PERIOD_MS", "RAW_CLI_PROBE_TIMEOUT_MS", "RAW_CLI_QUIET_PERIOD_MS", "RAW_CLI_TIMEOUT_MS", "RESP_CLI", "RESP_DATA", "RESP_ERROR", "RESP_INFO", "RESP_LIST", "RESP_OK", "RPC_APP_BUTTON_ALT_TIMEOUT_MS", "RPC_APP_BUTTON_TIMEOUT_MS", "RPC_APP_COMMAND_MAX_RETRIES", "RPC_APP_COMMAND_RETRY_DELAY_MS", "RPC_APP_COMMAND_TIMEOUT_MS", "RPC_APP_ERROR_TIMEOUT_MS", "RPC_APP_FALLBACK_GUI_TIMEOUT_MS", "RPC_APP_FAST_REPEAT_WINDOW_MS", "RPC_APP_LOAD_TIMEOUT_MS", "RPC_APP_LOCK_TIMEOUT_MS", "RPC_APP_START_ALT_TIMEOUT_MS", "RPC_APP_START_ARGUMENT", "RPC_APP_START_SETTLE_DELAY_MS", "RPC_APP_START_TIMEOUT_MS", "RPC_COMMAND_TIMEOUT_MS", "RPC_CONTINUATION_COLLECT_WINDOW_MS", "RPC_REMOTE_BOOTSTRAP_DELAY_MS", "RPC_REMOTE_BOOTSTRAP_LOCK_TIMEOUT_MS", "RPC_REMOTE_FAST_RPC_STATUS_MAX_AGE_MS", "RPC_REMOTE_IMMEDIATE_RETRY_DELAY_MS", "RPC_REMOTE_IMMEDIATE_WRITE_ATTEMPTS", "RPC_REMOTE_INPUT_ACK_TIMEOUT_MS", "RPC_REMOTE_LOCK_CHECK_CACHE_MS", "RPC_REMOTE_LOCK_TIMEOUT_MS", "RPC_REMOTE_RELEASE_TIMEOUT_MS", "RPC_REMOTE_UNLOCK_TIMEOUT_MS", "RPC_RESET_RETRY_DELAY_MS", "RPC_RETRY_COMMAND_TIMEOUT_MS", "RPC_SESSION_START_DELAY_MS", "RPC_SESSION_STOP_DELAY_MS", "RPC_SESSION_STOP_GUARD_WINDOW_MS", "RPC_STORAGE_COMMAND_TIMEOUT_MS", "RPC_STORAGE_WRITE_BASE_TIMEOUT_MS", "RPC_STORAGE_WRITE_MAX_ATTEMPTS", "RPC_STORAGE_WRITE_PER_KIB_TIMEOUT_MS", "RPC_STORAGE_WRITE_RETRY_DELAY_MS", "RPC_STORAGE_WRITE_TIMEOUT_MS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$FirmwareProfile;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "MOMENTUM", "UNLEASHED", "ROGUEMASTER", "XTREME", "app_debug"})
    static enum FirmwareProfile {
        /*public static final*/ UNKNOWN /* = new UNKNOWN() */,
        /*public static final*/ MOMENTUM /* = new MOMENTUM() */,
        /*public static final*/ UNLEASHED /* = new UNLEASHED() */,
        /*public static final*/ ROGUEMASTER /* = new ROGUEMASTER() */,
        /*public static final*/ XTREME /* = new XTREME() */;
        
        FirmwareProfile() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.vesper.flipper.ble.FlipperProtocol.FirmwareProfile> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$RawBinaryCollector;", "", "()V", "buffer", "Ljava/io/ByteArrayOutputStream;", "<set-?>", "", "lastUpdateMs", "getLastUpdateMs", "()J", "append", "", "data", "", "hasData", "", "snapshot", "app_debug"})
    static final class RawBinaryCollector {
        @org.jetbrains.annotations.NotNull
        private final java.io.ByteArrayOutputStream buffer = null;
        @kotlin.jvm.Volatile
        private volatile long lastUpdateMs;
        
        public RawBinaryCollector() {
            super();
        }
        
        public final long getLastUpdateMs() {
            return 0L;
        }
        
        public final void append(@org.jetbrains.annotations.NotNull
        byte[] data) {
        }
        
        public final boolean hasData() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final byte[] snapshot() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$RawCliCollector;", "", "()V", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "<set-?>", "", "lastUpdateMs", "getLastUpdateMs", "()J", "append", "", "data", "", "hasData", "", "snapshot", "", "app_debug"})
    static final class RawCliCollector {
        @org.jetbrains.annotations.NotNull
        private final java.lang.StringBuilder buffer = null;
        @kotlin.jvm.Volatile
        private volatile long lastUpdateMs;
        
        public RawCliCollector() {
            super();
        }
        
        public final long getLastUpdateMs() {
            return 0L;
        }
        
        public final void append(@org.jetbrains.annotations.NotNull
        byte[] data) {
        }
        
        public final boolean hasData() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String snapshot() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00c6\u0003JK\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$RpcCommandPlan;", "", "appCandidates", "", "", "appArgs", "filePath", "buttonArgsCandidates", "triggerOkPress", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getAppArgs", "()Ljava/lang/String;", "getAppCandidates", "()Ljava/util/List;", "getButtonArgsCandidates", "getFilePath", "getTriggerOkPress", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    static final class RpcCommandPlan {
        @org.jetbrains.annotations.Nullable
        private final java.util.List<java.lang.String> appCandidates = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String appArgs = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String filePath = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<java.lang.String> buttonArgsCandidates = null;
        private final boolean triggerOkPress = false;
        
        public RpcCommandPlan(@org.jetbrains.annotations.Nullable
        java.util.List<java.lang.String> appCandidates, @org.jetbrains.annotations.NotNull
        java.lang.String appArgs, @org.jetbrains.annotations.Nullable
        java.lang.String filePath, @org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> buttonArgsCandidates, boolean triggerOkPress) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<java.lang.String> getAppCandidates() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAppArgs() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getFilePath() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> getButtonArgsCandidates() {
            return null;
        }
        
        public final boolean getTriggerOkPress() {
            return false;
        }
        
        public RpcCommandPlan() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<java.lang.String> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> component4() {
            return null;
        }
        
        public final boolean component5() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.FlipperProtocol.RpcCommandPlan copy(@org.jetbrains.annotations.Nullable
        java.util.List<java.lang.String> appCandidates, @org.jetbrains.annotations.NotNull
        java.lang.String appArgs, @org.jetbrains.annotations.Nullable
        java.lang.String filePath, @org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> buttonArgsCandidates, boolean triggerOkPress) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$RpcExecutionSnapshot;", "", "executionKey", "", "completedAtMs", "", "(Ljava/lang/String;J)V", "getCompletedAtMs", "()J", "getExecutionKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class RpcExecutionSnapshot {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String executionKey = null;
        private final long completedAtMs = 0L;
        
        public RpcExecutionSnapshot(@org.jetbrains.annotations.NotNull
        java.lang.String executionKey, long completedAtMs) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getExecutionKey() {
            return null;
        }
        
        public final long getCompletedAtMs() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        public final long component2() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.FlipperProtocol.RpcExecutionSnapshot copy(@org.jetbrains.annotations.NotNull
        java.lang.String executionKey, long completedAtMs) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult;", "", "()V", "Consumed", "None", "Partial", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult$Consumed;", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult$None;", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult$Partial;", "app_debug"})
    static abstract class RpcFrameConsumeResult {
        
        private RpcFrameConsumeResult() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult$Consumed;", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult;", "bytes", "", "(I)V", "getBytes", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
        public static final class Consumed extends com.vesper.flipper.ble.FlipperProtocol.RpcFrameConsumeResult {
            private final int bytes = 0;
            
            public Consumed(int bytes) {
            }
            
            public final int getBytes() {
                return 0;
            }
            
            public final int component1() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.vesper.flipper.ble.FlipperProtocol.RpcFrameConsumeResult.Consumed copy(int bytes) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override
            @org.jetbrains.annotations.NotNull
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult$None;", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class None extends com.vesper.flipper.ble.FlipperProtocol.RpcFrameConsumeResult {
            @org.jetbrains.annotations.NotNull
            public static final com.vesper.flipper.ble.FlipperProtocol.RpcFrameConsumeResult.None INSTANCE = null;
            
            private None() {
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override
            @org.jetbrains.annotations.NotNull
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult$Partial;", "Lcom/vesper/flipper/ble/FlipperProtocol$RpcFrameConsumeResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Partial extends com.vesper.flipper.ble.FlipperProtocol.RpcFrameConsumeResult {
            @org.jetbrains.annotations.NotNull
            public static final com.vesper.flipper.ble.FlipperProtocol.RpcFrameConsumeResult.Partial INSTANCE = null;
            
            private Partial() {
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override
            @org.jetbrains.annotations.NotNull
            public java.lang.String toString() {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/vesper/flipper/ble/FlipperProtocol$VarintReadResult;", "", "value", "", "nextOffset", "", "(JI)V", "getNextOffset", "()I", "getValue", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    static final class VarintReadResult {
        private final long value = 0L;
        private final int nextOffset = 0;
        
        public VarintReadResult(long value, int nextOffset) {
            super();
        }
        
        public final long getValue() {
            return 0L;
        }
        
        public final int getNextOffset() {
            return 0;
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.ble.FlipperProtocol.VarintReadResult copy(long value, int nextOffset) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}