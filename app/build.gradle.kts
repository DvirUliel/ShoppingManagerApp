plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.shoppingmanagerapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.shoppingmanagerapp"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.google.firebase:firebase-auth:21.1.0")  // Firebase Authentication
    implementation("com.google.firebase:firebase-database:20.0.3")  // Firebase Realtime Database
    implementation("androidx.appcompat:appcompat:1.6.1") // Support Library for backward compatibility
}
apply(plugin = "com.google.gms.google-services")  // Apply the plugin to enable Firebase services
