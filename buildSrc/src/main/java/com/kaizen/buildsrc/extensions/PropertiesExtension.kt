package com.kaizen.buildsrc.extensions

import com.android.build.api.dsl.BuildType
import org.gradle.api.Project
import java.io.FileInputStream
import java.util.*

fun Project.extractProperties(buildType: BuildType): Properties {
    val project=this
    buildType.apply {
        val typeName = name.lowercase(Locale.ROOT)
        val propertiesFile =
            project.rootProject.file("properties/${typeName}.properties")
        val properties = Properties()
        properties.load(FileInputStream(propertiesFile))
        return properties
    }

}


