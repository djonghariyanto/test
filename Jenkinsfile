#!/usr/bin/env groovy
pipeline {
    agent none
    stages {
	stage("test") {
	    agent {
		docker {
		    image 'maven:3.9.6-eclipse-temurin-17-alpine'
		}
	    }

	    steps {
		sh 'mvn clean package'
	    }
	}

	stage('deploying') {
	    agent any
	    steps {
		withCredentials([sshUserPrivateKey(credentialsId: 'vm-private-key', keyFileVariable: 'keyfile', usernameVariable: 'USERNAME')]) {
		    sh 'scp -v -o StrictHostKeyChecking=no -r -i $keyfile target/*.jar $USERNAME@3.104.117.169:fullnessof.com/'
		    }
	    }
	}
    }
}
