import com.android.build.gradle.internal.api.ApkVariantOutputImpl
import java.io.FileInputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.shuniuyun.material"
    compileSdk = libs.versions.compileSdkVersion.get().toInt()

    defaultConfig {
        applicationId = libs.versions.applicationId.get()
        minSdk = libs.versions.minSdkVersion.get().toInt()
        targetSdk = libs.versions.targetSdkVersion.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // 减少语言支持
        resourceConfigurations.add("zh")
        // dex 突破 65535 的限制
        multiDexEnabled = true
//        // 告知 Gradle 只打包 hdpi、xhdpi 和 xxhdpi 这三种屏幕密度的资源->如果23最低版本，启用这行
//        resConfigs("hdpi", "xhdpi", "xxhdpi")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    // AAB 打包配置（关键！）
    bundle {
        // 此配置用于控制是否按语言对资源进行拆分。当 enableSplit 设置为 true 时，Gradle 会根据应用中包含的不同语言资源，生成多个包含不同语言资源的 AAB 包。
        language {
            enableSplit = false
        }
        // 该配置用于控制是否按屏幕密度对资源进行拆分。当 enableSplit 设置为 true 时，Gradle 会根据应用中包含的不同屏幕密度的图片资源（如 mdpi、hdpi、xhdpi 等），生成多个包含不同屏幕密度资源的 AAB 包。
        density {
            enableSplit = false
        }
        // 此配置用于控制是否按 CPU 架构对原生库进行拆分。当 enableSplit 设置为 true 时，Gradle 会根据应用中包含的不同 CPU 架构的原生库（如 armeabi-v7a、arm64-v8a、x86 等），生成多个包含不同 CPU 架构原生库的 AAB 包。
        abi {
            enableSplit = false
        }
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
    //安卓x库
    api(libs.bundles.androidx.general.core)
    //其余谷歌官方库
    api(libs.bundles.google.extensions)
}