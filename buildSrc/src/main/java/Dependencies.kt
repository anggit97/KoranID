/**
 * Created by Anggit Prayogo on 16/07/19.
 */

object ApplicationId {
    const val id = "com.bluparse.koranid"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val buildToolsVersion = "28.0.0"
    const val targetSdkVersion = 28
    const val minSdkVersion = 17
    const val renderTargetApi = 28
}

object Version {
    const val kotlin = "1.3.11"

    /**
     *Top Level Version
     */
    const val androidGradlePlugin = "3.3.1"
    const val gooleService = "4.2.0"
    const val fabric = "1.29.0"
    const val kotlinGradlePlugin = "1.3.11"

    /**
     * Android Support Version
     */
    const val support = "1.0.0-beta01"
    const val constraintLayout = "1.1.3"

    /**
     * Livecycle Version
     */
    const val lifecycle = "2.1.0-alpha03"

    /**
     * Google Libs Version
     */
    const val googleMaps = "16.0.0"
    const val googlePlaces = "16.0.0"
    const val googleAuth = "16.0.1"

    /**
     * Jetpack
     */
    const val navigationComponent = "2.1.0-rc01"

    /**
     * Firebase
     */
    const val firebaseCrashlytics = "2.9.8"
    const val firebaseCore = "16.0.6"
    const val firebaseMessaging = "17.3.4"

    /**
     * Retrofit Network version
     */
    const val retrofit2 = "2.3.0"
    const val gson = "2.8.2"
    const val okhttp = "3.12.1"
    const val okhttpLogging = "3.8.1"
    const val rxjavaAdapter = "1.0.0"

    /**
     * RX
     */
    const val rxjava2 = "2.1.9"
    const val rxandroid = "2.1.0"

    /**
     * Dagger 2
     */
    const val dagger2 = "2.22"

    /**
     * Facebook
     */
    const val facebookShimmer = "0.4.0"

    /**
     * AirBnb
     */
    const val lottie = "2.7.0"

    /**
     * chrisjenx
     */
    const val calligraphy = "2.3.0"

    /**
     * Image Rendering
     */
    const val glide = "4.9.0"

    /**
     * Karumi
     */
    const val dexter = "4.2.0"

    /**
     * Multidex
     */
    const val multidex = "2.0.1"

    /**
     * Anko
     */
    const val anko = "0.10.8"

    /**
     * Easyvalidation
     */
    const val easyvalidationCore = "1.0.1"

    /**
     * UIComponent
     */
    const val zigzagVersion = "1.0.6"

    /**
     * Image Picker
     */
    const val paparazzoVersion = "0.6.0-2.x"

    /**
     * Image Compressor
     */
    const val compressorVersion = "2.1.0"

    /**
     * Button
     */
    const val fancyButton = "1.8.4"

    /**
     * Test
     */
    const val junitVersion = "4.12"
    const val mockitoCore = "2.25.0"
    const val androidxTest = "1.3.0-alpha01"
    const val androidxEspressoCore = "3.1.0"
    const val mockitoInline = "2.19.0"
}

object Deps {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
}

object AndroidSupport {
    const val appCompat = "androidx.appcompat:appcompat:${Version.support}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Version.support}"
    const val cardview = "androidx.cardview:cardview:${Version.support}"
    const val design = "com.google.android.material:material:${Version.support}"
    const val v4 = "androidx.legacy:legacy-support-v4:${Version.support}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val multidex = "com.android.support:multidex:${Version.multidex}"
}

object Retrofit {
    val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit2}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit2}"
    val gson = "com.google.code.gson:gson:${Version.gson}"
    val rxAdapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Version.rxjavaAdapter}"
    val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okhttpLogging}"
}

object Reactivex {
    val android = "io.reactivex.rxjava2:rxandroid:${Version.rxandroid}"
    val java = "io.reactivex.rxjava2:rxjava:${Version.rxjava2}"
}

object GooleService {
    val places = "com.google.android.gms:play-services-places:${Version.googlePlaces}"
    val maps = "com.google.android.gms:play-services-maps:${Version.googleMaps}"
    val auth = "com.google.android.gms:play-services-auth:${Version.googleAuth}"
}

object Dagger {
    val dagger = "com.google.dagger:dagger:${Version.dagger2}"
    val android = "com.google.dagger:dagger-android:${Version.dagger2}"
    val androidSupport = "com.google.dagger:dagger-android-support:${Version.dagger2}"
    val compiler = "com.google.dagger:dagger-compiler:${Version.dagger2}"
    val processor = "com.google.dagger:dagger-android-processor:${Version.dagger2}"
}

object Lifecycle{
    val extentions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
}

object Anko {
    val anko = "org.jetbrains.anko:anko:${Version.anko}"
    val common = "org.jetbrains.anko:anko-commons:${Version.anko}"
    val design = "org.jetbrains.anko:anko-design:${Version.anko}"
}

object Firebase{
    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Version.firebaseCrashlytics}"
    val core = "com.google.firebase:firebase-core:${Version.firebaseCore}"
    val messaging = "com.google.firebase:firebase-messaging:${Version.firebaseMessaging}"
}

object LoadingIndicator{
    const val shimmer = "com.facebook.shimmer:shimmer:${Version.facebookShimmer}"
}

object AnimationImage{
    val lottie = "com.airbnb.android:lottie:${Version.lottie}"
}

object Font{
    val calligraphy = "uk.co.chrisjenx:calligraphy:${Version.calligraphy}"
}

object Karumi{
    val dexter = "com.karumi:dexter:${Version.dexter}"
}

object Multidex{
    val multidex = "androidx.multidex:multidex:${Version.multidex}"
}

object Easyvalidation{
    val core = "com.wajahatkarim3.easyvalidation:easyvalidation-core:${Version.easyvalidationCore}"
}

object ImagePicker{
    val paparazzo = "com.github.miguelbcr:RxPaparazzo:${Version.paparazzoVersion}"
}

object ImageCompressor{
    val zelory = "id.zelory:compressor:${Version.compressorVersion}"
}

object Button{
    val fancyButton = "com.github.medyo:fancybuttons:${Version.fancyButton}"
}

object ImageRenderer{
    val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    val glideProccessor = "com.github.bumptech.glide:compiler:${Version.glide}"
}

object Jetpack{
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigationComponent}"
    val navigationUI = "androidx.navigation:navigation-ui-ktx:${Version.navigationComponent}"
}

object Testing{
    val junit = "junit:junit:${Version.junitVersion}"
    val mockitoCore = "org.mockito:mockito-core:${Version.mockitoCore}"
    val rules = "androidx.test:rules:${Version.androidxTest}"
    val runner = "androidx.test:runner:${Version.androidxTest}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Version.androidxEspressoCore}"
    val mockitoInline = "org.mockito:mockito-inline:${Version.mockitoInline}"
}