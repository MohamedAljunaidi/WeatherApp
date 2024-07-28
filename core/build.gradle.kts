import com.kaizen.buildsrc.dependencies.DependencyGroups
import com.kaizen.buildsrc.extensions.implementation
import com.kaizen.buildsrc.dependencies.Dependencies
import com.kaizen.buildsrc.extensions.kapt

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.kaizen.buildsrc.common.base-android-library")
}
android{
    namespace = "com.kaizen.core"
}

dependencies {
    implementation(DependencyGroups.navigationDependencies)
    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.junitTestImplementationDependencies)
    implementation(DependencyGroups.junitAndroidTestImplementation)
    implementation(Dependencies.glide)
    kapt(Dependencies.glideCompiler)
    implementation(DependencyGroups.hiltDependencies)
    kapt(DependencyGroups.hiltKaptDependencies)
    implementation(DependencyGroups.sizeDependencies)}