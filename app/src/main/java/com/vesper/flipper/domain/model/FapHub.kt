package com.vesper.flipper.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * FapHub - Flipper Application Hub
 *
 * Integration with the Flipper app catalog for browsing,
 * downloading, and installing .fap applications.
 */

@Serializable
data class FapApp(
    val id: String,
    val name: String,
    val description: String,
    val category: FapCategory,
    val author: String,
    val version: String,
    val downloadUrl: String,
    val iconUrl: String? = null,
    val screenshots: List<String> = emptyList(),
    val size: Long = 0,
    val downloads: Int = 0,
    val rating: Float = 0f,
    val updatedAt: Long = 0,
    val sdkVersion: String = "0.0",
    val targetFirmware: String = "any",
    val isInstalled: Boolean = false,
    val installedVersion: String? = null
)

@Serializable
enum class FapCategory(val displayName: String, val icon: String) {
    @SerialName("games") GAMES("Games", "🎮"),
    @SerialName("tools") TOOLS("Tools", "🔧"),
    @SerialName("nfc") NFC("NFC", "💳"),
    @SerialName("subghz") SUBGHZ("Sub-GHz", "📡"),
    @SerialName("infrared") INFRARED("Infrared", "🔴"),
    @SerialName("gpio") GPIO("GPIO", "⚡"),
    @SerialName("bluetooth") BLUETOOTH("Bluetooth", "🔵"),
    @SerialName("usb") USB("USB", "🔌"),
    @SerialName("media") MEDIA("Media", "🎵"),
    @SerialName("misc") MISC("Misc", "📦")
}

/**
 * FapHub catalog response
 */
@Serializable
data class FapCatalog(
    val apps: List<FapApp>,
    val totalCount: Int,
    val page: Int,
    val pageSize: Int,
    val lastUpdated: Long
)

/**
 * App installation status
 */
sealed class InstallStatus {
    object Idle : InstallStatus()
    data class Downloading(val progress: Float) : InstallStatus()
    object Installing : InstallStatus()
    object Success : InstallStatus()
    data class Error(val message: String) : InstallStatus()
}

/**
 * FapHub API endpoints and built-in app catalog
 */
object FapHubCatalog {

