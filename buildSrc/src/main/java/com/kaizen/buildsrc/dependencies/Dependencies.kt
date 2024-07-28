package com.kaizen.buildsrc.dependencies

/**
 *  The Dependencies class includes every third party that we used in Gradle.
 */
object Dependencies {

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependencyVersions.coroutines_version}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersions.coroutines_version}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${DependencyVersions.kotlin_version}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${DependencyVersions.constraint_layout_version}"
    const val recyclerView =
        "androidx.recyclerview:recyclerview:${DependencyVersions.recycler_view_version}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${DependencyVersions.hilt_version}"
    const val hiltAndroidCompilerKapt =
        "com.google.dagger:hilt-android-compiler:${DependencyVersions.hilt_version}"
    const val hiltCompilerKapt =
        "com.google.dagger:hilt-compiler:${DependencyVersions.hilt_version}"
    const val hiltWorker =
        "androidx.hilt:hilt-work:${DependencyVersions.hilt_common_version}"


    const val retrofit = "com.squareup.retrofit2:retrofit:${DependencyVersions.retrofit_version}"
    const val gson = "com.google.code.gson:gson:${DependencyVersions.gson_version}"
    const val converterGson =
        "com.squareup.retrofit2:converter-gson:${DependencyVersions.retrofit_version}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${DependencyVersions.navigation_version}"
    const val navigation =
        "androidx.navigation:navigation-ui-ktx:${DependencyVersions.navigation_version}"

    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependencyVersions.viewModel_version}"
    const val core = "androidx.core:core-ktx:${DependencyVersions.core_version}"
    const val appcompat = "androidx.appcompat:appcompat:${DependencyVersions.appcompat_version}"
    const val material =
        "com.google.android.material:material:${DependencyVersions.material_version}"

    const val junitTestImplementation =
        "junit:junit:${DependencyVersions.junitTestImplementation_version}"
    const val junitExtAndroidTestImplementation =
        "androidx.test.ext:junit:${DependencyVersions.junitExtAndroidTestImplementation_version}"
    const val espressoAndroidTestImplementation =
        "androidx.test.espresso:espresso-core:${DependencyVersions.espressoAndroidTestImplementation_version}"

    const val fragment = "androidx.fragment:fragment-ktx:${DependencyVersions.fragment_version}"

    const val glide = "com.github.bumptech.glide:glide:${DependencyVersions.glide_version}"
    const val glideCompiler =
        "com.github.bumptech.glide:compiler:${DependencyVersions.glide_version}"


    const val splashComponent =
        "androidx.core:core-splashscreen:${DependencyVersions.splash_component_version}"


    const val preferencesDataStore =
        "androidx.datastore:datastore-preferences:${DependencyVersions.preferences_datastore_version}"
    const val recyclerview =
        "androidx.recyclerview:recyclerview:${DependencyVersions.recyclerview_version}"

    const val mockitoCore = "org.mockito:mockito-core:${DependencyVersions.mockito_core_version}"
    const val mockitoInline =
        "org.mockito:mockito-inline:${DependencyVersions.mockito_inline_version}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${
        DependencyVersions.coroutines_test_version
    }"
    const val turbine = "app.cash.turbine:turbine:${DependencyVersions.turbine_version}"

    const val swipeRefreshLayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${DependencyVersions.swipe_refresh_version}"

    const val roomPaging = "androidx.room:room-paging:${DependencyVersions.room_version}"
    const val room = "androidx.room:room-ktx:${DependencyVersions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${DependencyVersions.room_version}"
    const val ssp = "com.intuit.ssp:ssp-android:${DependencyVersions.ssp_version}"
    const val sdp = "com.intuit.sdp:sdp-android:${DependencyVersions.sdp_version}"
    const val preference="androidx.preference:preference-ktx:${DependencyVersions.preference}"
    const val serviceLocation = "com.google.android.gms:play-services-location:${DependencyVersions.services_location_version}"
    const val map = "com.google.android.gms:play-services-maps:${DependencyVersions.map_version}"
    const val hiltCommon = "androidx.hilt:hilt-common:${DependencyVersions.hilt_common_version}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${DependencyVersions.hilt_common_version}"
    const val workRuntime = "androidx.work:work-runtime-ktx:${DependencyVersions.work_runtime_ktx}"
    const val roomRuntime = "androidx.room:room-runtime:${DependencyVersions.room_version}"


}