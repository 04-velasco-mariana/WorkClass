plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.workclass"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.workclass"
        minSdk = 26
        targetSdk = 35
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
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.runtime.android)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.adaptive.android)
    implementation(libs.androidx.media3.common.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.compose.material:material:1.6.0")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.31.1-alpha")
    //coil AsyncImage
    //implementation("io.coil-kt:coil-compose:2.4.0")
    implementation(libs.coil.compose)
    // retrofit
   // implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    //implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation(libs.retrofit)
    //implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation(libs.okhttp)
    //implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation(libs.kotlinx.serialization.json)
    //implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(libs.converter.gson)
    //
    //implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation (libs.androidx.lifecycle.runtime.ktx.v262)
    //
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version") // opcional pero recomendado
    ksp("androidx.room:room-compiler:$room_version")
    //
    implementation("androidx.compose.material:material-icons-extended")


// WorkManager
// REVISA QUE NO LOS TENGAS REPETIDOS, USA CTRL + F
   // implementation("androidx.work:work-runtime-ktx:2.10.1")
    implementation ("androidx.work:work-runtime:2.10.1")

//Implementacion de biometric
    implementation ("androidx.biometric:biometric:1.2.0-alpha05")
    implementation("androidx.core:core-ktx:1.12.0")


}