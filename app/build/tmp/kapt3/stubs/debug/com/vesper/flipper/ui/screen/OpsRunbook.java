package com.vesper.flipper.ui.screen;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.vesper.flipper.ble.CliCapabilityStatus;
import com.vesper.flipper.ble.CommandPipelineAutotuneStatus;
import com.vesper.flipper.ble.ConnectionCheckLevel;
import com.vesper.flipper.ble.ConnectionDiagnosticsReport;
import com.vesper.flipper.ble.ConnectionState;
import com.vesper.flipper.ble.FirmwareCompatibilityProfile;
import com.vesper.flipper.domain.model.FlipperRemoteButton;
import com.vesper.flipper.ui.viewmodel.DeviceViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/ui/screen/OpsRunbook;", "", "(Ljava/lang/String;I)V", "LINK_HEALTH_SWEEP", "INPUT_SMOKE_TEST", "RECOVER_AND_SCAN", "app_debug"})
enum OpsRunbook {
    /*public static final*/ LINK_HEALTH_SWEEP /* = new LINK_HEALTH_SWEEP() */,
    /*public static final*/ INPUT_SMOKE_TEST /* = new INPUT_SMOKE_TEST() */,
    /*public static final*/ RECOVER_AND_SCAN /* = new RECOVER_AND_SCAN() */;
    
    OpsRunbook() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.ui.screen.OpsRunbook> getEntries() {
        return null;
    }
}