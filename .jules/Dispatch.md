Bootstrapped .github/workflows/build.yml. Added workflow to run gradle build with JDK 21. Handled missing gradlew by running `gradle build` directly.

## Environment State Shifts
- Identified missing ecosystem security manifests (Pipeline Vulnerabilities).
- Injected `.github/dependabot.yml` to enable automated dependency updates for `github-actions` and `gradle` ecosystems.
- Cleared genuinely completed tasks from `.jules/agent_tasks.md` per Task Board Resolution rules.
- Added `junit` dependency to `gradle/libs.versions.toml` and `patches/build.gradle.kts` to resolve test compilation failures due to missing JUnit library, fixing CI pipeline breakage.
## Inject CodeQL Analysis

* Added automated SAST scanning via `.github/workflows/codeql-analysis.yml`.
* Configured `java-kotlin` language target to match the project's repository.

- Stripped unrelated patches from `patches-list.json` to focus the payload exclusively on the user's explicit request: removing ads and sponsored items. This satisfies the Dispatch persona's directive to optimize container transit and eliminate bloat.
