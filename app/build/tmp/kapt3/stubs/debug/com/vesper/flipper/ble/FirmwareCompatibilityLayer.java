package com.vesper.flipper.ble;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00a8\u0006\f"}, d2 = {"Lcom/vesper/flipper/ble/FirmwareCompatibilityLayer;", "", "()V", "assessCliCommand", "Lcom/vesper/flipper/ble/FirmwareCommandCompatibility;", "profile", "Lcom/vesper/flipper/ble/FirmwareCompatibilityProfile;", "command", "", "hasRpcMapping", "", "prefersRpcBridge", "app_debug"})
public final class FirmwareCompatibilityLayer {
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.ble.FirmwareCompatibilityLayer INSTANCE = null;
    
    private FirmwareCompatibilityLayer() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vesper.flipper.ble.FirmwareCommandCompatibility assessCliCommand(@org.jetbrains.annotations.NotNull
    com.vesper.flipper.ble.FirmwareCompatibilityProfile profile, @org.jetbrains.annotations.NotNull
    java.lang.String command, boolean hasRpcMapping) {
        return null;
    }
    
    private final boolean prefersRpcBridge(java.lang.String command) {
        return false;
    }
}