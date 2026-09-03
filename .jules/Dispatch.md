Bootstrapped .github/workflows/build.yml. Added workflow to run gradle build with JDK 21. Handled missing gradlew by running `gradle build` directly.

## Environment State Shifts
- Identified missing ecosystem security manifests (Pipeline Vulnerabilities).
- Injected `.github/dependabot.yml` to enable automated dependency updates for `github-actions` and `gradle` ecosystems.
- Cleared genuinely completed tasks from `.jules/agent_tasks.md` per Task Board Resolution rules.
