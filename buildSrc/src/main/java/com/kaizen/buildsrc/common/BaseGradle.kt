package com.kaizen.buildsrc.common

import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.kaizen.buildsrc.buildtype.BuildTypeApp
import com.kaizen.buildsrc.buildtype.BuildTypeLibrary
import com.kaizen.buildsrc.defaultconfig.DefaultConfig
import org.gradle.api.Project

/**
 *
 * All configurations for the app and library module are handled by the "BaseGradle" object.
 */
object BaseGradle {

    fun appGradle(baseAppModuleExtension: BaseAppModuleExtension, project: Project) {
        baseAppModuleExtension.apply {

            DefaultConfig.initAppDefaultConfig(baseAppModuleExtension = this)

            BuildTypeApp.initAppBuildType(baseAppModuleExtension = this, project = project)
        }
    }

    fun libraryGradle(libraryExtension: LibraryExtension, project: Project) {
        libraryExtension.apply {

            DefaultConfig.initLibraryDefaultConfig(libraryExtension = this)

            BuildTypeLibrary.initLibraryBuildType(libraryExtension = this, project = project)

        }
    }
}