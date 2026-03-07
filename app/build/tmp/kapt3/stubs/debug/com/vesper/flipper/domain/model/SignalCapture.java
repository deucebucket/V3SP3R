package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/**
 * Unified signal capture model for all Flipper protocols.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0005\u0019\u001a\u001b\u001c\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalCapture;", "", "()V", "isFavorite", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "path", "getPath", "timestamp", "", "getTimestamp", "()J", "type", "Lcom/vesper/flipper/domain/model/SignalType;", "getType", "()Lcom/vesper/flipper/domain/model/SignalType;", "IButton", "Infrared", "Nfc", "Rfid", "SubGhz", "Lcom/vesper/flipper/domain/model/SignalCapture$IButton;", "Lcom/vesper/flipper/domain/model/SignalCapture$Infrared;", "Lcom/vesper/flipper/domain/model/SignalCapture$Nfc;", "Lcom/vesper/flipper/domain/model/SignalCapture$Rfid;", "Lcom/vesper/flipper/domain/model/SignalCapture$SubGhz;", "app_debug"})
public abstract class SignalCapture {
    
    private SignalCapture() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getName();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getPath();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.vesper.flipper.domain.model.SignalType getType();
    
    public abstract long getTimestamp();
    
    public abstract boolean isFavorite();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalCapture$IButton;", "Lcom/vesper/flipper/domain/model/SignalCapture;", "name", "", "path", "timestamp", "", "isFavorite", "", "protocol", "keyData", "(Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getKeyData", "()Ljava/lang/String;", "getName", "getPath", "getProtocol", "getTimestamp", "()J", "type", "Lcom/vesper/flipper/domain/model/SignalType;", "getType", "()Lcom/vesper/flipper/domain/model/SignalType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class IButton extends com.vesper.flipper.domain.model.SignalCapture {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String path = null;
        private final long timestamp = 0L;
        private final boolean isFavorite = false;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String protocol = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String keyData = null;
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.model.SignalType type = com.vesper.flipper.domain.model.SignalType.IBUTTON;
        
        public IButton(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, @org.jetbrains.annotations.NotNull
        java.lang.String protocol, @org.jetbrains.annotations.NotNull
        java.lang.String keyData) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getName() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getPath() {
            return null;
        }
        
        @java.lang.Override
        public long getTimestamp() {
            return 0L;
        }
        
        @java.lang.Override
        public boolean isFavorite() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getProtocol() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getKeyData() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.vesper.flipper.domain.model.SignalType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.SignalCapture.IButton copy(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, @org.jetbrains.annotations.NotNull
        java.lang.String protocol, @org.jetbrains.annotations.NotNull
        java.lang.String keyData) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u00c6\u0003Ja\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u00c6\u0001J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010*H\u00d6\u0003J\t\u0010+\u001a\u00020\u000eH\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006-"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalCapture$Infrared;", "Lcom/vesper/flipper/domain/model/SignalCapture;", "name", "", "path", "timestamp", "", "isFavorite", "", "protocol", "address", "command", "rawData", "", "", "(Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAddress", "()Ljava/lang/String;", "getCommand", "()Z", "getName", "getPath", "getProtocol", "getRawData", "()Ljava/util/List;", "getTimestamp", "()J", "type", "Lcom/vesper/flipper/domain/model/SignalType;", "getType", "()Lcom/vesper/flipper/domain/model/SignalType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "app_debug"})
    public static final class Infrared extends com.vesper.flipper.domain.model.SignalCapture {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String path = null;
        private final long timestamp = 0L;
        private final boolean isFavorite = false;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String protocol = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String address = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String command = null;
        @org.jetbrains.annotations.Nullable
        private final java.util.List<java.lang.Integer> rawData = null;
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.model.SignalType type = com.vesper.flipper.domain.model.SignalType.INFRARED;
        
        public Infrared(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, @org.jetbrains.annotations.NotNull
        java.lang.String protocol, @org.jetbrains.annotations.NotNull
        java.lang.String address, @org.jetbrains.annotations.NotNull
        java.lang.String command, @org.jetbrains.annotations.Nullable
        java.util.List<java.lang.Integer> rawData) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getName() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getPath() {
            return null;
        }
        
        @java.lang.Override
        public long getTimestamp() {
            return 0L;
        }
        
        @java.lang.Override
        public boolean isFavorite() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getProtocol() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCommand() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<java.lang.Integer> getRawData() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.vesper.flipper.domain.model.SignalType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<java.lang.Integer> component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.SignalCapture.Infrared copy(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, @org.jetbrains.annotations.NotNull
        java.lang.String protocol, @org.jetbrains.annotations.NotNull
        java.lang.String address, @org.jetbrains.annotations.NotNull
        java.lang.String command, @org.jetbrains.annotations.Nullable
        java.util.List<java.lang.Integer> rawData) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u00c6\u0003Jo\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u00c6\u0001J\u0013\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012\u00a8\u00061"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalCapture$Nfc;", "Lcom/vesper/flipper/domain/model/SignalCapture;", "name", "", "path", "timestamp", "", "isFavorite", "", "deviceType", "uid", "atqa", "sak", "dataBlocks", "", "Lcom/vesper/flipper/domain/model/NfcBlock;", "(Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAtqa", "()Ljava/lang/String;", "getDataBlocks", "()Ljava/util/List;", "getDeviceType", "()Z", "getName", "getPath", "getSak", "getTimestamp", "()J", "type", "Lcom/vesper/flipper/domain/model/SignalType;", "getType", "()Lcom/vesper/flipper/domain/model/SignalType;", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Nfc extends com.vesper.flipper.domain.model.SignalCapture {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String path = null;
        private final long timestamp = 0L;
        private final boolean isFavorite = false;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String deviceType = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String uid = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String atqa = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String sak = null;
        @org.jetbrains.annotations.Nullable
        private final java.util.List<com.vesper.flipper.domain.model.NfcBlock> dataBlocks = null;
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.model.SignalType type = com.vesper.flipper.domain.model.SignalType.NFC;
        
        public Nfc(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, @org.jetbrains.annotations.NotNull
        java.lang.String deviceType, @org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.Nullable
        java.lang.String atqa, @org.jetbrains.annotations.Nullable
        java.lang.String sak, @org.jetbrains.annotations.Nullable
        java.util.List<com.vesper.flipper.domain.model.NfcBlock> dataBlocks) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getName() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getPath() {
            return null;
        }
        
        @java.lang.Override
        public long getTimestamp() {
            return 0L;
        }
        
        @java.lang.Override
        public boolean isFavorite() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDeviceType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUid() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getAtqa() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getSak() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<com.vesper.flipper.domain.model.NfcBlock> getDataBlocks() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.vesper.flipper.domain.model.SignalType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<com.vesper.flipper.domain.model.NfcBlock> component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.SignalCapture.Nfc copy(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, @org.jetbrains.annotations.NotNull
        java.lang.String deviceType, @org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.Nullable
        java.lang.String atqa, @org.jetbrains.annotations.Nullable
        java.lang.String sak, @org.jetbrains.annotations.Nullable
        java.util.List<com.vesper.flipper.domain.model.NfcBlock> dataBlocks) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalCapture$Rfid;", "Lcom/vesper/flipper/domain/model/SignalCapture;", "name", "", "path", "timestamp", "", "isFavorite", "", "protocol", "keyData", "(Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getKeyData", "()Ljava/lang/String;", "getName", "getPath", "getProtocol", "getTimestamp", "()J", "type", "Lcom/vesper/flipper/domain/model/SignalType;", "getType", "()Lcom/vesper/flipper/domain/model/SignalType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Rfid extends com.vesper.flipper.domain.model.SignalCapture {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String path = null;
        private final long timestamp = 0L;
        private final boolean isFavorite = false;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String protocol = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String keyData = null;
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.model.SignalType type = com.vesper.flipper.domain.model.SignalType.RFID;
        
        public Rfid(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, @org.jetbrains.annotations.NotNull
        java.lang.String protocol, @org.jetbrains.annotations.NotNull
        java.lang.String keyData) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getName() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getPath() {
            return null;
        }
        
        @java.lang.Override
        public long getTimestamp() {
            return 0L;
        }
        
        @java.lang.Override
        public boolean isFavorite() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getProtocol() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getKeyData() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.vesper.flipper.domain.model.SignalType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.SignalCapture.Rfid copy(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, @org.jetbrains.annotations.NotNull
        java.lang.String protocol, @org.jetbrains.annotations.NotNull
        java.lang.String keyData) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\bH\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fH\u00c6\u0003J~\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u000103H\u00d6\u0003J\t\u00104\u001a\u00020\rH\u00d6\u0001J\t\u00105\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\"X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u00066"}, d2 = {"Lcom/vesper/flipper/domain/model/SignalCapture$SubGhz;", "Lcom/vesper/flipper/domain/model/SignalCapture;", "name", "", "path", "timestamp", "", "isFavorite", "", "frequency", "protocol", "preset", "bitLength", "", "rawData", "", "keyData", "(Ljava/lang/String;Ljava/lang/String;JZJLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V", "getBitLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFrequency", "()J", "()Z", "getKeyData", "()Ljava/lang/String;", "getName", "getPath", "getPreset", "getProtocol", "getRawData", "()Ljava/util/List;", "getTimestamp", "type", "Lcom/vesper/flipper/domain/model/SignalType;", "getType", "()Lcom/vesper/flipper/domain/model/SignalType;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JZJLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)Lcom/vesper/flipper/domain/model/SignalCapture$SubGhz;", "equals", "other", "", "hashCode", "toString", "app_debug"})
    public static final class SubGhz extends com.vesper.flipper.domain.model.SignalCapture {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String path = null;
        private final long timestamp = 0L;
        private final boolean isFavorite = false;
        private final long frequency = 0L;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String protocol = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String preset = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.Integer bitLength = null;
        @org.jetbrains.annotations.Nullable
        private final java.util.List<java.lang.Integer> rawData = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String keyData = null;
        @org.jetbrains.annotations.NotNull
        private final com.vesper.flipper.domain.model.SignalType type = com.vesper.flipper.domain.model.SignalType.SUBGHZ;
        
        public SubGhz(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, long frequency, @org.jetbrains.annotations.NotNull
        java.lang.String protocol, @org.jetbrains.annotations.NotNull
        java.lang.String preset, @org.jetbrains.annotations.Nullable
        java.lang.Integer bitLength, @org.jetbrains.annotations.Nullable
        java.util.List<java.lang.Integer> rawData, @org.jetbrains.annotations.Nullable
        java.lang.String keyData) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getName() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String getPath() {
            return null;
        }
        
        @java.lang.Override
        public long getTimestamp() {
            return 0L;
        }
        
        @java.lang.Override
        public boolean isFavorite() {
            return false;
        }
        
        public final long getFrequency() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getProtocol() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getPreset() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Integer getBitLength() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<java.lang.Integer> getRawData() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getKeyData() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.vesper.flipper.domain.model.SignalType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final boolean component4() {
            return false;
        }
        
        public final long component5() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Integer component8() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<java.lang.Integer> component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vesper.flipper.domain.model.SignalCapture.SubGhz copy(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String path, long timestamp, boolean isFavorite, long frequency, @org.jetbrains.annotations.NotNull
        java.lang.String protocol, @org.jetbrains.annotations.NotNull
        java.lang.String preset, @org.jetbrains.annotations.Nullable
        java.lang.Integer bitLength, @org.jetbrains.annotations.Nullable
        java.util.List<java.lang.Integer> rawData, @org.jetbrains.annotations.Nullable
        java.lang.String keyData) {
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