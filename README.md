# ⚡ AliExpress Patches

[![build: passing](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/ekayaprod/Morphe-patches/actions)

A suite of surgical Morphe patches designed to strip out telemetry, nuke
sponsored ads, and reclaim the core AliExpress experience.

## The Arsenal

| Patch | Description | Default |
| --- | --- | --- |
| Bypass signature check | Bypasses SecurityGuard integrity checks. | Yes |
| Disable analytics | Blocks analytics and tracking sent to servers. | Yes |
| Disable forced updates | Disables the forced update popup. | Yes |
| Disable promotions | Disables promotional push notifications. | Yes |
| Disable splash screen | Skips the splash screen on app launch. | No |
| Enable image saving | Enables saving product images to gallery. | No |
| Remove ads | Removes sponsored products from the home feed. | Yes |
| Remove affiliate tracking | Removes tracking from shared links. | Yes |
| Remove coupons popup | Removes the coupon and promotion dialogs. | Yes |
| Remove sponsored items | Filters out sponsored items from search. | Yes |

## Quick Start

### Morphe Manager (Android)

Add this repository as a native patch source via deep link:

```url
https://morphe.software/add-source?github=ekayaprod/Morphe-patches
```

1. Select the **AliExpress** app in Morphe Manager.
2. Provide the raw `APKM` file (v8.162.8).
3. Patch and install.

### Morphe CLI (Desktop)

```sh
java -jar cli.jar patch --patches patches-1.0.7.mpp input.apkm
```

## Infrastructure & Build

This project uses the `app.morphe.patches` Gradle plugin (v1.3.2). There is
no bundled wrapper script, so you must invoke the `gradle` binary directly.

Authentication is strictly required to resolve dependencies from the
`maven.pkg.github.com/MorpheApp/registry` private repository.

```sh
# Inject GitHub credentials for the registry
export GITHUB_ACTOR="your_username"
export GITHUB_TOKEN="your_token"

# Execute the local build
gradle build
```

> **Warning:** In ephemeral CI environments, always append `--no-daemon` to
> the build command to prevent memory exhaustion and state corruption.

## License

GNU General Public License v3.0
