plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
//    id("kotlin-kapt")
    id("kotlin-kapt")
}

android {
    namespace = "com.roger.test"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.roger.test"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments = ["room.schemaLocation": "$projectDir/schemas"]
//            }
//        }
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

//    signingConfigs {
//        release {
//            storeFile file('../armedpolice.jks')
//            storePassword 'txkj123456'
//            keyAlias 'arm'
//            keyPassword 'txkj123456'
//        }
//        debug {
//            storeFile file('../armedpolice.jks')
//            storePassword 'txkj123456'
//            keyAlias 'arm'
//            keyPassword 'txkj123456'
//        }
//    }
//
//    buildTypes {
//        release {
//            zipAlignEnabled true
//            debuggable false
//            shrinkResources false //是否去除无效的资源文件
//            minifyEnabled true //是否混淆
//            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
//            signingConfig signingConfigs.release
//                    lintOptions {
//                        checkReleaseBuilds false
//                        abortOnError false
//                    }
//        }
//        debug {
//            debuggable true
//            zipAlignEnabled true
//            debuggable true
//            minifyEnabled true //是否混淆
//            shrinkResources false //是否去除无效的资源文件
//            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
//            signingConfig signingConfigs.debug
//                    lintOptions {
//                        checkReleaseBuilds false
//                        abortOnError false
//                    }
//        }
//    }

    buildFeatures {
        //noinspection DataBindingWithoutKapt
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(mapOf("path" to ":common")))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.google.dagger:hilt-android:2.51.1")


    implementation("androidx.appcompat:appcompat:${Version.appCompatVersion}")
    implementation("androidx.fragment:fragment-ktx:${Version.activity}")
    implementation("androidx.activity:activity-ktx:${Version.fragment}")


    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycleVersion}")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    implementation("io.github.cymchad:BaseRecyclerViewAdapterHelper4:4.1.4")

    implementation("com.blankj:utilcodex:1.31.1")


    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    implementation("com.google.code.gson:gson:2.10.1") //Gson

    implementation("androidx.emoji2:emoji2:1.5.0") //Gson

}