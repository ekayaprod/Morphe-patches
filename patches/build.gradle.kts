group = "aliexpress"

patches {
    about {
        name = "AliExpress Patches"
        description = "Morphe patches for AliExpress"
        source = "git@github.com:ekayaprod/Morphe-patches.git"
        author = "ekayaprod"
        contact = "na"
        website = "https://github.com/ekayaprod/Morphe-patches"
        license = "GNU General Public License v3.0"
    }
}

dependencies {
    implementation(libs.gson)
    implementation(libs.morphe.patches.library)
    testImplementation("junit:junit:4.13.2")
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"
        dependsOn(build)
        classpath = sourceSets["main"].runtimeClasspath
        args(rootProject.projectDir.resolve("patches-list.json").absolutePath)
        mainClass.set("app.morphe.util.PatchListGeneratorKt")
    }
    publish {
        dependsOn("generatePatchesList")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-Xcontext-parameters")
    }
}

dependencies {
    testImplementation(libs.junit)
}
