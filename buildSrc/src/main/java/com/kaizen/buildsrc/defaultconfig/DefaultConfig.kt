package com.kaizen.buildsrc.defaultconfig

import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.kaizen.buildsrc.common.AppConfig
import org.gradle.api.JavaVersion

/**
 *
 * The DefaultConfig for the app and library module are handled by the "DefaultConfig" object.
 */
object DefaultConfig {

    fun initAppDefaultConfig(baseAppModuleExtension: BaseAppModuleExtension) {
        baseAppModuleExtension.apply {
            compileSdk = AppConfig.AppConfigConstant.compileSdk
            buildToolsVersion = AppConfig.AppConfigConstant.buildToolsVersion
            defaultConfig {
                applicationId = "com.kaizen.weatherapp"
                minSdk = AppConfig.AppConfigConstant.minSdk
                targetSdk = AppConfig.AppConfigConstant.targetSdk
                versionName = AppConfig.AppConfigConstant.versionName
                testInstrumentationRunner = AppConfig.AppConfigConstant.testInstrumentationRunner
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }

            buildFeatures {
                buildConfig = true
                dataBinding = true
            }

        }
    }

    fun initLibraryDefaultConfig(libraryExtension: LibraryExtension) {
        libraryExtension.apply {
            compileSdk = AppConfig.AppConfigConstant.compileSdk
            defaultConfig {
                minSdk = AppConfig.AppConfigConstant.minSdk
                lint.targetSdk = AppConfig.AppConfigConstant.targetSdk
                testInstrumentationRunner = AppConfig.AppConfigConstant.testInstrumentationRunner
                consumerProguardFiles("consumer-rules.pro")
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }

            buildFeatures {
                dataBinding = true
                buildConfig = true
            }

        }
    }


}