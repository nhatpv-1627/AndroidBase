plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "com.vannhat.androidbase"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables.useSupportLibrary = true
        consumerProguardFiles(
            file("proguard-rules.pro")
        )
        manifestPlaceholders["applicationName"] = "@string/app_name"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions("default")
    // Change app name and scheme
    productFlavors {
        create("develop") {
            applicationIdSuffix = ".dev"
            manifestPlaceholders["applicationName"] = "@string/app_name_dev"
            manifestPlaceholders["scheme"] = "vannhat.dev.vn"
        }

        create("staging") {
            applicationIdSuffix = ".staging"
            manifestPlaceholders["applicationName"] = "@string/app_name_stg"
            manifestPlaceholders["scheme"] = "vannhat.stg.vn"
        }

        create("production") {
            manifestPlaceholders["applicationName"] = "@string/app_name"
            manifestPlaceholders["scheme"] = "vannhat.vn"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    buildFeatures.dataBinding = true

}

dependencies {
    implementation(Dependencies.appLibraries)
    androidTestImplementation(Dependencies.androidTestLibraries)
    testImplementation(Dependencies.testLibraries)

    implementation(Dependencies.koinLibs)

    implementation(Dependencies.glideRuntime)
    kapt(Dependencies.glideCompiler)

    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)

    implementation(Dependencies.coroutineCore)
    implementation(Dependencies.coroutineAndroid)
    testImplementation(Dependencies.coroutineTest)

    implementation(Dependencies.retrofit)

    implementation(Dependencies.lifecycleLibs)

    implementation(Dependencies.navigation)

    implementation(Dependencies.securityCrypto)
}
