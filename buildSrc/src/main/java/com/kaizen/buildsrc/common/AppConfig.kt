package com.kaizen.buildsrc.common

/**
 *  The `AppConfig` object held all of the constants that we utilized in our Gradle project.
 */

object AppConfig {

    object AppConfigConstant {
        const val compileSdk = 34
        const val minSdk = 27
        const val targetSdk = 34
        const val versionName = "1"
        const val buildToolsVersion = "34.0.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val JVM_TARGET = "11"
    }

    object BuildTypeConstant {
        const val RELEASE = "release"
    }
    object BuildConfigField {

        const val BASE_URL_KEY = "BASE_URL"
        const val BASE_URL_VALUE = "base_url"

        const val API_KEY = "API_KEY"
        const val API_KEY_VALUE = "api_key"


    }

    object ModulePathsConstant {
        const val CORE = ":core"
        const val CACHING = ":caching"
        const val NETWORK = ":network"
    }

}