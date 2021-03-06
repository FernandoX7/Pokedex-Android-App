// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  val compose_version by extra("1.0.0-beta04")
  val hilt_version by extra("2.33-beta")
  val room_version by extra("2.3.0")

  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.0.0-alpha14")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    classpath("com.google.dagger:hilt-android-gradle-plugin:${rootProject.extra["hilt_version"]}")
    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts files
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
