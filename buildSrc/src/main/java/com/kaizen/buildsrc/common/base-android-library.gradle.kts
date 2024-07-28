package com.kaizen.buildsrc.common

import com.kaizen.buildsrc.common.AppConfig

/**
 *  The `base-android-library` gradle held all of the common config between library modules.
 */

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}


android {
    BaseGradle.libraryGradle(this, project = project)

    kotlinOptions {
        jvmTarget = AppConfig.AppConfigConstant.JVM_TARGET
    }

}
