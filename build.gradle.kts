plugins {
    kotlin("multiplatform") version "1.9.22"
    kotlin("plugin.serialization") version "1.8.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

}

val exposedVersion: String by project


kotlin {
    js(IR) { // or: LEGACY, BOTH
        var moduleName = "NaNaInfo"


        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }

        }
        binaries.executable() // not applicable to BOTH, see details below
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
               // implementation(npm("jquery","3.7"))
                implementation(npm("react-share", "4.4.1"))
                implementation(npm("react-player", "2.12.0"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:16.8.0")
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.11.0")
                //React, React DOM + Wrappers (chapter 3)
                implementation(enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.430"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")

                //Kotlin React Emotion (CSS) (chapter 3)
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")

                //Video Player (chapter 7)
                implementation(npm("react-player", "2.12.0"))

                //Share Buttons (chapter 7)
                implementation(npm("react-share", "4.4.1"))


                //Coroutines & serialization (chapter 8)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
                implementation(npm("navigo", "8.11.1"))
               // implementation(npm("@types/jquery","3.7.1", generateExternals = true))
                implementation(npm("jquery","3.7.1"))

                /*
                implementation(npm("fs-extra","11.2.0"))//
                implementation(npm("tls","0.0.1"))
                implementation(npm("buffer","6.0.3"))
                implementation(npm("url","0.11.3"))
                implementation(npm("stream","0.0.2"))
                implementation(npm("timers","0.1.1"))
                implementation(npm("crypto-browserify","3.12.0"))//
                implementation(npm("net","1.0.2"))
                implementation(npm("util","0.12.5"))
                implementation(npm("mysql","2.18.1"))

                implementation(npm("path","0.12.7"))
                implementation(npm("assert","2.1.0"))
                implementation(npm("node-constants","0.0.2"))

                 */
              //  implementation(npm("express","4.19.2"))
              //  implementation(npm("ws","8.17.0"))
            }

        }
    }

}