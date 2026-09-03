package app.morphe.patches.aliexpress.ads

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.aliexpress.utils.Constants.COMPATIBILITY_ALIEXPRESS

internal object AdcInitFingerprint : Fingerprint(
    returnType = "V",
    parameters = listOf("Landroid/app/Application;"),
)

val removeAdsPatch = bytecodePatch(
    name = "Remove ads",
    description = "Removes sponsored products and advertisements from the AliExpress home feed and search results.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_ALIEXPRESS)

    execute {
        AdcInitFingerprint.method.apply {
            addInstructions(
                0,
                """
                invoke-static {}, Lapp/morphe/extension/aliexpress/patches/RemoveAdsPatch;->shouldShowAd()Z
                move-result v0
                if-nez v0, :cond_0
                return-void
                :cond_0
                invoke-static {p0}, Lapp/morphe/extension/aliexpress/patches/RemoveAdsPatch;->filterAds(Ljava/util/List;)Ljava/util/List;
                move-result-object p0
                return-void
                """.trimIndent(),
            )
        }
    }
}
