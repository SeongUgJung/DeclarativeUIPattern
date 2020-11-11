plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(30)
    buildToolsVersion(Base.buildToolVersion)


    defaultConfig {
        applicationId("com.declarative.ui.pattern")
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.version
        kotlinCompilerVersion = Kotlin.version
    }
}

dependencies {

    implementation(Kotlin.stdLib)
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(Google.material)

    composeComponent()

    implementation(project(":view-component"))

}