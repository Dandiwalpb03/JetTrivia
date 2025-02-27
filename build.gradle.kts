// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    // KSP
    id("com.google.devtools.ksp") version "1.6.20-1.0.4" apply true
    // Hilt
    id ("com.google.dagger.hilt.android") version "2.48" apply false
    //Dokka
    id("org.jetbrains.dokka") version "1.9.0" apply true

}