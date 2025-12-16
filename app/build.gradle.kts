plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    // Add the KSP plugin for Room if you plan to use it instead of KAPT for Room
    // id("com.google.devtools.ksp") version "1.9.22-1.0.18" // Check for the latest KSP version
}

android {
    namespace = "com.example.jmwendwa"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.retrofit_and_api"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Hilt/Dagger
    implementation("com.google.dagger:hilt-android:2.51.1")
    implementation(libs.androidx.room.common.jvm)
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    kapt("androidx.hilt:hilt-compiler:1.2.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("javax.inject:javax.inject:1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Room DB
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1") // Kotlin Extensions and Coroutines support for Room
    kapt("androidx.room:room-compiler:2.6.1") // Annotation processor

    // If you decide to use KSP instead of KAPT for Room, you'd replace 'kapt' with 'ksp'
    // ksp("androidx.room:room-compiler:2.6.1")

    //Moshi
    // Moshi
    implementation("com.squareup.moshi:moshi:1.15.0") // Use the latest version
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0") // Use the latest version if you're using Kotlin
    // Retrofit Moshi Converter
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0") // Use the same Retrofit version



    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}