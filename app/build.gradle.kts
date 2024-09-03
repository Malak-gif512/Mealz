plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
//    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.mealz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mealz"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Activity KTX for by viewModels()
    implementation(libs.androidx.activity.ktx)

    // Dagger - Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Hilt ViewModel integration
    implementation(libs.androidx.hilt.navigation.fragment)
    kapt(libs.androidx.hilt.compiler.v120)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // For instrumentation tests
    androidTestImplementation(libs.hilt.android.testing)
    androidTestAnnotationProcessor(libs.hilt.android.compiler)

    // For local unit tests
    testImplementation(libs.hilt.android.testing)
    testAnnotationProcessor(libs.hilt.android.compiler)

    // Retrofit for network calls
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(libs.glide)

    implementation(libs.okhttp)

    // Example of updating Hilt dependency
//    implementation(libs.hilt.android.v245)
//    kapt(libs.hilt.compiler)
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}