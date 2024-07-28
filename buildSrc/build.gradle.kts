plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

object PluginVersion {
    const val gradle_version = "8.5.0"
    const val kotlin_version = "1.9.10"
    const val hilt_version = "2.50"
    const val navigation_version = "2.7.6"
    const val google_services_version = "4.4.0"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginVersion.gradle_version}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersion.kotlin_version}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${PluginVersion.navigation_version}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${PluginVersion.hilt_version}")
    implementation("com.google.gms:google-services:${PluginVersion.google_services_version}")
}