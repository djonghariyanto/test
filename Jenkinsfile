#!/usr/bin/env groovy
pipeline {
    agent {
	docker {
	    image 'maven:3.9.6-eclipse-temurin-17-alpine'
	    args '-v /root/.m2:/root.m2'
	}
    }

    stages {
	stage("build") {
	    steps {
		sh 'mvn -B -DskipTests clean package'
	    }
	}
    }
}
