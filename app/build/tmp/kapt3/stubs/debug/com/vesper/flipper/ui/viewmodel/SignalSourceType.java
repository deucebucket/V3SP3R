package com.vesper.flipper.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.vesper.flipper.ai.OpenRouterClient;
import com.vesper.flipper.ble.BleServiceManager;
import com.vesper.flipper.ble.FlipperFileSystem;
import com.vesper.flipper.domain.model.ChimeraProject;
import com.vesper.flipper.domain.model.ChimeraSplicer;
import com.vesper.flipper.domain.model.FusionMode;
import com.vesper.flipper.domain.model.GeneType;
import com.vesper.flipper.domain.model.Mutation;
import com.vesper.flipper.domain.model.SignalGene;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/vesper/flipper/ui/viewmodel/SignalSourceType;", "", "icon", "", "color", "", "(Ljava/lang/String;ILjava/lang/String;J)V", "getColor", "()J", "getIcon", "()Ljava/lang/String;", "SUBGHZ", "INFRARED", "NFC", "RFID", "app_debug"})
public enum SignalSourceType {
    /*public static final*/ SUBGHZ /* = new SUBGHZ(null, 0L) */,
    /*public static final*/ INFRARED /* = new INFRARED(null, 0L) */,
    /*public static final*/ NFC /* = new NFC(null, 0L) */,
    /*public static final*/ RFID /* = new RFID(null, 0L) */;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String icon = null;
    private final long color = 0L;
    
    SignalSourceType(java.lang.String icon, long color) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIcon() {
        return null;
    }
    
    public final long getColor() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ui.viewmodel.SignalSourceType> getEntries() {
        return null;
    }
}