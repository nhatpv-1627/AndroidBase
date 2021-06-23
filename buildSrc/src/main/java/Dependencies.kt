import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    //std lib
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val googleMaterial =
        "com.google.android.material:material:${Versions.googleMaterial}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    //test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJUnit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    // Glide
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glideRuntime = "com.github.bumptech.glide:glide:${Versions.glide}"

    // Koin
    private const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    private const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    private const val koinViewModel = "io.insert-koin:koin-android-viewmodel:${Versions.koin}"
    private const val koinExt = "io.insert-koin:koin-androidx-ext:${Versions.koin}"
    private const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // Coroutine
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"

    const val securityCrypto = "androidx.security:security-crypto:${Versions.security}"

    // Retrofit
    private const val retrofitRuntime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private const val okHttpLogging =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLogging}"
    private const val retrofitScalars =
        "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"

    // Lifecycle
    private const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    private const val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    private const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"

    // Navigation
    private const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    private const val navigationDynamic =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(googleMaterial)
    }

    val koinLibs = arrayListOf<String>().apply {
        add(koinCore)
        add(koinAndroid)
        add(koinViewModel)
        add(koinExt)
        add(koinTest)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val lifecycleLibs = arrayListOf<String>().apply {
        add(lifecycleViewModelKtx)
        add(lifecycleLivedata)
        add(lifecycleRuntime)
    }

    val navigation = arrayListOf<String>().apply {
        add(navigationFragment)
        add(navigationUi)
        add(navigationDynamic)
    }

    val retrofit = arrayListOf<String>().apply {
        add(retrofitRuntime)
        add(retrofitGson)
        add(okHttpLogging)
        add(retrofitScalars)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}


fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}


fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}
