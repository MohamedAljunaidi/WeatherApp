package com.kaizen.buildsrc.buildtype

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.kaizen.buildsrc.common.AppConfig.BuildTypeConstant
import com.kaizen.buildsrc.extensions.extractProperties
import org.gradle.api.Project

/**
 * The `BuildTypeApp` class for (application plugin).
 * Here, we set up our build types, such as debug, staging, and release,
 * as well as any configurations, such as buildConfigField and manifestPlaceholders.
 */

object BuildTypeApp {

    fun initAppBuildType(baseAppModuleExtension: BaseAppModuleExtension, project: Project) {

        baseAppModuleExtension.apply {
            buildTypes {
                all {
                    val properties= project.extractProperties(this)
                    ConfigApp.initConfigData(buildType = this, properties = properties)
                }
                maybeCreate(BuildTypeConstant.RELEASE)
                getByName(BuildTypeConstant.RELEASE) {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }
}