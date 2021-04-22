plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 30

  defaultConfig {
    applicationId = "com.fernando.ramirez.pokedex"
    minSdk = 21
    targetSdk = 30
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    debug {
      buildConfigField("String", "API", "\"https://pokeapi.co/\"")
    }

    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

      buildConfigField("String", "API", "\"https://pokeapi.co/\"")
    }
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
    kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    kotlinCompilerVersion = "1.4.32"
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.3.2")
  implementation("androidx.appcompat:appcompat:1.2.0")
  implementation("com.google.android.material:material:1.3.0")
  implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
  implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
  implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
  implementation("androidx.activity:activity-compose:1.3.0-alpha07")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04")

  // Dagger Hilt
  implementation("com.google.dagger:hilt-android:${rootProject.extra["hilt_version"]}")
  kapt("com.google.dagger:hilt-compiler:${rootProject.extra["hilt_version"]}")

  // Room db
  implementation("androidx.room:room-runtime:${rootProject.extra["room_version"]}")
  kapt("androidx.room:room-compiler:${rootProject.extra["room_version"]}")
  implementation("androidx.room:room-ktx:${rootProject.extra["room_version"]}")

  // OkHttp
  implementation("com.squareup.okhttp3:okhttp:4.9.0")
  implementation("com.squareup.okhttp3:logging-interceptor:4.7.2")

  // Retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")

  testImplementation("junit:junit:4.13.2")

  androidTestImplementation("androidx.test.ext:junit:1.1.2")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
}