    // Popular/Featured apps - curated list
    val featuredApps = listOf(
        FapApp(
            id = "picopass",
            name = "PicoPass Reader",
            description = "Read and emulate iClass/PicoPass cards",
            category = FapCategory.NFC,
            author = "Flipper Team",
            version = "1.5",
            downloadUrl = "https://lab.flipper.net/apps/picopass",
            downloads = 50000,
            rating = 4.8f
        ),
        FapApp(
            id = "wifi_marauder",
            name = "WiFi Marauder",
            description = "ESP32 Marauder companion app for WiFi attacks",
            category = FapCategory.BLUETOOTH,
            author = "0xchocolate",
            version = "0.6.3",
            downloadUrl = "https://lab.flipper.net/apps/wifi_marauder",
            downloads = 120000,
            rating = 4.9f
        ),
        FapApp(
            id = "ble_spam",
            name = "BLE Spam",
            description = "Bluetooth Low Energy advertisement spam",
            category = FapCategory.BLUETOOTH,
            author = "Willy-JL",
            version = "2.1",
            downloadUrl = "https://lab.flipper.net/apps/ble_spam",
            downloads = 85000,
            rating = 4.7f
        ),
        FapApp(
            id = "mousejacker",
            name = "MouseJacker",
            description = "Exploit wireless mice and keyboards",
            category = FapCategory.SUBGHZ,
            author = "Flipper Team",
            version = "1.1",
            downloadUrl = "https://lab.flipper.net/apps/mousejacker",
            downloads = 45000,
            rating = 4.6f
        ),
        FapApp(
            id = "sentry_safe",
            name = "Sentry Safe Cracker",
            description = "Brute force Sentry Safe electronic locks",
            category = FapCategory.GPIO,
            author = "H4ckd4ddy",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/sentry_safe",
            downloads = 30000,
            rating = 4.5f
        ),
        FapApp(
            id = "evil_portal",
            name = "Evil Portal",
            description = "Captive portal for credential capture",
            category = FapCategory.BLUETOOTH,
            author = "bigbrodude6119",
            version = "0.3",
            downloadUrl = "https://lab.flipper.net/apps/evil_portal",
            downloads = 75000,
            rating = 4.7f
        ),
        FapApp(
            id = "flappy_bird",
            name = "Flappy Bird",
            description = "Classic Flappy Bird game",
            category = FapCategory.GAMES,
            author = "xMasterX",
            version = "1.2",
            downloadUrl = "https://lab.flipper.net/apps/flappy_bird",
            downloads = 100000,
            rating = 4.8f
        ),
        FapApp(
            id = "doom",
            name = "DOOM",
            description = "The classic DOOM game ported to Flipper",
            category = FapCategory.GAMES,
            author = "xMasterX",
            version = "0.9",
            downloadUrl = "https://lab.flipper.net/apps/doom",
            downloads = 95000,
            rating = 4.9f
        ),
        FapApp(
            id = "tetris",
            name = "Tetris",
            description = "Classic Tetris game",
            category = FapCategory.GAMES,
            author = "Flipper Team",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/tetris",
            downloads = 80000,
            rating = 4.7f
        ),
        FapApp(
            id = "snake",
            name = "Snake",
            description = "Classic Snake game",
            category = FapCategory.GAMES,
            author = "Flipper Team",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/snake",
            downloads = 70000,
            rating = 4.6f
        ),
        FapApp(
            id = "nfc_magic",
            name = "NFC Magic",
            description = "Write to magic/gen1a NFC cards",
            category = FapCategory.NFC,
            author = "Flipper Team",
            version = "1.3",
            downloadUrl = "https://lab.flipper.net/apps/nfc_magic",
            downloads = 65000,
            rating = 4.8f
        ),
        FapApp(
            id = "seader",
            name = "Seader",
            description = "Read HID iClass SE cards with SAM",
            category = FapCategory.NFC,
            author = "bettse",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/seader",
            downloads = 25000,
            rating = 4.5f
        ),
        FapApp(
            id = "barcode_gen",
            name = "Barcode Generator",
            description = "Generate and display barcodes",
            category = FapCategory.TOOLS,
            author = "Flipper Team",
            version = "1.1",
            downloadUrl = "https://lab.flipper.net/apps/barcode_gen",
            downloads = 40000,
            rating = 4.4f
        ),
        FapApp(
            id = "qrcode",
            name = "QR Code",
            description = "Generate and display QR codes",
            category = FapCategory.TOOLS,
            author = "Willy-JL",
            version = "1.5",
            downloadUrl = "https://lab.flipper.net/apps/qrcode",
            downloads = 55000,
            rating = 4.6f
        ),
        FapApp(
            id = "pocsag_pager",
            name = "POCSAG Pager",
            description = "Send POCSAG pager messages",
            category = FapCategory.SUBGHZ,
            author = "xMasterX",
            version = "0.8",
            downloadUrl = "https://lab.flipper.net/apps/pocsag_pager",
            downloads = 20000,
            rating = 4.3f
        ),
        FapApp(
            id = "subghz_bruteforcer",
            name = "Sub-GHz Bruteforcer",
            description = "Brute force Sub-GHz protocols",
            category = FapCategory.SUBGHZ,
            author = "xMasterX",
            version = "1.3",
            downloadUrl = "https://lab.flipper.net/apps/subghz_bruteforcer",
            downloads = 60000,
            rating = 4.7f
        ),
        FapApp(
            id = "gps",
            name = "GPS",
            description = "GPS NMEA parser with serial module",
            category = FapCategory.GPIO,
            author = "Flipper Team",
            version = "1.2",
            downloadUrl = "https://lab.flipper.net/apps/gps",
            downloads = 35000,
            rating = 4.5f
        ),
        FapApp(
            id = "signal_generator",
            name = "Signal Generator",
            description = "Generate test signals on GPIO",
            category = FapCategory.GPIO,
            author = "Flipper Team",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/signal_generator",
            downloads = 15000,
            rating = 4.2f
        ),
        FapApp(
            id = "music_player",
            name = "Music Player",
            description = "Play RTTTL music files",
            category = FapCategory.MEDIA,
            author = "Flipper Team",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/music_player",
            downloads = 50000,
            rating = 4.4f
        ),
        FapApp(
            id = "video_player",
            name = "Video Player",
            description = "Play video files on the display",
            category = FapCategory.MEDIA,
            author = "LTVA1",
            version = "0.5",
            downloadUrl = "https://lab.flipper.net/apps/video_player",
            downloads = 30000,
            rating = 4.3f
        ),
        FapApp(
            id = "ir_remote",
            name = "Universal IR Remote",
            description = "Comprehensive IR remote database",
            category = FapCategory.INFRARED,
            author = "Flipper Team",
            version = "2.0",
            downloadUrl = "https://lab.flipper.net/apps/ir_remote",
            downloads = 90000,
            rating = 4.8f
        ),
        FapApp(
            id = "ir_scope",
            name = "IR Scope",
            description = "Visualize and decode IR signals",
            category = FapCategory.INFRARED,
            author = "xMasterX",
            version = "1.1",
            downloadUrl = "https://lab.flipper.net/apps/ir_scope",
            downloads = 25000,
            rating = 4.4f
        ),
        FapApp(
            id = "usb_hid",
            name = "USB HID",
            description = "Advanced USB HID controller",
            category = FapCategory.USB,
            author = "Flipper Team",
            version = "1.5",
            downloadUrl = "https://lab.flipper.net/apps/usb_hid",
            downloads = 40000,
            rating = 4.5f
        ),
        FapApp(
            id = "mass_storage",
            name = "Mass Storage",
            description = "Expose SD card as USB mass storage",
            category = FapCategory.USB,
            author = "Flipper Team",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/mass_storage",
            downloads = 55000,
            rating = 4.6f
        ),
        FapApp(
            id = "spectrum_analyzer",
            name = "Spectrum Analyzer",
            description = "Real-time RF spectrum visualization",
            category = FapCategory.SUBGHZ,
            author = "jolcese",
            version = "1.2",
            downloadUrl = "https://lab.flipper.net/apps/spectrum_analyzer",
            downloads = 45000,
            rating = 4.7f
        ),
        FapApp(
            id = "weather_station",
            name = "Weather Station",
            description = "Decode weather station sensors",
            category = FapCategory.SUBGHZ,
            author = "Flipper Team",
            version = "1.1",
            downloadUrl = "https://lab.flipper.net/apps/weather_station",
            downloads = 35000,
            rating = 4.4f
        ),
        FapApp(
            id = "airtag_scanner",
            name = "AirTag Scanner",
            description = "Detect nearby Apple AirTags",
            category = FapCategory.BLUETOOTH,
            author = "Willy-JL",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/airtag_scanner",
            downloads = 60000,
            rating = 4.6f
        ),
        FapApp(
            id = "bt_serial",
            name = "Bluetooth Serial",
            description = "Bluetooth serial terminal",
            category = FapCategory.BLUETOOTH,
            author = "Flipper Team",
            version = "1.2",
            downloadUrl = "https://lab.flipper.net/apps/bt_serial",
            downloads = 30000,
            rating = 4.3f
        ),
        FapApp(
            id = "clock",
            name = "Clock",
            description = "Analog and digital clock faces",
            category = FapCategory.MISC,
            author = "Flipper Team",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/clock",
            downloads = 25000,
            rating = 4.2f
        ),
        FapApp(
            id = "dice",
            name = "Dice Roller",
            description = "Roll various dice types",
            category = FapCategory.MISC,
            author = "Flipper Team",
            version = "1.0",
            downloadUrl = "https://lab.flipper.net/apps/dice",
            downloads = 20000,
            rating = 4.1f
        )
    )

    val allApps: List<FapApp>
        get() = featuredApps.sortedByDescending { it.downloads }

    fun getAppsByCategory(category: FapCategory): List<FapApp> {
        return featuredApps.filter { it.category == category }
    }

    fun searchApps(query: String): List<FapApp> {
        val lowerQuery = query.lowercase()
        return featuredApps.filter {
            it.name.lowercase().contains(lowerQuery) ||
            it.description.lowercase().contains(lowerQuery) ||
            it.author.lowercase().contains(lowerQuery)
        }
    }
}
