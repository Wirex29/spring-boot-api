plugins {
    java
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.graalvm.buildtools.native") version "0.9.20"
}

group = "com.nonpaidintern"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    // Implementation
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.jkratz.springmediatr:spring-mediatr:1.1-RELEASE")
//    implementation("io.jkratz.springmediatr:spring-mediatr:1.1-RELEASE")

    // Compile Only
    compileOnly("org.projectlombok:lombok")

    // Development Only
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Runtime Only
    runtimeOnly("org.postgresql:postgresql")

    // Annotation Processor
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")

    // Test Implementation
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
