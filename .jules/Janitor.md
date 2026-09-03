### Hazard Log
* 🚨 Unlinked Artifact Identified: `extensions/aliexpress/src/main/java/app/morphe/extension/aliexpress/patches/RemoveSponsoredItemsPatch.java` contains unlinked artifact `filterSearchResults` resulting from missing smali injection hooks in `HideSponsoredItemsPatch.kt`. (Awaiting Paramedic intervention to restore linkage before pruning.)
* 🚨 Unlinked Artifact Identified: `extensions/aliexpress/src/main/java/app/morphe/extension/aliexpress/patches/RemoveAdsPatch.java` contains unlinked artifacts `filterAds` and `shouldShowAd` resulting from missing smali injection hooks in `RemoveAdsPatch.kt`. (Awaiting Paramedic intervention to restore linkage before pruning.)

### Resolved Entropy
* `.gitignore` -> `.DS_Store`, `__pycache__/`, and `fix.diff` explicitly barred.
* `.gitattributes` -> `* text=auto` baseline generated to stop CRLF leaks.
* `patches-list.json` -> Injected missing POSIX-compliant EOF newline.

### Persistent Entropy
None.
