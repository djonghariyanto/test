#!/usr/bin/env groovy
pipeline {
    agent any
    environment {
	BABON = 'babon gila'
    }
    stages {
	stage("test") {
    agent {
	docker {
	    image 'maven:3.9.6-eclipse-temurin-17-alpine'
	    args '-v $HOME/.m2:/root/.m2'
	}
    }
	    environment {
		DUMB = 'dumb gila'
	    }

	    steps {
		sh 'mvn clean package'
	    }
	}

	stage('deploying') {
	    steps {
		withCredentials([sshUserPrivateKey(credentialsId: 'vm-private-key', keyFileVariable: 'keyfile', usernameVariable: 'USERNAME')]) {
		    sh 'scp -v -o StrictHostKeyChecking=no -i $keyfile target/*.jar $USERNAME@3.104.117.169:fullnessof.com/'
		    }
	    }
	}
    }
}
