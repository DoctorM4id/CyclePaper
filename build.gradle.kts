plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
    alias(libs.plugins.paperweight.userdev)
    alias(libs.plugins.shadow)
    alias(libs.plugins.run.paper)
    alias(libs.plugins.resource.factory.paper)
}

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle(libs.versions.paper.api.get())
    implementation(libs.kotlin.stdlib)
}

paperPluginYaml {
    main = "dev.doctorm4id.cycle.Cycle"
    bootstrapper = "dev.doctorm4id.cycle.CycleBootstrap"
    loader = "dev.doctorm4id.cycle.CycleLoader"
    apiVersion = "26.3"
}

kotlin {
    jvmToolchain(25)
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    runServer {
        minecraftVersion(libs.versions.minecraft.get())
        jvmArgs("-Xms2G", "-Xmx2G", "-Dcom.mojang.eula.agree=true")
    }
}
