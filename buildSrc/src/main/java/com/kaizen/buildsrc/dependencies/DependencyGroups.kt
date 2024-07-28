package com.kaizen.buildsrc.dependencies

/**
 *  The DependencyGroups class was created
 *  to combine all common dependencies into a
 *  single object..
 */
object DependencyGroups {

    val coroutinesDependencies = arrayListOf<String>().apply {
        add(Dependencies.coroutinesCore)
        add(Dependencies.coroutinesAndroid)
        add(Dependencies.kotlin)
    }

    val constraintDependencies = arrayListOf<String>().apply {
        add(Dependencies.constraintLayout)
    }

    val hiltDependencies = arrayListOf<String>().apply {
        add(Dependencies.hiltAndroid)
    }

    val hiltKaptDependencies = arrayListOf<String>().apply {
        add(Dependencies.hiltAndroidCompilerKapt)
    }

    val retrofitDependencies = arrayListOf<String>().apply {
        add(Dependencies.retrofit)
        add(Dependencies.gson)
        add(Dependencies.converterGson)
    }

    val navigationDependencies = arrayListOf<String>().apply {
        add(Dependencies.navigationFragment)
        add(Dependencies.navigation)
    }

    val androidDependencies = arrayListOf<String>().apply {
        add(Dependencies.viewModel)
        add(Dependencies.core)
        add(Dependencies.appcompat)
        add(Dependencies.material)
    }

    val junitTestImplementationDependencies = arrayListOf<String>().apply {
        add(Dependencies.junitTestImplementation)
    }

    val junitAndroidTestImplementation = arrayListOf<String>().apply {
        add(Dependencies.junitExtAndroidTestImplementation)
        add(Dependencies.espressoAndroidTestImplementation)
    }

    val mockitoTestImplementation = arrayListOf<String>().apply {
        add(Dependencies.mockitoCore)
        add(Dependencies.mockitoInline)
        add(Dependencies.turbine)
        add(Dependencies.coroutinesTest)
    }

    val roomDependencies = arrayListOf<String>().apply {
        add(Dependencies.room)
        add(Dependencies.roomPaging)
    }

    val sizeDependencies = arrayListOf<String>().apply {
        add(Dependencies.ssp)
        add(Dependencies.sdp)
    }


}