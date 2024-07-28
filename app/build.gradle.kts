import com.kaizen.buildsrc.common.BaseGradle
import com.kaizen.buildsrc.common.AppConfig
import com.kaizen.buildsrc.dependencies.DependencyGroups
import com.kaizen.buildsrc.dependencies.Dependencies
import com.kaizen.buildsrc.extensions.implementation
import com.kaizen.buildsrc.extensions.kapt

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.kaizen.weatherapp"
    BaseGradle.appGradle(this, project = project)
    kotlinOptions {
        jvmTarget = AppConfig.AppConfigConstant.JVM_TARGET
    }
}

dependencies {
    implementation(project(AppConfig.ModulePathsConstant.CORE))
    implementation(project(AppConfig.ModulePathsConstant.CACHING))
    implementation(project(AppConfig.ModulePathsConstant.NETWORK))
    implementation(DependencyGroups.coroutinesDependencies)
    implementation(DependencyGroups.retrofitDependencies)
    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.constraintDependencies)
    implementation(DependencyGroups.sizeDependencies)
    implementation(Dependencies.serviceLocation)
    implementation(Dependencies.map)
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompilerKapt)
    implementation(Dependencies.hiltWorker)
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.roomRuntime)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.room)
    implementation(Dependencies.workRuntime)
    implementation(Dependencies.preference)
    implementation(Dependencies.splashComponent)
    implementation(DependencyGroups.navigationDependencies)
    implementation(DependencyGroups.junitTestImplementationDependencies)
    implementation(DependencyGroups.junitAndroidTestImplementation)
}