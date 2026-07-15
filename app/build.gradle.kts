import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "com.shuniuyun.material"

    compileSdk {
        version = release(libs.versions.compileSdkVersion.get().toInt())
    }

    defaultConfig {
        applicationId = libs.versions.applicationId.get()
        minSdk = libs.versions.minSdkVersion.get().toInt()
        targetSdk = libs.versions.targetSdkVersion.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
        testInstrumentationRunner = libs.versions.testInstrumentationRunner.get()
        // 减少语言支持
        resourceConfigurations.add("zh")
        // dex 突破 65535 的限制
        multiDexEnabled = true
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.android.testing)
    // 安卓x库
    api(libs.bundles.androidx.general.core)
    // 谷歌官方库
    api(libs.bundles.google.extensions)
}