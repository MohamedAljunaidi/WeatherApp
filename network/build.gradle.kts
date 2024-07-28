import com.kaizen.buildsrc.common.AppConfig
import com.kaizen.buildsrc.dependencies.DependencyGroups
import com.kaizen.buildsrc.extensions.implementation
import com.kaizen.buildsrc.extensions.kapt

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.kaizen.buildsrc.common.base-android-library")
}

android{
    namespace = "com.kaizen.network"
}
dependencies {
    implementation(project(AppConfig.ModulePathsConstant.CORE))

    implementation(DependencyGroups.coroutinesDependencies)
    implementation(DependencyGroups.retrofitDependencies)
    implementation(DependencyGroups.hiltDependencies)
    kapt(DependencyGroups.hiltKaptDependencies)

    implementation(DependencyGroups.androidDependencies)
    implementation(DependencyGroups.junitTestImplementationDependencies)
    implementation(DependencyGroups.junitAndroidTestImplementation)
}