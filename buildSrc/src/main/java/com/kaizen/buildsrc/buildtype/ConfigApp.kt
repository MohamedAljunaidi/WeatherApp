package com.kaizen.buildsrc.buildtype

import com.android.build.api.dsl.BuildType
import com.kaizen.buildsrc.common.AppConfig
import com.kaizen.buildsrc.extensions.buildConfigStringField
import java.util.*

/**
 * The `ConfigApp` class to set up our configurations,
 * such as buildConfigField and manifestPlaceholders.
 */

object ConfigApp {

    fun initConfigData(buildType: BuildType, properties: Properties) {

        buildType.apply {

            //base URL
            buildConfigStringField(
                AppConfig.BuildConfigField.BASE_URL_KEY,
                properties.getProperty(AppConfig.BuildConfigField.BASE_URL_VALUE)
            )
            //api KEY
            buildConfigStringField(
                AppConfig.BuildConfigField.API_KEY,
                properties.getProperty(AppConfig.BuildConfigField.API_KEY_VALUE)
            )

        }
    }
}