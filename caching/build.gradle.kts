import com.kaizen.buildsrc.dependencies.Dependencies
import com.kaizen.buildsrc.dependencies.DependencyGroups
import com.kaizen.buildsrc.extensions.implementation
import com.kaizen.buildsrc.common.AppConfig
import com.kaizen.buildsrc.extensions.kapt

plugins {
    kotlin("kapt")
    id("com.kaizen.buildsrc.common.base-android-library")
}

android{
    namespace = "com.kaizen.caching"
}
dependencies {
    implementation(project(AppConfig.ModulePathsConstant.CORE))

    implementation(DependencyGroups.hiltDependencies)
    kapt(DependencyGroups.hiltKaptDependencies)

    implementation(Dependencies.preferencesDataStore)
    kapt(Dependencies.roomCompiler)
    implementation(DependencyGroups.roomDependencies)
    implementation(Dependencies.gson)

    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.junitTestImplementationDependencies)
    implementation(DependencyGroups.junitAndroidTestImplementation)
}